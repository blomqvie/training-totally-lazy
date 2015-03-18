package fi.reaktor.training.totallylazy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import fi.reaktor.training.totallylazy.adapter.BeerAdapter;
import fi.reaktor.training.totallylazy.data.Exercise;
import fi.reaktor.training.totallylazy.data.Exercises;
import training.reaktor.fi.totallylazyapplication.R;

public class LazyListFragment extends BeerFragment {

    private static final String SECTION_NUMBER = "SECTION_NUMBER";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    public static Fragment newInstance(int sectionNumber) {
        LazyListFragment listFragment = new LazyListFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        listFragment.setArguments(args);
        return listFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        subscribeToBeers(beers -> {
            Exercise exercise = Exercises.getExerciseBySection(getArguments().getInt(SECTION_NUMBER));
            View progressBar = view.findViewById(R.id.list_progressbar);
            progressBar.setVisibility(View.GONE);
            ListView itemList = (ListView) view.findViewById(R.id.item_list);
            TextView sectionLabel = (TextView) view.findViewById(R.id.section_label);
            sectionLabel.setText(exercise.getLabel());
            itemList.setAdapter(new BeerAdapter(beers, exercise));
        });
    }
}
