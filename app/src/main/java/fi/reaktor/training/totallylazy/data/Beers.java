package fi.reaktor.training.totallylazy.data;

import android.app.Activity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.totallylazy.Sequence;

import java.io.IOException;
import java.io.InputStream;

import rx.Observable;
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
                .cache()
                .subscribeOn(Schedulers.io());
    }

    public static Observable<Sequence<Beer>> beers() {
        return beersObservable;
    }
}
