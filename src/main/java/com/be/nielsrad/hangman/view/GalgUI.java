package com.be.nielsrad.hangman.view;

import javax.swing.*;
import java.awt.*;

/**
 * Deze klasse is een Swing Panel waar een galg op word getekent met Java 2d
 *
 * @author Niels Rademaekers
 * @version Galgje 2.0
 * @see be.niels.galgje.view.GalgjeUI hier word dit paneel op geplaatst
 */
public class GalgUI extends JPanel {

    private int fouten = 0;
    private int width = 0;
    private int heigth = 0;

    /**
     * Constructor voor be.niels.galgje.view.GalgUI
     */
    public GalgUI() {
        setSize(500, 300);
        setLayout(new FlowLayout());
    }

    /**
     * Methode paintComponent overschrijven voor zelf te kunnen tekenen
     * Hier word het be.niels.galgje.be.niels.galgje.controller.Galgje Getekent
     *
     * @param g graphics die meegegeven worden
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g2Lijnen = (Graphics2D) g;
        this.setBackground(Color.WHITE);

        g2Lijnen.setStroke(new BasicStroke(6));
        width = (getWidth() - 500) / 2;
        heigth = (getHeight() - 300) / 2;

        switch (fouten) {
            case 10:
                g2Lijnen.drawLine(325 + width, 210 + heigth, 350 + width, 245 + heigth);

            case 9:
                g2Lijnen.drawLine(300 + width, 210 + heigth, 275 + width, 245 + heigth);

            case 8:
                g2Lijnen.drawLine(325 + width, 165 + heigth, 350 + width, 140 + heigth);

            case 7:
                g2Lijnen.drawLine(300 + width, 165 + heigth, 270 + width, 140 + heigth);

            case 6:
                g2.fillRect(300 + width, 145 + heigth, 25, 70);

            case 5:
                g2Lijnen.drawOval(280 + width, 95 + heigth, 60, 50);

            case 4:
                g2Lijnen.drawLine(310 + width, 40 + heigth, 310 + width, 90 + heigth);

            case 3:
                g2Lijnen.drawLine(170 + width, 100 + heigth, 230 + width, 40 + heigth);

            case 2:
                g2.fillRect(150 + width, 20 + heigth, 190, 20);

            case 1:
                g2.fillRect(150 + width, 40 + heigth, 20, 250);

            case 0:

        }


    }

    /**
     * Setter voor het aantal fouten.
     * Aan de hand van dit getal word de galg getekend
     *
     * @param fouten aantal fouten
     */
    public void setFouten(int fouten) {
        this.fouten = fouten;
        repaint();
    }
}

