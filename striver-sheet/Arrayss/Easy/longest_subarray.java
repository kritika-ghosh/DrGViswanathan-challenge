package Arrayss.Easy;
public class longest_subarray {
    public static int[] find_sub(int[] a, int k){
        int sl=0;
        int sr=0;
        //int it=0;
        int right=1;
        int left=0;
        int sum=0;
        int count;
        int max_count=Integer.MIN_VALUE;
        while(left<a.length && right<a.length){
            for (int i = left; i <=right; i++) {
                sum=sum+a[i];
            }
            if (sum==k) {
                count=right-left+1;
                max_count=Math.max(count,max_count);
                right++;
                sl=left;
                sr=right;
            }
            else if (sum<k){
                right++;
            }
            else if (sum>k) {
                left++;
            }
            sum=0;
        }
        int[] res=new int[max_count];
        int c=0;
        for (int i = sl; i <sr; i++) {
            res[c]=a[i];
            c++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a={10, 5, 2, 7, 1, 9};
        int k = 15;
        int[] res=find_sub(a,k);
        for (Object elem : res) {
            System.out.print(elem+" ");
        }

    }
}
