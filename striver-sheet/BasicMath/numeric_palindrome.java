package BasicMath;
public class numeric_palindrome {
    public static boolean isPalindrome(int x) {
        String s= String.valueOf(x);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==(s.charAt(s.length()-i-1))){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int i=121;
        boolean j=isPalindrome(i);
        System.out.println(j);
    }
}
