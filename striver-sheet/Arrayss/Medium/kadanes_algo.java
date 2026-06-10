package Arrayss.Medium;
public class kadanes_algo {
    public static int kadanes(int[] arr){
        int[] presum=new int[arr.length];
        presum[0]=0;
        for (int idx = 1; idx < arr.length; idx++) {
            presum[idx]=presum[idx-1]+arr[idx-1];
        }
        int[] postsum=new int[arr.length];
        postsum[arr.length-1]=0;
        for (int idx = arr.length-2; idx>=0; idx++) {
            postsum[idx]=postsum[idx+1]+arr[idx];
        }

        int i=0;
        while(i<arr.length){
            if (postsum[i]==presum[i]) {
                return arr[i];
            }
            i++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] a={-7, 1, 5, 2, -4, 3, 0};
        int res=kadanes(a);
        System.out.println(res);
    }
    //mple ExecutionFor array \(A = []\)
}
