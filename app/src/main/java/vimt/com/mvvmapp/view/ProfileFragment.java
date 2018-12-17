package vimt.com.mvvmapp.view;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import vimt.com.mvvmapp.App;
import vimt.com.mvvmapp.R;
import vimt.com.mvvmapp.databinding.FragmentProfileBinding;
import vimt.com.mvvmapp.databinding.Handlers;
import vimt.com.mvvmapp.factory.ProfileViewModelFactory;
import vimt.com.mvvmapp.model.ProfileModel;
import vimt.com.mvvmapp.viewmodel.ProfileViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseFragment {

    ProfileViewModel viewModel;
    FragmentProfileBinding binding;


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(binding != null){
            return binding.getRoot();
        }
        //viewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        ICallBack iCallBack = new ICallBack() {
            @Override
            public void remove(ProfileModel profileModel) {
                viewModel.remove(profileModel);

            }
        };
        viewModel = ViewModelProviders.of(getActivity(), new ProfileViewModelFactory(iCallBack)).get(ProfileViewModel.class);
        //viewModel = new ProfileViewModel(iCallBack);
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_profile, container, false);
        binding.setModel(viewModel);
        binding.setHandler(createHandler());
        binding.setLifecycleOwner(this);
        initDefault();
        View view = binding.getRoot();
        return view;
    }

    private void initDefault() {
        //binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

    }


    private Handlers createHandler() {

        TabLayout tabLayout = new TabLayout(getContext());

        Handlers handlers = new Handlers() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.submit:
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                viewModel.myName.set("Vi Minh Tan");
                                viewModel.myAge.set(25);
                            }
                        }).start();

                        viewModel.addData();
                        break;

                    case R.id.name:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, TabFragment.newInstance(), TabFragment.class.getName())
                                .addToBackStack(TabFragment.class.getName())
                                .commitAllowingStateLoss();
                        break;
                }
            }

            @Override
            public boolean onLongClick(View view) {
                //super.onLongClick(view);
                int a = view.getId();
                return false;
            }






        };
        return handlers;
    }

    public interface ICallBack {
        void remove(ProfileModel profileModel);
    }

}


