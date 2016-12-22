/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rekoffer.models;

/**
 *
 * @author Damon
 */
public class Matchcase {

    private Baggage foundBaggage;
    private Baggage lostBaggage;

    public Matchcase(Baggage lostBaggage, Baggage foundBaggage) {
        this.lostBaggage = lostBaggage;
        this.foundBaggage = foundBaggage;
    }

    public Baggage getFoundBaggage() {
        return foundBaggage;
    }

    public Baggage getLostBaggage() {
        return lostBaggage;
    }

    @Override
    public String toString() {
        return "Verloren koffer met label:" + lostBaggage.getLabel() + " Op locatie:" + lostBaggage.getAirportSite()
                + " heeft een match een gevonden koffer label:"
                + foundBaggage.getLabel() + " op locatie" + foundBaggage.getAirportSite()
                + " - De rechtmatige eigenaar is " + lostBaggage.getFirstName() + " " + lostBaggage.getLastName() + " email : " + lostBaggage.getEmail();
    }
}
