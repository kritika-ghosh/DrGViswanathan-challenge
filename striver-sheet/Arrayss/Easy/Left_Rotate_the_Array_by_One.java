package Arrayss.Easy;
public class Left_Rotate_the_Array_by_One {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int first_elem=arr[0];
        for (int idx = 0; idx < arr.length-1; idx++) {
            arr[idx]=arr[idx+1];
        }
        arr[arr.length-1]=first_elem;
        for (int elem : arr) {
            System.out.println(elem);
        }
    }
}
