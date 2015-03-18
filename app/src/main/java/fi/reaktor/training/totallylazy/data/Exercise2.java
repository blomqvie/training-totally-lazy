package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Sequence;

/**
 * Created by evir on 18/03/15.
 */
public class Exercise2 extends Exercise {

    public Exercise2() {}

    @Override
    public Sequence<Beer> getBeers() {
        // TODO:
        // 1) return beers between with abv >= 8
        // 2) also sort by descending abv (sortBy)
        // 3) make the beer name ALL UPPERCASE
        // tip: https://code.google.com/p/totallylazy/wiki/Sequence
        return getAllBeers();
    }

    @Override
    public String getString() {
        return "";
    }

    @Override
    public String getLabel() {
        return "Beers over 8%";
    }


}
