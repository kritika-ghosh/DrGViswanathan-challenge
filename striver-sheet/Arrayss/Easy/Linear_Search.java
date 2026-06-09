package Arrayss.Easy;

public class Linear_Search {
    static int Linearsearch(int[] arr, int k){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==k){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int k= Linearsearch(a,2);
        System.out.println(k);
    }
}
