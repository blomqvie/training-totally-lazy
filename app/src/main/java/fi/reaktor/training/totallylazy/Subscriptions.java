package fi.reaktor.training.totallylazy;

import android.app.Fragment;

import com.googlecode.totallylazy.Sequence;

import fi.reaktor.training.totallylazy.data.Beer;
import rx.Observable;
import rx.Subscription;
import rx.android.app.AppObservable;
import rx.functions.Action1;

public class Subscriptions {

    public static void safeUnsubscribe(Subscription subscription) {
        if(subscription != null) {
            subscription.unsubscribe();
        }
    }

    public static Subscription bindAndSubscribe(Fragment f, Observable<Sequence<Beer>> o, Action1<Sequence<Beer>> action) {
        return AppObservable.bindFragment(f, o).subscribe(action);
    }
}
