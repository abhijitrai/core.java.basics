package java.core.basics;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {1,2,3,51,4,6,34,56,87,22,45,76,43};
        Arrays.stream(arr).forEach(x->System.out.print( x + " "));
        int [] result= sort(arr);
        System.out.println();
        Arrays.stream(result).forEach(x->System.out.print( x + " "));
    }

    public static int[] sort( int [] arr ){
        int size = arr.length;
        if(size == 1)
        {
            return arr;
        }else if( size == 2)
        {
            if(arr[1] < arr[0]){
                int temp = arr[0];
                arr[0]=arr[1] ;
                arr[1] = temp ;
            }
            return arr;
        }
        int smallerSize = (int) Math.floor(arr.length/2);
        int [] leftArr = sort(Arrays.copyOfRange(arr,0,smallerSize));
        int [] rightArr = sort(Arrays.copyOfRange(arr,smallerSize  ,arr.length));
        int [] result = merge(leftArr , rightArr);
        return result ;
    }

    public static int[] merge(int[]left, int[]right){
        // Iterate and get the result
        int [] result = new int[left.length + right.length] ;
        int leftCounter =0,rightCounter=0;
        for( int k=0; k<left.length+right.length ; k++ ){

            if(leftCounter> left.length-1){
                result[k]=right[rightCounter];
                rightCounter++;
            }
            else if(rightCounter>right.length-1){
                result[k]=left[leftCounter];
                leftCounter++;
            }
            else if(left[leftCounter] < right[rightCounter]){
                result[k]= left[leftCounter];
                leftCounter++;
            }else
            {
                result[k]=right[rightCounter];
                rightCounter++;
            }
        }
        return result;
    }


}
