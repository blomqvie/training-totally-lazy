package training.reaktor.fi.totallylazyapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.Sequences;
import com.googlecode.totallylazy.collections.PersistentMap;

import training.reaktor.fi.totallylazyapplication.data.Beer;

public class BeerAdapter extends BaseAdapter {

    Sequence<Beer> beers;

    public BeerAdapter(Sequence<PersistentMap<String, String>> beverages) {
        beers = findBeers(beverages);
    }

    private Sequence<Beer> findBeers(Sequence<PersistentMap<String, String>> beverages) {
        // TODO: implement
        return Sequences.empty();
    }

    @Override
    public int getCount() {
        return beers.size();
    }

    @Override
    public Beer getItem(int i) {
        return beers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return beers.get(i).id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
