package com.wentsoft.stackmach;

import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // command line arguments
        if (args.length > 0) {
            String expression = args[0];
            System.out.println("Expression: " + expression);
            // Tokenize the expression
            var tokens = ExpressionTokenizer.tokenize(expression);
            //Evaluate the expression
            Evaluator evaluator = new Evaluator(new Stack<>());
            evaluator.evaluate(tokens);
            // Print the result
            System.out.println("Result: " + evaluator.getStackValue());
        } else {
            System.out.println("No expression provided.");
        }

    }
    
}


