package me.tomescuvlad.calculator.button;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class CustomButton extends JButton {

    public CustomButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.black);
        // set the color of the text black
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, 0, height, Color.CYAN);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();

        super.paintComponent(g);
    }
}


