package me.tomescuvlad.calculator.button.impl;

import me.tomescuvlad.calculator.Operations;
import me.tomescuvlad.calculator.button.Button;
import me.tomescuvlad.calculator.button.ButtonManager;
import me.tomescuvlad.calculator.button.ButtonType;

public class CalculatorButton extends Button {

    private final Operations operation;

    public CalculatorButton(ButtonManager manager, String name, Operations operation){
        super(manager, name, ButtonType.OPERATOR);
        this.operation = operation;
    }

    public Operations getOperation() {
        return operation;
    }

}
