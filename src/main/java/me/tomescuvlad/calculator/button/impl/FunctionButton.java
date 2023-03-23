package me.tomescuvlad.calculator.button.impl;

import me.tomescuvlad.calculator.button.Button;
import me.tomescuvlad.calculator.button.ButtonManager;
import me.tomescuvlad.calculator.button.ButtonType;

public class FunctionButton extends Button {

    public FunctionButton(ButtonManager manager, String name) {
        super(manager, name, ButtonType.FUNCTION);
    }

}
