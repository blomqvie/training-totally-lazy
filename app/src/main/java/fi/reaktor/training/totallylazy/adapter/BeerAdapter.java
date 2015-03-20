package fi.reaktor.training.totallylazy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.googlecode.totallylazy.Sequence;

import java.util.List;

import fi.reaktor.training.totallylazy.data.Beer;
import rx.android.view.ViewObservable;
import rx.functions.Action1;
import training.reaktor.fi.totallylazyapplication.R;

public class BeerAdapter extends BaseAdapter {

    List<Beer> beers;
    private Action1<Beer> itemClickAction;

    public BeerAdapter(Sequence<Beer> beersSequence, Action1<Beer> itemClickAction) {
        this.itemClickAction = itemClickAction;
        beers = beersSequence.toList();
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
            BeerViewHolder holder = new BeerViewHolder(view, i);
            view.setTag(holder);

            // TODO subscribes?
            ViewObservable.clicks(view).map(e -> {
                BeerViewHolder h = (BeerViewHolder) e.view().getTag();
                return beers.get(h.index);
            }).subscribe(itemClickAction);
        }

        BeerViewHolder holder = (BeerViewHolder) view.getTag();
        holder.name.setText(getItem(i).name);
        holder.abv.setText(Float.toString(getItem(i).abv));

        return view;
    }

    private static class BeerViewHolder {

        final TextView name;
        final TextView abv;
        final int index;

        public BeerViewHolder(View beerView, int index) {
            this.index = index;
            name = (TextView) beerView.findViewById(R.id.beer_name);
            abv = (TextView) beerView.findViewById(R.id.beer_abv);
        }

    }
}
