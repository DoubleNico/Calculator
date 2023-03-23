package me.tomescuvlad.calculator.button;

import me.tomescuvlad.calculator.button.impl.CalculatorButton;

import java.util.ArrayList;
import java.util.List;

public class ButtonManager {

    private final List<Button> buttons;

    public ButtonManager() {
        buttons = new ArrayList<>();
    }

    public void addButton(Button button){
        buttons.add(button);
    }

    public Button getButton(String name){
        for (Button button : buttons){
            if (button.getName().equalsIgnoreCase(name))
                return button;
        }
        return null;
    }

    public List<CalculatorButton> getCalculatorButtons(){
        List<CalculatorButton> calculatorButtons = new ArrayList<>();
        for (Button button : buttons){
            if (button.getType() == ButtonType.OPERATOR)
                calculatorButtons.add((CalculatorButton) button);
        }
        return calculatorButtons;
    }

    public List<Button> getButtons(){
        return buttons;
    }





}
