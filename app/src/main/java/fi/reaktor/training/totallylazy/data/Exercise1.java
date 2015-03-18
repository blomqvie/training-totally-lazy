package fi.reaktor.training.totallylazy.data;

import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Sequence;
import java.util.Comparator;

/**
 * Created by evir on 18/03/15.
 */
public class Exercise1 extends Exercise {

    @Override
    public Sequence<Beer> getBeers() {
        // TODO:
        // 1. get beers with abv greater than 10
        // 2. sort the beers by name
        // 3. return the first 10 results
        //
        getAllBeers()
                .filter(new Predicate<Beer>() {
                    @Override
                    public boolean matches(Beer other) {
                        return other.abv > 10;
                    }
                })
                .sort(new Comparator<Beer>() {
                    @Override
                    public int compare(Beer lhs, Beer rhs) {
                        return lhs.name.compareTo(rhs.name);
                    }
                })
                .take(10);

        return null;
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
