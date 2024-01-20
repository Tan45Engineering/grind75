import java.util.Arrays;

/*Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
*/
public class _64TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        //array to store the frequency
        int[] taskFrequency = new int[26];

        //count the freq for each task
        for(char task: tasks){
            taskFrequency[task - 'A']++;
        }

        //sort the task freq in the ascending order
        Arrays.sort(taskFrequency); // [0 0 0 0 0 0 1.... 3 3]

        //get the max freq
        int maxFrequency = taskFrequency[25];

        //calculate the idle slots based on max freq
        int idleSlots = (maxFrequency - 1) * n;

        //iterate over task frequencies in descending order
        for(int i = 24; i >= 0 && taskFrequency[i] > 0; i--){
            //distribute the idle slots among other tasks with freq less than the max
            idleSlots -= Math.min(maxFrequency - 1, taskFrequency[i]);
        }

        //the result is either the total number of tasks, or total number of tasks plus idle slots
        return Math.max(tasks.length, tasks.length + idleSlots);
    }

    public static void main(String args[]){
        _64TaskScheduler obj = new _64TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(obj.leastInterval(tasks, n));
    }
}
