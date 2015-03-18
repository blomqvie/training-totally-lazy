package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Sequence;

public class Exercise1 extends Exercise {

    @Override
    public Sequence<Beer> getBeers() {
        // TODO:
        // 1. get beers with abv greater than 10
        // 2. sort the beers by name
        // 3. return the first 10 results
        //
        return getAllBeers();
    }

    @Override
    public String getLabel() {
        return "10 beers over 10%";
    }

    @Override
    public String getString() {
        return "I only know sequences"; // nop
    }
}
