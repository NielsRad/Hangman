package com.be.nielsrad.hangman.view;

import com.be.nielsrad.hangman.controller.Galgje;
import com.sun.tools.javac.parser.JavacParser;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by IntelliJ IDEA.
 * User: NielsR
 * Date: 1/12/11
 * Time: 23:54
 * To change this template use File | Settings | File Templates.
 */
public class WaarschuwingsPanel extends JPanel {

    private JButton btnSluit;
    private JLabel lblInfo;
    private Galgje galgje;
    private String info;

    public WaarschuwingsPanel(Galgje galgje, String info) {
        this.galgje = galgje;
        this.info = info;
        maakWaarschuwingsPanel();
    }

    private void maakWaarschuwingsPanel() {
        lblInfo = new JLabel(info);
        lblInfo.setFont(new Font("Arial Black", Font.BOLD, 20));

        btnSluit = new JButton("Sluit Galgje");
        btnSluit.setFont(new Font("Arial Black", Font.BOLD, 20));
        setLayout(new BorderLayout());
        JPanel pnlInfo = new JPanel(new GridBagLayout());
        pnlInfo.add(lblInfo);

        pnlInfo.setOpaque(false);

        add(pnlInfo, BorderLayout.CENTER);
        add(btnSluit, BorderLayout.SOUTH);

        btnSluit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                galgje.sluit();
            }
        });
    }

}

class WallpaperLayerUI extends LayerUI<JPanel> {

    public WallpaperLayerUI() {

    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);


        Graphics2D g2 = (Graphics2D) g.create();

        int w = c.getWidth();
        int h = c.getHeight();
        g2.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, .5f));
        g2.setPaint(new GradientPaint(0, 0, Color.LIGHT_GRAY, 0, h, Color.LIGHT_GRAY));
        g2.fillRect(0, 0, w, h);

        g2.dispose();

    }
}