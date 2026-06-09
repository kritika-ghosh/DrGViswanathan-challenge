package Arrayss.Easy;

public class consecutive_ones {
    public static int consec_ones(int[] a){
        int count=0;
        int max_count=Integer.MIN_VALUE;
        for (int idx = 0; idx < a.length; idx++) {
            if (a[idx]==1){
                count++;
            }
            else{
                max_count=Math.max(count,max_count);
                count=0;
            }
        }
        max_count=Math.max(count,max_count);
        return max_count;
    }
    public static void main(String[] args) {
        int[] a={1,1,1,1,0,1,1,1,1,1,0,0};
        int res= consec_ones(a);
        System.out.println(res);
    }
}
