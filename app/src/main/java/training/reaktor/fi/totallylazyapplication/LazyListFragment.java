package training.reaktor.fi.totallylazyapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import training.reaktor.fi.totallylazyapplication.adapter.BeerAdapter;
import training.reaktor.fi.totallylazyapplication.data.Beverages;

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
        int sectionNumber = getArguments().getInt(SECTION_NUMBER);
        itemList.setAdapter(getAdapter(sectionNumber));
    }

    private ListAdapter getAdapter(int sectionNumber) {
        switch (sectionNumber) {
            case 0: {
                return new BeerAdapter(Beverages.beverageSequence());
            }
            default: {
                return new BeerAdapter(Beverages.beverageSequence());
            }
        }
    }
}
