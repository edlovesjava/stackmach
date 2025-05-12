package com.wentsoft.stackmach;

import java.util.List;
import java.util.Stack;

/**
 * Evaluator class to evaluate expression in postfix notation.
 * This class is responsible for evaluating the nodes in the stack.
 */
class Evaluator {
    private Stack<Object> stack;

    public Evaluator(Stack<Object> stack) {
        this.stack = stack;
    }

    public Stack<Object> getStack() {
        return stack;
    }

    public void evaluate(List<Node> nodes) {
        // Evaluate the nodes
        for (Node node : nodes) {
            if (node instanceof Atom atom) {
                System.out.println("Evaluating atom: " + atom.getValue());
            
                switch (atom.getType()) {
                    case "number" ->  stack.push( Integer.valueOf(atom.getValue()));
                    case "string" -> stack.push(atom.getValue());    
                    case "boolean" -> stack.push(Boolean.valueOf(atom.getValue()));
                    default -> {
                        System.out.println("Error: Unknown atom type");
                    }
                }
        
            } else if (node instanceof Operation op) {
                System.out.println("Evaluating expression with opcode: " + op.getOpcode());
                // Handle the expression based on its opcode
                
                if (null != op.getOpcode()) {
                    switch (op.getOpcode()) {
                    case ADD:{
                        // Pop two values from the stack and add them
                        Object value1 = stack.pop();
                        Object value2 = stack.pop();
                        if (value1 instanceof Integer && value2 instanceof Integer) {
                            // Convert the values to integers and add them
                            
                            int result = (Integer) value1 + (Integer) value2;
                            stack.push(result);
                        } else {
                            System.out.println("Error: Invalid types for addition");
                        }       break;
                        }
                    case SUBTRACT:{
                        // Pop two values from the stack and subtract them
                        Object value1 = stack.pop();
                        Object value2 = stack.pop();
                        if (value1 instanceof Integer && value2 instanceof Integer) {
                            int result = (Integer) value1 - (Integer) value2;
                            stack.push(result);
                        } else {
                            System.out.println("Error: Invalid types for subtraction");
                        }       break;
                        }
                    case MULTIPLY:{
                        // Pop two values from the stack and multiply them
                        Object value1 = stack.pop();
                        Object value2 = stack.pop();
                        if (value1 instanceof Integer && value2 instanceof Integer) {
                            int result = (Integer) value1 * (Integer) value2;
                            stack.push(result);
                        } else {
                            System.out.println("Error: Invalid types for multiplication");
                        }       break;
                        }
                    case DIVIDE:{
                        // Pop two values from the stack and divide them
                        Object value1 = stack.pop();
                        Object value2 = stack.pop();
                        if (value1 instanceof Integer && value2 instanceof Integer) {
                            int result = (Integer) value1 / (Integer) value2;
                            stack.push(result);
                        } else {
                            System.out.println("Error: Invalid types for division");
                        }       break;
                        }
                    default:
                        break;
                }
            }
                
            }
        }
    }

    Object getStackValue() {
        return getStack().peek();
    }
}