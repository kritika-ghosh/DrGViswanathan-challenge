package Arrayss.Easy;

public class find_missing_number {
    public static int find_missing(int[] a){
        int alen=a.length;
        int sum=0;
        for (int elem : a) {
            sum=sum+elem;
        }
        int expected_sum=alen*(alen+1)/2;
        int missing_num=expected_sum-sum;
        return missing_num;
    }
    public static void main(String[] args) {
        int[] a= {2, 6, 5, 3, 4, 1};
        int res=find_missing(a);
        System.out.println(res);
    }
}
