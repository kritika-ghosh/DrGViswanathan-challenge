package BasicMath;
public class reverse_number {
    public static int ReverseNumber(int n){
        int revNum = 0;
        while (n!=0) {
            int lastDigit = n % 10;
            if((long)revNum * 10 + lastDigit<(long)Math.pow(2, 31)-1 && (long)revNum * 10 + lastDigit>(long)Math.pow(-2, 31)){
            revNum = revNum * 10 + lastDigit;
        }
        else{
            return 0;
        }
            n = n / 10;
        }
        
        return revNum;
        
    }
    public static void main(String[] args) {
        int i=1534236469;
        int x= ReverseNumber(i);
        System.out.println(x);
    }
}
