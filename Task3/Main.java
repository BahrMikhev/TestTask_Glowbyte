import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            char[] s = reader.readLine().toCharArray();
            reader.close();

            int n = s.length;
            Stack<Character> st = new Stack<>();
            boolean answer = true;

            for (int i = 0; i < n; i++) {
                if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
                    st.push(s[i]);
                } else if (!st.empty()) {
                    if (s[i] == ')' && st.peek() == '(') {
                        st.pop();
                    } else {
                        if (s[i] == ']' && st.peek() == '[') {
                            st.pop();
                        } else {
                            if (s[i] == '}' && st.peek() == '{') {
                                st.pop();
                            } else {
                                answer = false;
                                break;
                            }
                        }
                    }
                } else {
                    answer = false;
                    break;
                }
            }
            if (answer && st.size() == 0) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
