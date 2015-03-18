package fi.reaktor.training.totallylazy.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.totallylazy.Sequence;

import java.io.IOException;
import java.io.InputStream;

public class Beers {

    private static Sequence<Beer> beers;
    // XXX: this is a bit naughty
    public static Beers init(InputStream inputStream, ObjectMapper objectMapper) throws IOException {
        beers = objectMapper.readValue(inputStream, new TypeReference<Sequence<Beer>>() {});
        return new Beers();
    }

    public static Sequence<Beer> listAll() {
        return beers;
    }
}
