package fi.reaktor.training.totallylazy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.googlecode.totallylazy.Sequence;

import fi.reaktor.training.totallylazy.data.Beer;
import fi.reaktor.training.totallylazy.data.Beers;
import training.reaktor.fi.totallylazyapplication.R;

public class BeerAdapter extends BaseAdapter {

    Sequence<Beer> beers;

    public BeerAdapter() {
        beers = Beers.list();
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
        holder.abv.setText(Float.toString(getItem(i).abv));

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
