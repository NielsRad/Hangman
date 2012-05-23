package com.be.nielsrad.hangman.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.be.nielsrad.hangman.model.Spel;

/**
 * Created by IntelliJ IDEA.
 * User: NielsR
 * Date: 1/12/11
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public class Galgje {

	private final Spel spel;
	private final List<String> woorden;

	public Galgje() {
		// TODO: In Java 7 moet je het type geen 2de keer meegeven bij instantatie = Diamond Operator
		this.woorden = new ArrayList<String>();
		vulWoorden();

		this.spel = new Spel(woorden.get(new Random().nextInt(woorden.size())));

	}

	public char[] getLetters() {

		return spel.getWoord().getLetters();

	}

	public boolean gewonnen() {
		return spel.gewonnen();
	}

	public boolean verloren() {
		return spel.verloren();
	}

	public int lengteWoord() {
		return spel.getWoord().lengteWoord();
	}

	public boolean antwoord(final char letter) {
		return spel.checkLetter(letter);
	}

	public String getWoord() {
		return spel.getWoord().toString();
	}

	public int getFouten() {
		return spel.getFouten();
	}

	private void vulWoorden() {
		woorden.add("bier");
		woorden.add("java");
		woorden.add("mac");
		woorden.add("water");

	}

	public void sluit() {
		System.exit(0);
	}
}
