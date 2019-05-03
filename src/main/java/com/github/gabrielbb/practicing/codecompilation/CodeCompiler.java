package com.github.gabrielbb.practicing.codecompilation;

import com.github.gabrielbb.practicing.structures.Stack;
import com.github.gabrielbb.practicing.structures.impl.StackImpl;

public class CodeCompiler {

    private static final String KEYS = "{}[]()";

    public static void compile(String code) throws Exception {
        Stack<Character> stack = new StackImpl<>(code.length());

        for (char c : code.toCharArray()) {
            int index = KEYS.indexOf(c);

            if (index > -1) { // If this char is actually a key
                char currentKey = KEYS.charAt(index);
                boolean isOpening = index % 2 == 0;

                if (isOpening) { // Is an opening key (example: "{") ?
                    stack.push(currentKey);
                } else {
                    if (stack.isEmpty()) {
                        throw new FailedCompilationException("Missing opening key for: " + currentKey);
                    }

                    char lastOpeningKey = stack.pop(); // If it is a closing key, let's get the last opening key

                    // Does the last opening key match with ("current character index" - 1) in the
                    // KEYS string?
                    if (KEYS.charAt(index - 1) != lastOpeningKey) {
                        // If not, this code can't compile. Developer is Missing a matchable opening key
                        throw new FailedCompilationException(
                                currentKey + " closing key doesn't match " + lastOpeningKey + " opening key");
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            throw new FailedCompilationException("Missing closing key for: " + stack.pop());
        }
    }
}