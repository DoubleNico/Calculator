package me.tomescuvlad.calculator;

public enum Operations {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char operator;
    Operations(char operator) {
        this.operator = operator;
    }

    public char getSymbol() {
        return operator;
    }

}
