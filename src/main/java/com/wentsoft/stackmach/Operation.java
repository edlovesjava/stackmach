package com.wentsoft.stackmach;

public class Operation extends Node {
    private Opcode   opcode;

    public Operation(Opcode opcode) {
        this.opcode = opcode;
    }
    public Opcode getOpcode() {
        return opcode;
    }  

    enum Opcode {
        ADD, 
        SUBTRACT,
        MULTIPLY,
        DIVIDE
        ;

    }

}