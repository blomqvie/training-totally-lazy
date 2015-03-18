package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Sequence;

public class Exercise2 extends Exercise {

    public Exercise2() {}

    @Override
    public Sequence<Beer> getBeers(Sequence<Beer> beers) {
        // TODO:
        // 1) return beers with abv between 8 and 10
        // 2) also sort by descending abv (sortBy)
        // 3) make the beer name ALL UPPERCASE
        // tip: https://code.google.com/p/totallylazy/wiki/Sequence
        return beers;
    }

    @Override
    public String getString(Sequence<Beer> beers) {
        return "";
    }

    @Override
    public String getLabel() {
        return "Beers over 8%";
    }


}
