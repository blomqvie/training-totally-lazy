package fi.reaktor.training.totallylazy.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Beer {

    public final long id;
    public final int breweryId;
    public final String name;
    public final int catId;
    public final int styleId;
    public final float abv;
    public final float ibu;
    public final float srm;

    @JsonCreator

    public Beer(
            @JsonProperty("id") long id,
            @JsonProperty("brewery_id") int breweryId,
            @JsonProperty("name") String name,
            @JsonProperty("cat_id") int catId,
            @JsonProperty("style_id") int styleId,
            @JsonProperty("abv") float abv,
            @JsonProperty("ibu") float ibu,
            @JsonProperty("srm") float srm) {
        this.id = id;
        this.breweryId = breweryId;
        this.name = name;
        this.catId = catId;
        this.styleId = styleId;
        this.abv = abv;
        this.ibu = ibu;
        this.srm = srm;
    }
}
