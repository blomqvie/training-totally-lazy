package fi.reaktor.training.totallylazy.data;

public class Beer {

    public final long id;
    public final String name;
    public final String alcoholByVolume;

    public Beer(long id, String name, String alcoholByVolume) {
        this.id = id;
        this.name = name;
        this.alcoholByVolume = alcoholByVolume;
    }
}
