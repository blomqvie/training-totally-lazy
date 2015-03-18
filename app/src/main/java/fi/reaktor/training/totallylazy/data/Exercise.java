package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Sequence;

public abstract class Exercise {
    public abstract Sequence<Beer> getBeers(Sequence<Beer> beers);
    public abstract String getString(Sequence<Beer> beers);
    public abstract String getLabel();
}
