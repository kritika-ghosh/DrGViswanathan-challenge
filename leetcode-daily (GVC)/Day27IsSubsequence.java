/**
 * Day 27: Is Subsequence
 * Problem Link: https://leetcode.com/problems/is-subsequence/
 */
public class Day27IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        
        // An empty string is always a subsequence of any string
        if (n1 == 0) return true;
        
        // If s is longer than t, it cannot be a subsequence
        if (n1 > n2) return false;
        
        int idx = 0;

        for (int i = 0; i < n2; i++) {
            // If characters match, move the pointer for s
            if (t.charAt(i) == s.charAt(idx)) {
                idx++;
            }
            // If we have matched all characters in s, return true
            if (idx == n1) return true;
        }
        
        return (idx == n1);
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day27IsSubsequence solver = new Day27IsSubsequence();

        System.out.println("--- Day 27: Is Subsequence ---");

        // Test Case 1: Standard true case
        String s1 = "abc", t1 = "ahbgdc";
        System.out.println("s: " + s1 + ", t: " + t1);
        System.out.println("Is Subsequence: " + solver.isSubsequence(s1, t1) + " (Expected: true)\n");

        // Test Case 2: Standard false case
        String s2 = "axc", t2 = "ahbgdc";
        System.out.println("s: " + s2 + ", t: " + t2);
        System.out.println("Is Subsequence: " + solver.isSubsequence(s2, t2) + " (Expected: false)\n");

        // Test Case 3: Empty string case
        String s3 = "", t3 = "ahbgdc";
        System.out.println("s: \"" + s3 + "\", t: " + t3);
        System.out.println("Is Subsequence: " + solver.isSubsequence(s3, t3) + " (Expected: true)\n");

        // Test Case 4: s is longer than t
        String s4 = "abcde", t4 = "abc";
        System.out.println("s: " + s4 + ", t: " + t4);
        System.out.println("Is Subsequence: " + solver.isSubsequence(s4, t4) + " (Expected: false)");
    }
}