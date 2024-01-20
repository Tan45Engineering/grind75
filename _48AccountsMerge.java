import java.util.*;

/*Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.



Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]*/
public class _48AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //map for emails and indexes
        Map<String, Integer> emailIndex = new HashMap<>();

        //map for email -> name
        Map<String, String> emailToName = new HashMap<>();

        //Parent array for the DSU
        int[] parent = new int[10000];
        for(int i = 0; i < 10000; i++){
            //parent of each node is the node itself
            parent[i] = i;
        }

        int id = 0;
        for(List<String> account: accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                String currentEmail = account.get(i);
                if(!emailIndex.containsKey(currentEmail)){
                    emailIndex.put(currentEmail, id++);
                    emailToName.put(currentEmail, name);
                }

                //union the first email and the current email
                int firstEmailIdx = emailIndex.get(account.get(1));
                int currentEmailIdx = emailIndex.get(currentEmail);
                union(firstEmailIdx, currentEmailIdx, parent);
            }
        }

        //grouping emails together
        Map<Integer, TreeSet<String>> groups = new HashMap<>();
        for(String email: emailIndex.keySet()){
            int root = find(emailIndex.get(email), parent);
            groups.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for(TreeSet<String> group: groups.values()){
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(group.first()));
            account.addAll(group);
            result.add(account);
        }

        return result;
    }

    //find operation with path compression
    private int find(int x, int[] parent){
        int p = parent[x];
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private void union(int x, int y, int[] parent){
        parent[find(x, parent)] = find(y, parent);
    }

    public static void main(String args[]){
        _48AccountsMerge obj = new _48AccountsMerge();
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );
        System.out.println(obj.accountsMerge(accounts));
    }
}
