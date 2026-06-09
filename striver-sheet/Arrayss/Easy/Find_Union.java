package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Find_Union {
    static List<Integer>  funion(int[] a, int[] b){
        List<Integer> Union = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                Union.add(a[i]);
            }
            else{
                Union.add(a[i]);
                Union.add(b[j]);
            }
            i++;
            j++;
        }
        return Union;
    }
    public static void main(String[] args) {
        int[] a={1,2,3};
        int[] b={3,4,5};
        List<Integer>  c=funion(a,b);
        System.out.println(c);
    }
}
