package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Sequence;

public abstract class Exercise {
    protected Sequence<Beer> getAllBeers() {
        return Beers.listAll();
    }
    public abstract Sequence<Beer> getBeers();
    public abstract String getString();
    public abstract String getLabel();
}
