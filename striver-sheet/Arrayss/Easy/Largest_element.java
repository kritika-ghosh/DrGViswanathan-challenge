package Arrays;

public class Largest_element {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int max=0;
        for (int idx = 0; idx < a.length; idx++) {
            if(max<a[idx]){
                max=a[idx];
            }
        }
        System.out.println(max);
    }
}
