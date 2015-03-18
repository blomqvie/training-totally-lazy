package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Sequence;

public class Exercise1 extends Exercise {

    public Exercise1() {}

    @Override
    public Sequence<Beer> getBeers() {
        // TODO:
        // Instead of all beers, return beers between 8 and 10 abv.
        // add
        return getAllBeers();
    }

    @Override
    public String getLabel() {
        return "Beers between 8 and 10 ABV";
    }
}
