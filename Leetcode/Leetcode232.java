// LEetcode 232 Implement que -> Stack
import java.util.*;
public class Leetcode232{
class MyQueue {
    Stack input;
    Stack output;
    public MyQueue() {
        input=new Stack<>();
        output=new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if(!output.isEmpty()){
            return (int) output.pop();
        }
        else{
            while(!input.isEmpty()){
                output.push(input.pop());
            }
            return (int) output.pop();
        }
    }

    public int peek() {
        int ans=pop();
        output.push(ans);
        return ans;
    }

    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}
}