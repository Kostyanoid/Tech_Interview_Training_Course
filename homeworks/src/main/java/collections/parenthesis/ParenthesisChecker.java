package collections.parenthesis;

import collections.stack.IStack;
import collections.stack.StackByLinkedList;

import java.util.HashMap;
import java.util.Map;

public class ParenthesisChecker {
    private final String checkingString;
    private final IStack parenthesisHolder;
    private boolean balanced;
    private static final Map<Character, Character> parenthesis = new HashMap<Character, Character>();
    static {
        parenthesis.put(')', '(');
        parenthesis.put(']', '[');
        parenthesis.put('}', '{');
    }

    public ParenthesisChecker(String checkingString) {
        this.checkingString = checkingString;
        this.parenthesisHolder = new StackByLinkedList();
    }

    public String getCheckingString() {
        return checkingString;
    }

    public boolean isBalanced() {
        return balanced;
    }

    public boolean checkParenthesis() {
        if (checkingString == null) return balanced = false;
        for (int i = 0; i < checkingString.length(); i++) {
            char c = checkingString.charAt(i);
            if (parenthesis.values().contains(c)) {
                parenthesisHolder.push(c);
                continue;
            }

            if (parenthesis.keySet().contains(c)) {
                if (parenthesisHolder.isEmpty() || (char) parenthesisHolder.peek() != parenthesis.get(c)) return balanced = false;
                parenthesisHolder.pop();
            }
        }
        return balanced = parenthesisHolder.isEmpty();
    }

}
