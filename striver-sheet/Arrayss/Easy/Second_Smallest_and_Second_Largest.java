package Arrays;

public class Second_Smallest_and_Second_Largest {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int max=0;
        int max2=0;
        int min=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (max<a[i]) {
                max2=max;
                max=a[i];
            }
            if (min>a[i]) {
                min2=min;
                min=a[i];
            }
            else if (a[i] < min2 && a[i] != min) {
                min2 = a[i];
            }
        }
        System.out.println(max2);
        System.out.println(max);
        System.out.println(min);
        System.out.println(min2);
    }
}
