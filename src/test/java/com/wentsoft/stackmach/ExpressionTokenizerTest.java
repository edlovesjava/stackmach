package com.wentsoft.stackmach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


class ExpressionTokenizerTest {

    @Test
    void testTokenize() {
        String expression = "2 3 +";
        ArrayList<Node> tokens = (ArrayList<Node>) ExpressionTokenizer.tokenize(expression);
        assertEquals(3, tokens.size());
        assertTrue(tokens.get(0) instanceof Atom);
        assertTrue(tokens.get(1) instanceof Atom);
        assertTrue(tokens.get(2) instanceof Operation);
        assertEquals("number", ((Atom) tokens.get(0)).getType());
        assertEquals("2", ((Atom) tokens.get(0)).getValue());
        assertEquals("number", ((Atom) tokens.get(1)).getType());
        assertEquals("3", ((Atom) tokens.get(1)).getValue());
        assertEquals(Operation.Opcode.ADD, ((Operation) tokens.get(2)).getOpcode());
    }
}