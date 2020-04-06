import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome(String world) {
        char[] letters = world.toLowerCase().toCharArray();
        Stack stack = new Stack();
        for (Character c: letters) {
            stack.add(c);
        }

        for (int i = 0; i < world.length(); i++) {
            Character letter = letters[i];
            if (letter != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
