package java.core.basics;

import java.util.Arrays;
import java.util.Stack;

public class StackReverser {

    public static void main(String[] args) {
        final Stack stk = new Stack();
        int [] arr = {1,3,5,68,3,2,45,34,56,24};

        Arrays.stream(arr).forEach(
                x -> stk.push(x)
        );
        System.out.println(stk);
        Stack stk2 = reverse(stk);
        System.out.println(stk2);
    }

    public static Stack reverse(Stack stk ){

        if(stk.size()==1)
            return stk;

        int elem = (int) stk.pop();
        stk = reverse(stk);
        insert(stk,elem);
        return stk;
    }

    public static void insert(Stack stk, int elem )
    {

        if(stk.empty() )
        {
            stk.push(elem);
        }
        else
        {
            int elem2 = (int) stk.pop();
            insert(stk,elem);
            stk.push(elem2);
        }
    }
}
