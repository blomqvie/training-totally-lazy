package fi.reaktor.training.totallylazy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fi.reaktor.training.totallylazy.data.Exercise;
import fi.reaktor.training.totallylazy.data.Exercises;
import training.reaktor.fi.totallylazyapplication.R;

public class LazyInfoViewFragment extends BeerFragment {

    private static final String SECTION_NUMBER = "SECTION_NUMBER";

    public static Fragment newInstance(int sectionNumber) {
        LazyInfoViewFragment f = new LazyInfoViewFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        subscribeToBeers(beers -> {
            Exercise e = Exercises.getExerciseBySection(getArguments().getInt(SECTION_NUMBER));
            TextView label = (TextView) view.findViewById(R.id.info_label);
            TextView text = (TextView) view.findViewById(R.id.info_text);
            label.setText(e.getLabel());
            text.setText(e.getString(beers));
        });
    }
}

