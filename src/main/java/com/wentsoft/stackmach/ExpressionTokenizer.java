package com.wentsoft.stackmach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpressionTokenizer {

    public static List<Node> tokenize(String expression) {
        List<Node> tokens = new ArrayList<>();
        Scanner scanner = new Scanner(expression);
        
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                tokens.add(new Atom("number",scanner.nextInt() + "")); // Convert int to String
            } else if (scanner.hasNext("\\+|-|\\*|/|\\(|\\)")) {
                tokens.add(parseOperation(scanner.next("\\+|-|\\*|/|\\(|\\)")));
            } else {
                scanner.next(); // Skip invalid characters
            }
        }
        scanner.close();
        return tokens;
    }

    private static Node parseOperation(String next) {
        return switch (next) {
            case "+" -> new Operation(Operation.Opcode.ADD);
            case "-" -> new Operation(Operation.Opcode.SUBTRACT);
            case "*" -> new Operation(Operation.Opcode.MULTIPLY);
            case "/" -> new Operation(Operation.Opcode.DIVIDE);
            default -> throw new IllegalArgumentException("Invalid operation: " + next);
        };
    }
}