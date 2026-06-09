package Arrays;

public class find_num_appear_once {
    public static int find(int[] a){
        int res=a[0];
        for (int idx = 1; idx < a.length; idx++) {
            res=res^a[idx];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a={4,1,2,1,2};
        int res=find(a);
        System.out.println(res);
    }
}
