package fi.reaktor.training.totallylazy.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.totallylazy.Sequence;

import java.io.IOException;
import java.io.InputStream;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Beers {

    private static Sequence<Beer> beers;
    private static Observable<Sequence<Beer>> beerObservable;

    public static Beers init(InputStream inputStream, ObjectMapper objectMapper) throws IOException {
        beers = objectMapper.readValue(inputStream, new TypeReference<Sequence<Beer>>() {});

        // TODO: not used yet
        beerObservable = Observable.<Sequence<Beer>>create((subscriber) -> {
            try {
                Sequence<Beer> beerSeq = objectMapper.readValue(inputStream, new TypeReference<Sequence<Beer>>() {
                });
                subscriber.onNext(beerSeq);
                subscriber.onCompleted();
            } catch (IOException e) {
                subscriber.onError(e);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        return new Beers();
    }

    public static Sequence<Beer> listAll() {
        return beers;
    }
}
