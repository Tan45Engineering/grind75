/*Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"*/
public class _20AddBinary {
    public String addBinary(String a, String b) {
        //initialize indices i and j to the last positions of string a and b
        int i = a.length()-1;
        int j = b.length()-1;

        //initialize carry and stringbuilder
        int carry = 0;
        StringBuilder result = new StringBuilder(); // "10101"

        //loop conditions
        //1. i is greater than or equal to 0
        //2. j is greater than or equla to 0
        //3. there is a carry from previous addition
        while(i >= 0 || j >= 0 || carry > 0){
            //get the binary digit from string a if i is in bounds
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0; // 0
            //get the binary digit from string b if i is in bounds
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0; // 0

            //calculate sum
            int sum = bitA + bitB + carry; //0 + 0 + 1 = 1

            //insert the least significant nit of the sum at the beginning of the result
            result.insert(0, sum%2);

            //calculate carry for next position
            carry = sum/2; // 0
        }

        return result.toString();
    }

    public static void main(String args[]){
        _20AddBinary obj = new _20AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(obj.addBinary(a, b));
    }
}

//  1 1
//a = 1010,
//b = 1011
// =  10101

// 1 = 0001
// 2 = 0010
