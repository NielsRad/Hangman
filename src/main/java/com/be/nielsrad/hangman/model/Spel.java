package com.be.nielsrad.hangman.model;

/**
 * Created by IntelliJ IDEA.
 * User: NielsR
 * Date: 1/12/11
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public class Spel {
    private Woord woord;
    private int fouten;

    public Spel(String woord) {
        this.woord = new Woord(woord);
        fouten = 0;
    }

    public boolean checkLetter(char letter) {
       if(woord.checkLetter(letter)){return true;}else{fouten++;return false;}

    }

    public boolean verloren() {
        if (fouten >= 10) {
            return true;
        }
        return false;

    }
    public boolean gewonnen(){return woord.gewonnen();}

    public Woord getWoord() {
        return woord;
    }

    public int getFouten() {
        return fouten;
    }
}
