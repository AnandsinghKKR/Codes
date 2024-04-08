// Number of Students Unable to Eat Lunch

public class Leetcode1700 {
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer>sandwich=new Stack<>();
        Queue<Integer>student= new ArrayDeque<>();
        
        int []arr=new int[2];
        
        for(int i=0;i<students.length;i++){
            student.add(students[i]);
            
            sandwich.add(sandwiches[sandwiches.length-1-i]);
            if(students[i]==0){
                arr[0]++;
            }
            else{
                arr[1]++;
            }
        }
       while(sandwich.size() !=0 && arr[sandwich.peek()]!=0){
            if(Objects.equals(student.peek(), sandwich.peek())){
                sandwich.pop();
                arr[student.poll()]--;
            }
            else{
                student.add(student.poll());
            }
        }
        return student.size();
    }
}
}
