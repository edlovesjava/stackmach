package com.wentsoft.stackmach;

class Atom extends Node {
    private String type;
    private String value;

    public Atom(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
