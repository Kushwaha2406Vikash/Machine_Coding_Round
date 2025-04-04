package data_structure.stack;

import java.util.*;

public class StackUsingQueue {

    Queue<Integer>q1;
    Queue<Integer>q2;

    public StackUsingQueue(){
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }

    public void Push(int val){

        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        q1.offer(val);

        while (!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }

    public int Peek(){
        if(q1.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return q1.peek();

    }

    public int Poll(){
        if(q1.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return q1.poll();

    }

    public static void main(String[] args) {

        StackUsingQueue sq=new StackUsingQueue();
        sq.Push(1);
        sq.Push(2);
        sq.Push(3);
        sq.Push(4);
        sq.Push(5);

        System.out.println(sq.Peek());
        System.out.println(sq.Poll());
        System.out.println(sq.Poll());
        System.out.println(sq.Peek());
    }
}
