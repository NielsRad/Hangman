package com.be.nielsrad.hangman.view;



import com.be.nielsrad.hangman.controller.Galgje;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;

/**
 * Het Basisframe waarop heel het spel gebouwd is
 *
 * @author Niels Rademaekers
 * @version Galgje 2.0
 */
public class MainView extends JFrame {
    GalgjeUI galgjeUI;
    Galgje galgje;
    WaarschuwingsPanel waarschuwingsPanel;
    JLayer<JPanel> jlayer;


    /**
     * Constructor van be.niels.galgje.view.MainView
     */
    public MainView(Galgje galgje) {
        this.galgje = galgje;
        maakFrame();
        initialiseer();

    }

    /**
     * Hier word het frame gemaakt
     */
    private void maakFrame() {
        setTitle("be.niels.galgje.be.niels.galgje.controller.Galgje");

        setSize(515, 500);
        //Geeft de minimumgroote van het JFrame
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

    }

    /**
     * initialiseert de objecten
     */
    private void initialiseer() {

        galgjeUI = new GalgjeUI(galgje, this);

        add(galgjeUI);
    }


    public void toonWaarschuwing(String waarschuwing) {
        //TODO LAYER
        waarschuwingsPanel = new WaarschuwingsPanel(galgje, waarschuwing);
        this.remove(galgjeUI);

        LayerUI<JPanel> layerUI = new WallpaperLayerUI();
        jlayer = new JLayer<JPanel>(galgjeUI, layerUI);
        waarschuwingsPanel.setOpaque(false);

        setGlassPane(waarschuwingsPanel);
        getGlassPane().setVisible(true);

        this.add(jlayer);


        this.repaint();
        this.validate();

    }
}
