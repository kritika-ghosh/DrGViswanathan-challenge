/**
 * Day 32: Valid Anagram
 * Problem Link: https://leetcode.com/problems/valid-anagram/
 */
public class Day32ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // Optimization: Different lengths mean they can't be anagrams
        if (s.length() != t.length())
            return false;
s
        // Fixed-size frequency tracker for 26 lowercase English letters
        int[] arr = new int[26];

        // Increment for string s and decrement for string t simultaneously
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        // Check if all character buckets balanced out to exactly zero
        for (int check : arr) {
            if (check != 0)
                return false;
        }

        return true;
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day32ValidAnagram solver = new Day32ValidAnagram();

        System.out.println("--- Day 32: Valid Anagram ---");

        // Test Case 1: True Anagram
        String s1 = "anagram";
        String t1 = "nagaram";
        boolean result1 = solver.isAnagram(s1, t1);
        System.out.println("String s: \"" + s1 + "\", String t: \"" + t1 + "\"");
        System.out.println("Is Anagram: " + result1 + " (Expected: true)\n");

        // Test Case 2: False Anagram (Same characters but different counts)
        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solver.isAnagram(s2, t2);
        System.out.println("String s: \"" + s2 + "\", String t: \"" + t2 + "\"");
        System.out.println("Is Anagram: " + result2 + " (Expected: false)\n");

        // Test Case 3: Length Mismatch
        String s3 = "hello";
        String t3 = "hell";
        boolean result3 = solver.isAnagram(s3, t3);
        System.out.println("String s: \"" + s3 + "\", String t: \"" + t3 + "\"");
        System.out.println("Is Anagram: " + result3 + " (Expected: false)");
    }
}