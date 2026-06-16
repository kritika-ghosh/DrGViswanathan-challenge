public class Day8MinStack {
    private int[] stack;
    private int topIndex;

    public Day8MinStack() {
        // Upper bound constraint per problem specifications
        stack = new int[60002]; 
        topIndex = 0;
    }
    
    public void push(int val) {
        if (topIndex == 0) {
            stack[topIndex] = val;       // Store original value
            stack[topIndex + 1] = val;   // Store initial minimum
        } else {
            int currentMin = stack[topIndex - 1]; // Previous min is always at topIndex - 1
            stack[topIndex] = val;
            stack[topIndex + 1] = (val < currentMin) ? val : currentMin;
        }
        topIndex += 2; // Move forward by two slots
    }
    
    public void pop() {
        topIndex -= 2; // Revert pointer back by two slots
    }
    
    public int top() {
        return stack[topIndex - 2];
    }
    
    public int getMin() {
        return stack[topIndex - 1];
    }

    // Driver code to test Day 8 implementation
    public static void main(String[] args) {
        System.out.println("Initializing MinStack...");
        Day8MinStack minStack = new Day8MinStack();
        
        // Simulating sequence operations
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        System.out.println("Current Minimum (after pushing -2, 0, -3): " + minStack.getMin()); // Expected: -3
        
        minStack.pop();
        System.out.println("Top element after pop(): " + minStack.top());                    // Expected: 0
        System.out.println("Current Minimum after pop(): " + minStack.getMin());             // Expected: -2
    }
}