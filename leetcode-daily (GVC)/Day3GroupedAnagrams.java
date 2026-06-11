import java.util.*;

public class Day3GroupedAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Handle edge case of empty or null input
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        // Map to store the sorted string as key and the list of anagrams as value
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String s : strs) {
            // Convert string to character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);

            // If the key doesn't exist, initialize a new list
            if (!anagramMap.containsKey(sortedKey)) {
                anagramMap.put(sortedKey, new ArrayList<>());
            }
            
            // Add the original string to the corresponding anagram group
            anagramMap.get(sortedKey).add(s);
        }

        // Return all the grouped values as a list of lists
        return new ArrayList<>(anagramMap.values());
    }

    // Driver code to test the implementation
    public static void main(String[] args) {

        // Test Case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Output: " + groupAnagrams(strs1));
        System.out.println();

        // Test Case 2
        String[] strs2 = {""};
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Output: " + groupAnagrams(strs2));
        System.out.println();

        // Test Case 3
        String[] strs3 = {"a"};
        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Output: " + groupAnagrams(strs3));
    }
}