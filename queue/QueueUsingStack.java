package data_structure.queue;
import java.util.*;
public class QueueUsingStack {

    Stack<Integer>s1;
    Stack<Integer>s2;

    public QueueUsingStack(){
        s1=new Stack<>();
        s2=new Stack<>();
    }


    public void add(int value){



        while (!s1.isEmpty()){
            s2.add(s1.pop());
        }
        s1.push(value);

        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int top(){

        if(s1.isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return s1.peek();
    }

    public int remove(){

        if(s1.isEmpty()){

            System.out.println("Stack is Empty");
            return -1;
        }

        return s1.pop();

    }

    public static void main(String[] args) {



        QueueUsingStack qs = new QueueUsingStack();
        qs.add(1);
        qs.add(2);
        qs.add(3);

        System.out.println(qs.top());     // Output: 1
        System.out.println(qs.remove());  // Output: 1
        System.out.println(qs.remove());  // Output: 2
        System.out.println(qs.top());     // Output: 3


    }

}
