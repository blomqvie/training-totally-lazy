package fi.reaktor.training.totallylazy.data;

import android.util.Log;

import com.googlecode.totallylazy.Sequence;

import static com.googlecode.totallylazy.Segment.methods.sequence;
import static com.googlecode.totallylazy.Sequences.empty;

/**
 * Created by evir on 18/03/15.
 */
public class Exercise3 extends Exercise {
    @Override
    public Sequence<Beer> getBeers() {
        // ignore this, just implement getString()
        return empty();
    }

    @Override
    public String getString() {
        // TODO:
        // return a string that has all the names and abvs of brewery id 1
        String beers = getBeers()
                .take(2)
                .map((beer) -> "this is a beer")
                .toString(",");
        Log.d("beers", beers);
        return beers;
    }

    @Override
    public String getLabel() {
        return "Beers of brewery id 1";
    }
}
