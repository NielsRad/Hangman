package com.be.nielsrad.hangman.view;


import com.be.nielsrad.hangman.controller.Galgje;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GalgjeUI extends JPanel{

    private List<JButton> btnAlfabetKnoppen;
    private char letter;
    private JPanel pnlAlfabet, pnlRadenLetters;
    private List<JTextField> lblLabels;
    private GalgUI pnlGalg;
    private Galgje galgje;
    private MainView mainView;


    /**
     * Constructor van klasse be.niels.galgje.view.GalgjeUI deze start alle methodes in deze klasse op.
     */
    public GalgjeUI(Galgje galgje, MainView mainView) {
               this.mainView=mainView;
        this.galgje = galgje;
        setLayout(new BorderLayout());

        initialiseerFrame();
        initialiseer();
        maakAan();

        registreerEventHandlers();


    }

    /**
     * Maakt het JFrame aan
     */
    private void initialiseerFrame() {
        setPreferredSize(new Dimension(500, 500));


        setSize(515, 500);
        //Geeft de minimumgroote van het JFrame
        setMinimumSize(new Dimension(500, 500));



    }

    /**
     * Initialiseren van componenten
     */
    private void initialiseer() {
        maakTeRadenLetters();
        alfabetInitialiseer();
    }

    /**
     * Initialiseerd het paneel voor de knoppen met alle letters van het alfabet op te zetten
     * Creëert ook de Arraylist van JButtons voor de knoppen aan en maakt een Gridlayout aan.
     */
    private void alfabetInitialiseer() {
        pnlAlfabet = new JPanel();

        btnAlfabetKnoppen = new ArrayList<JButton>();
        pnlAlfabet.setLayout(new GridLayout(3, 9));

    }

    /**
     * Zet de elementen op het JFrame
     */
    private void maakAan() {
        alfabetAanmaken();
        add(pnlAlfabet, BorderLayout.SOUTH);
        maakTeRadenLetters();
        add(pnlRadenLetters, BorderLayout.NORTH);
        pnlGalg = new GalgUI();
        add(pnlGalg, BorderLayout.CENTER);


    }

    /**
     * Maakt knoppen aan voor alle letters van het alfabet.
     */
    private void alfabetAanmaken() {
        for (int i = 0; i < 26; i++) {
            btnAlfabetKnoppen.add(new JButton(String.valueOf(new Character((char) (65 + i)))));
            btnAlfabetKnoppen.get(i).setToolTipText("Voer letter '" + String.valueOf(new Character((char) (65 + i))) + "' in.");
        }
        btnAlfabetKnoppen.add(new JButton(""));

        for (JButton jButton : btnAlfabetKnoppen) {
            pnlAlfabet.add(jButton);
        }
        //Laatste button om de grid op te vullen, ook onmiddelijk setInvisible op False zetten

        btnAlfabetKnoppen.get(btnAlfabetKnoppen.size() - 1).setVisible(false);

    }

    /**
     * Maakt de labels aan naargelang het aantal te raden letters
     */
    private void maakTeRadenLetters() {
        pnlRadenLetters = new JPanel();
        lblLabels = new ArrayList<>();
        pnlRadenLetters.setLayout(new FlowLayout());

        for (int j = 0; j < galgje.lengteWoord(); j++) {
            lblLabels.add(new JTextField(1));
            lblLabels.get(j).setHorizontalAlignment(JTextField.CENTER);
            lblLabels.get(j).setFocusable(false);
            lblLabels.get(j).setFont(new Font("Arial", 10, 30));

        }
        for (JTextField jText : lblLabels) {
            pnlRadenLetters.add(jText);
        }
    }



    /**
     * Registreert de event handlers voor dit Swing frame.
     */
    private void registreerEventHandlers() {
        for (final JButton alfabetKnop : btnAlfabetKnoppen) {
            alfabetKnop.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    alfabetKnop.setVisible(false);
                    letter = alfabetKnop.getText().charAt(0);
                    if (galgje.antwoord(letter))

                    {

                        int i = 0;

                        for (Character character : galgje.getLetters()) {
                            voegLetterToe(i, character);
                            i++;
                        }

                        if (galgje.gewonnen()) {
                        mainView.toonWaarschuwing("U bent gewonnen!");
                          removeActionListeners();


                        }

                    } else {
                        pnlGalg.setFouten(galgje.getFouten());
                        if (galgje.verloren()) {
                         mainView.toonWaarschuwing("U bent verloren het woord was: " + galgje.getWoord());
                             removeActionListeners();

                        }

                    }

                }
            });
        }
    }


    /**
     * Voerd een geraden letter in het overeenkomstige label op de juiste positie
     *
     * @param positie De positie van de geraden letter in het woord
     * @param c       De geraden letter
     */
    private void voegLetterToe(int positie, char c) {
        lblLabels.get(positie).setText(String.valueOf(c));
    }

       private void removeActionListeners()
       {
             for (final JButton alfabetKnop : btnAlfabetKnoppen) {

               alfabetKnop.setEnabled(false);
             }
       }
}








