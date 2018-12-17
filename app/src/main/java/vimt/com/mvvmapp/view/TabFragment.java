package vimt.com.mvvmapp.view;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vimt.com.mvvmapp.R;
import vimt.com.mvvmapp.databinding.FragmentTabBinding;
import vimt.com.mvvmapp.databinding.Handlers;
import vimt.com.mvvmapp.factory.ProfileViewModelFactory;
import vimt.com.mvvmapp.viewmodel.ProfileViewModel;
import vimt.com.mvvmapp.viewmodel.TabViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends BaseFragment {

    TabViewModel viewModel;
    FragmentTabBinding binding;

    public TabFragment() {
        // Required empty public constructor
    }

    public static TabFragment newInstance() {

        Bundle args = new Bundle();

        TabFragment fragment = new TabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding != null) {
            return binding.getRoot();
        }
        // Inflate the layout for this fragment
        viewModel = new TabViewModel(getChildFragmentManager());
        //viewModel = new ProfileViewModel(iCallBack);
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_tab, container, false);
        binding.setModel(viewModel);
        binding.setHandler(createHandler());
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    private Handlers createHandler() {

        Handlers handlers = new Handlers() {
            @Override
            public void onClick(View view) {

            }
        };

        return handlers;
    }

}
