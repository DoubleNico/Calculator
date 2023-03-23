package me.tomescuvlad.calculator.button;

import java.awt.*;

public class Button implements IButton {

    private final String name;
    private final ButtonType type;
    private final CustomButton button;
    Font myFont = new Font("Ink Free",Font.BOLD,30);

    public Button(ButtonManager manager, String name, ButtonType type) {
        this.name = name;
        this.type = type;
        button = new CustomButton(name);
        button.setFont(myFont);
        button.setFocusable(false);
        manager.addButton(this);
    }

    public String getName() {
        return name;
    }

    public ButtonType getType() {
        return type;
    }

    public CustomButton getButton() {
        return button;
    }
}

