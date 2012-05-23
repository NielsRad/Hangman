package com.be.nielsrad.hangman.model;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: NielsR
 * Date: 1/12/11
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */
public class Woord {
    private final char[] woord;
    private char[] letters;

    public Woord(String woord) {
        this.woord = woord.toUpperCase().toCharArray();

        letters = new char[woord.length()];
        for(int i=0; i<=letters.length-1;i++){
            letters[i]=' ';
        }
    }

    public boolean checkLetter(char letter) {
        boolean gevonden = false;
        for (int i = 0; i <= woord.length-1; i++) {
            if (woord[i] == letter) {
                gevonden = true;
                letters[i] = letter;
            }
        }
        return gevonden;
    }

    public int lengteWoord() {
        return woord.length;
    }

    public char[] getLetters() {
        return letters.clone();
    }

    public boolean gewonnen() {
        return Arrays.equals(woord,letters);
    }

    @Override
    public String toString() {
        return new String(woord);
    }
}
