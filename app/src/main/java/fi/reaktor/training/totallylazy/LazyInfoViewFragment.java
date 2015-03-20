package fi.reaktor.training.totallylazy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fi.reaktor.training.totallylazy.data.Beers;
import fi.reaktor.training.totallylazy.data.Exercise;
import fi.reaktor.training.totallylazy.data.Exercises;
import rx.Observable;
import rx.Subscription;
import rx.android.app.AppObservable;
import training.reaktor.fi.totallylazyapplication.R;

public class LazyInfoViewFragment extends Fragment {

    private static final String SECTION_NUMBER = "SECTION_NUMBER";
    private Subscription subscription;

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
        Exercise exercise = Exercises.getExerciseBySection(getArguments().getInt(SECTION_NUMBER));
        Observable<String> textObservable = Beers.beers().map(exercise::getString);
        subscription = AppObservable.bindFragment(this, textObservable).subscribe(text -> {
            setupView(view, text, exercise.getLabel());
        });
    }

    @Override
    public void onDestroyView() {
        subscription.unsubscribe();
        super.onDestroyView();
    }

    private void setupView(View view, String text, String label) {
        TextView labelView = (TextView) view.findViewById(R.id.info_label);
        TextView textView = (TextView) view.findViewById(R.id.info_text);
        labelView.setText(text);
        textView.setText(label);
    }
}

