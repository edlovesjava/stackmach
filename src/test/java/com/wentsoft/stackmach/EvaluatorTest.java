package com.wentsoft.stackmach;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EvaluatorTest {

  
    @Test
    public void testAddition() {
        Stack<Object> stack = new Stack<>();
        Evaluator evaluator = new Evaluator(stack);
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Atom("number", "2"));
        nodes.add(new Atom("number", "3"));
        nodes.add(new Operation(Operation.Opcode.ADD));
        evaluator.evaluate(nodes);
        assertEquals(5, stack.pop());
    }

    @Test
    public void testSubtraction() {
        Stack<Object> stack = new Stack<>();
        Evaluator evaluator = new Evaluator(stack);
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Atom("number", "2"));
        nodes.add(new Atom("number", "3"));
        nodes.add(new Operation(Operation.Opcode.SUBTRACT));
        evaluator.evaluate(nodes);
        assertEquals(1, stack.pop());
    }
    @Test
    public void testMultiplication() {
        Stack<Object> stack = new Stack<>();
        Evaluator evaluator = new Evaluator(stack);
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Atom("number", "2"));
        nodes.add(new Atom("number", "3"));
        nodes.add(new Operation(Operation.Opcode.MULTIPLY));
        evaluator.evaluate(nodes);
        assertEquals(6, stack.pop());
    }
    @Test
    public void testDivision() {
        Stack<Object> stack = new Stack<>();
        Evaluator evaluator = new Evaluator(stack);
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Atom("number", "2"));
        nodes.add(new Atom("number", "3"));
        
        nodes.add(new Operation(Operation.Opcode.DIVIDE));
        evaluator.evaluate(nodes);
        assertEquals(1, stack.pop());
    }
    @Test
    public void testComplexExpression() {
        Stack<Object> stack = new Stack<>();
        Evaluator evaluator = new Evaluator(stack);
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Atom("number", "2"));
        nodes.add(new Atom("number", "3"));
        nodes.add(new Atom("number", "4"));
        nodes.add(new Operation(Operation.Opcode.ADD));
        nodes.add(new Operation(Operation.Opcode.SUBTRACT));

        evaluator.evaluate(nodes);

        assertEquals(5, stack.pop());
    }
}