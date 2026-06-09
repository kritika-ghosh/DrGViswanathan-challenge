package Arrays;

public class Remove_Duplicates {
    static int[] remove_duplicates(int[] arr){
        int[] res=new int[arr.length];
        res[0]=arr[0];
        int c=1;
        for (int idx = 1; idx < arr.length; idx++) {
            if(arr[idx]!=arr[idx-1]){
                res[c]=arr[idx];
                c=c+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a ={1,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5};
        int[] result=remove_duplicates(a);
        for (int elem : result) {
            System.out.print(elem);
            System.out.print(",");

        }
    }
}
