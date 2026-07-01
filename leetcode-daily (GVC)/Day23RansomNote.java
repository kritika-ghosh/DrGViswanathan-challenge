/**
 * Day 23: Ransom Note
 * Problem Link: https://leetcode.com/problems/ransom-note/
 */
public class Day23RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Optimization: If ransomNote is longer, magazine cannot contain it
        if (ransomNote.length() > magazine.length()) 
            return false;
            
        // Fixed-size frequency array for 26 lowercase English letters
        int[] alphabets_counter = new int[26];
        
        // Count frequencies of characters in the magazine
        for (char c : magazine.toCharArray()) {
            alphabets_counter[c - 'a']++;
        }
        
        // Verify and decrement counts for characters in the ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (alphabets_counter[c - 'a'] == 0) {
                return false; // Character missing or insufficient
            }
            alphabets_counter[c - 'a']--;
        }
        
        return true;
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        Day23RansomNote solver = new Day23RansomNote();

        System.out.println("--- Day 23: Ransom Note ---");

        // Test Case 1: Cannot construct because letter counts don't match
        String ransomNote1 = "a";
        String magazine1 = "b";
        boolean result1 = solver.canConstruct(ransomNote1, magazine1);
        System.out.println("Ransom Note: \"" + ransomNote1 + "\", Magazine: \"" + magazine1 + "\"");
        System.out.println("Can Construct: " + result1 + " (Expected: false)\n");

        // Test Case 2: Insufficient letter count
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        boolean result2 = solver.canConstruct(ransomNote2, magazine2);
        System.out.println("Ransom Note: \"" + ransomNote2 + "\", Magazine: \"" + magazine2 + "\"");
        System.out.println("Can Construct: " + result2 + " (Expected: false)\n");

        // Test Case 3: Successful construction
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        boolean result3 = solver.canConstruct(ransomNote3, magazine3);
        System.out.println("Ransom Note: \"" + ransomNote3 + "\", Magazine: \"" + magazine3 + "\"");
        System.out.println("Can Construct: " + result3 + " (Expected: true)");
    }
}