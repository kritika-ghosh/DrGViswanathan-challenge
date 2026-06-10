package Arrayss.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class majority_element {
    public static int majelem(int[] a){
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int targetKey=0;
        int targetValue=Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            targetValue=Math.max(targetValue, entry.getValue());
            if (Objects.equals(entry.getValue(), targetValue)) {
                targetKey = entry.getKey();
            }
        }
        
        return targetKey;
    }
    public static void main(String[] args) {
        int[] a={7, 0, 0, 1, 7, 7, 2, 7, 7};
        int res=majelem(a);
        System.out.println(res);
    }
}
