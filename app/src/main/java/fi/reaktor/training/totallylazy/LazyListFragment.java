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

public class LazyListFragment extends Fragment {

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

        ListView itemList = (ListView) view.findViewById(R.id.item_list);
        TextView sectionLabel = (TextView) view.findViewById(R.id.section_label);
        int sectionNumber = getArguments().getInt(SECTION_NUMBER);
        Exercise exercise = Exercises.getExerciseBySection(sectionNumber);
        sectionLabel.setText(exercise.getLabel());
        itemList.setAdapter(new BeerAdapter(exercise));
    }
}
