package vimt.com.mvvmapp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vimt.com.mvvmapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTabFragment extends Fragment {


    public DetailTabFragment() {
        // Required empty public constructor
    }

    public static DetailTabFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DetailTabFragment fragment = new DetailTabFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_tab, container, false);
    }

}
