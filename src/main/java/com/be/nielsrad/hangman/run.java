/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.be.nielsrad.hangman;

import javax.swing.UIManager;

import com.be.nielsrad.hangman.controller.Galgje;
import com.be.nielsrad.hangman.view.MainView;

/**
 * 
 * @author NielsR
 */
public class run {
	public static void main(final String[] args) {
		// TODO: Java 7 heeft standaard Nimbus Look and Feel
		try {
			for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {

					UIManager.setLookAndFeel(info.getClassName());

					break;
				}
			}
			// TODO: In Java 7 kan je meerdere fouten opvangen!
		} catch (final Exception ex) {

		}
		new MainView(new Galgje()).setVisible(true);
	}
}
