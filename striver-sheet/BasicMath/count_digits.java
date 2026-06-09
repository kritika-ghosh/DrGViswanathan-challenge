package BasicMath;

public class count_digits {
    public static int countDigits(int a){
        return (int)Math.log10(a)+1;
    }
    public static void main(String args[]){
        int i= 12345;
        int res=countDigits(i);
        System.out.println(res);
    }
}
