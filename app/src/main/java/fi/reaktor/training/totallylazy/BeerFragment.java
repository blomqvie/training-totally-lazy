package fi.reaktor.training.totallylazy;

import android.app.Fragment;

import com.googlecode.totallylazy.Sequence;

import fi.reaktor.training.totallylazy.data.Beer;
import fi.reaktor.training.totallylazy.data.Beers;
import rx.Subscription;
import rx.functions.Action1;

public class BeerFragment extends Fragment {
    protected Subscription beerSubscription;

    protected void subscribeToBeers(Action1<Sequence<Beer>> action) {
        beerSubscription = Subscriptions.bindAndSubscribe(this, Beers.beers(), action);
    }

    @Override
    public void onDestroy() {
        Subscriptions.safeUnsubscribe(beerSubscription);
        super.onDestroy();
    }
}
