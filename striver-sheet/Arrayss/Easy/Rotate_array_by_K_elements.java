package Arrays;
public class Rotate_array_by_K_elements {
    static int[] shift(int[] arr, String dir, int s){
        if (dir.equalsIgnoreCase("left")) {
            int[] store=new int[s];
            for (int i=0;i<store.length; i++) {
                store[i]=arr[i];
            }
            for (int i = 0; i < arr.length-s; i++) {
                arr[i]=arr[i+s];
            }
            for (int i=0;i<store.length; i++) {
                arr[arr.length-i-1]=store[i];
            }
            return arr;
        } else {
            int[] store= new int[s];
            for (int i = 0; i < store.length; i++) {
                store[i]=arr[arr.length-i-1];
            }
            for (int i = arr.length-1; i >=0+s; i--) {
                arr[i]=arr[i-s];
            }
            for (int i = 0; i < store.length; i++) {
                arr[i]=store[store.length-i-1];
            }
            return arr;
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] res=shift(a, "right", 2);
        for (Object elem : res) {
            System.out.println(elem);
        }

    }
}
