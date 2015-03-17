package training.reaktor.fi.totallylazyapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.Sequences;
import com.googlecode.totallylazy.collections.PersistentMap;

import training.reaktor.fi.totallylazyapplication.R;
import training.reaktor.fi.totallylazyapplication.data.Beer;

public class BeerAdapter extends BaseAdapter {

    Sequence<Beer> beers;

    public BeerAdapter(Sequence<PersistentMap<String, String>> beverages) {
        beers = findBeers(beverages);
    }

    private Sequence<Beer> findBeers(Sequence<PersistentMap<String, String>> beverages) {
        // TODO implement this!
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
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.beer, null);
            BeerViewHolder holder = new BeerViewHolder(view);
            view.setTag(holder);
        }

        BeerViewHolder holder = (BeerViewHolder) view.getTag();
        holder.name.setText(getItem(i).name);
        holder.abv.setText(getItem(i).alcoholByVolume);

        return view;
    }

    private static class BeerViewHolder {

        final TextView name;
        final TextView abv;

        public BeerViewHolder(View beerView) {
            name = (TextView) beerView.findViewById(R.id.beer_name);
            abv = (TextView) beerView.findViewById(R.id.beer_abv);
        }

    }
}
