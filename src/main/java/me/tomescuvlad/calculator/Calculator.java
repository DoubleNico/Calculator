package me.tomescuvlad.calculator;

import me.tomescuvlad.calculator.button.ButtonManager;
import me.tomescuvlad.calculator.button.impl.CalculatorButton;
import me.tomescuvlad.calculator.button.impl.FunctionButton;
import me.tomescuvlad.calculator.button.impl.NumbersButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    CalculatorButton addButton,subButton,mulButton,divButton;
    FunctionButton decButton, equButton, delButton, clrButton, negButton;
    NumbersButton[] numberButtons = new NumbersButton[10];
    JPanel panel;
    Font myFont = new Font("Ink Free",Font.BOLD,30);
    private final ButtonManager buttonManager = new ButtonManager();

    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setResizable(false);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setSelectionColor(Color.blue);
        textfield.setEditable(false);

        addButton = new CalculatorButton(buttonManager, "+", Operations.ADDITION);
        subButton = new CalculatorButton(buttonManager, "-", Operations.SUBTRACTION);
        mulButton = new CalculatorButton(buttonManager, "*", Operations.MULTIPLICATION);
        divButton = new CalculatorButton(buttonManager, "/", Operations.DIVISION);
        decButton = new FunctionButton(buttonManager, ".");
        equButton = new FunctionButton(buttonManager,"=");
        delButton = new FunctionButton(buttonManager, "Delete");
        clrButton = new FunctionButton(buttonManager, "Clear");
        negButton = new FunctionButton(buttonManager, "(-)");
        for(int i =0;i<10;i++) {
            numberButtons[i] = new NumbersButton(buttonManager, String.valueOf(i));
        }

        buttonManager.getButtons().forEach(button -> button.getButton().addActionListener(this));

        negButton.getButton().setBounds(330,28,70,45);
        delButton.getButton().setBounds(0,430,150,50);
        clrButton.getButton().setBounds(270,430,150,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,30,30));

        panel.add(numberButtons[1].getButton());
        panel.add(numberButtons[2].getButton());
        panel.add(numberButtons[3].getButton());
        panel.add(addButton.getButton());
        panel.add(numberButtons[4].getButton());
        panel.add(numberButtons[5].getButton());
        panel.add(numberButtons[6].getButton());
        panel.add(subButton.getButton());
        panel.add(numberButtons[7].getButton());
        panel.add(numberButtons[8].getButton());
        panel.add(numberButtons[9].getButton());
        panel.add(mulButton.getButton());
        panel.add(decButton.getButton());
        panel.add(numberButtons[0].getButton());
        panel.add(equButton.getButton());
        panel.add(divButton.getButton());

        frame.add(panel);
        frame.add(delButton.getButton());
        frame.add(negButton.getButton());
        frame.add(clrButton.getButton());
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i].getButton()) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        for (CalculatorButton button : buttonManager.getCalculatorButtons()){
            if (e.getSource() == button.getButton()){
                num1 = Double.parseDouble(textfield.getText());
                operator = button.getOperation().getSymbol();
                textfield.setText("");
            }
        }
        if(e.getSource()==equButton.getButton()) {
            num2=Double.parseDouble(textfield.getText());

            switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton.getButton()) {
            textfield.setText("");
        }
        if(e.getSource()==delButton.getButton()) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton.getButton()) {
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }

}