package fi.reaktor.training.totallylazy.data;

import android.app.Activity;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.totallylazy.Sequence;

import java.io.IOException;
import java.io.InputStream;

import rx.Observable;
import rx.android.app.AppObservable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import training.reaktor.fi.totallylazyapplication.R;

public class Beers {

    private static Observable<Sequence<Beer>> beersObservable;

    // static init is not a pretty way to do this
    public static void init(Activity activity, ObjectMapper objectMapper) throws IOException {

        InputStream inputStream = activity.getResources().openRawResource(R.raw.beers);

        beersObservable = Observable
                .<Sequence<Beer>>create((subscriber) -> {
                    try {
                        Sequence<Beer> beerSeq = objectMapper.readValue(inputStream, new TypeReference<Sequence<Beer>>() {
                        });
                        subscriber.onNext(beerSeq);
                        subscriber.onCompleted();
                    } catch (IOException e) {
                        subscriber.onError(e);
                    }
                })
                .subscribeOn(Schedulers.io())
                .cache();
    }

    public static Observable<Sequence<Beer>> beers() {
        return beersObservable;
    }
}
