package java.core.basics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueue
{
    Queue queue1 = new LinkedList();
    Queue queue2 = new LinkedList();

    public static void main(String[] args) {

        int [] arr = {1,3,5,68,3,2,45,34,56,24};
        StackFromQueue stk = new StackFromQueue();
        Arrays.stream(arr).forEach(
                x -> stk.push(x)
        );
        Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
        System.out.println();
        while(!stk.isEmpty()){
            System.out.print(stk.pop() + " ");
        }
    }

    private Queue[] getQueue(){
        Queue primary , secondary;
        if(queue2.size()==0 ){
            primary = queue2;
            secondary = queue1;
        }else{
            primary = queue1;
            secondary = queue2;
        }
        return(new Queue[]{primary,secondary});
    }


    public void push(int elem){
        Queue primary , secondary;
        primary =   this.getQueue()[0];
        secondary= getQueue()[1];
        primary.add(elem);
        while(!secondary.isEmpty()){
            primary.add(secondary.remove());
        }
    }

    public int pop(){
        Queue primary = getQueue()[1];
        return (int) primary.remove();
    }

    public boolean isEmpty(){
        return getQueue()[1].isEmpty();
    }

}
