package Arrayss.Easy;
public class Array_is_Sorted {

    static boolean is_sorted(int[] arr){
        boolean flag=true;
        for (int idx = 0; idx < arr.length-1; idx++) {
            if(arr[idx]>arr[idx+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        int[] a={1,2,3,5,4};
        if(is_sorted(a)){
            System.out.println("is sorted");
        }
        else{
            System.out.println("is not sorted");
        }
    }
}
