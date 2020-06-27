package Stack;

public class ReverseString {

    public static void main(String[] args) {
        String str = "car";
        char[] chars = str.toCharArray();
        Stack<Character> charStack = new Stack<Character>();
        for (char x : chars) {
            charStack.push(x);
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(charStack.pop());
        }
    }
}
