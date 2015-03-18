package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Sequence;

/**
 * Created by evir on 18/03/15.
 */
public abstract class Exercise {
    protected Sequence<Beer> getAllBeers() {
        return Beers.listAll();
    }
    public abstract Sequence<Beer> getBeers();
    public abstract String getLabel();
}
