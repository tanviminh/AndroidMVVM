package vimt.com.mvvmapp.ui.main;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import vimt.com.mvvmapp.MainActivity;
import vimt.com.mvvmapp.R;
import vimt.com.mvvmapp.adapter.ItemAdapter;
import vimt.com.mvvmapp.databinding.MainFragmentBinding;
import vimt.com.mvvmapp.databinding.RowItemBinding;
import vimt.com.mvvmapp.model.ModelItem;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    MainFragmentBinding binding;
    RowItemBinding rowItemBinding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.main_fragment, container, false);
        Gson gson = new Gson();
        String data = "{\"id\": 1000}";
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        binding = DataBindingUtil.inflate(
                inflater, R.layout.main_fragment, container, false);
        //rowItemBinding = DataBindingUtil.inflate(inflater, R.layout.row_item, container, false);
        binding.setViewModel(mViewModel);
        binding.setLifecycleOwner(this);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mViewModel.userLiveData.observer(this, new Observer() {
//            @Override
//            public void onChanged(@Nullable User data) {
//                // update ui.
//            }
//        });
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.doAction();
//            }
//        });


        //MutableLiveData<String> as = new MutableLiveData<String>();
        // TODO: Use the ViewModel
        view.findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.score.set(mViewModel.score.get() + 1);
                //mViewModel.score = mViewModel.score + 1;

            }
        });

        final ObservableList<ModelItem> items = new ObservableArrayList<>();
        for (int i = 0; i < 100; i++) {
            ModelItem modelItem = new ModelItem();
            //modelItem.getTitle().set("fdsfdsfdsf" + i);
            modelItem.getTitle().set("aaa" + i);
            //modelItem.setTitle("fdsfdsfdsf" + i);
            items.add(modelItem);
            //items.add(modelItem);
        }
//        items.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<ModelItem>>() {
//            @Override
//            public void onChanged(ObservableList<ModelItem> sender) {
//
//            }
//
//            @Override
//            public void onItemRangeChanged(ObservableList<ModelItem> sender, int positionStart, int itemCount) {
//
//            }
//
//            @Override
//            public void onItemRangeInserted(ObservableList<ModelItem> sender, int positionStart, int itemCount) {
//
//            }
//
//            @Override
//            public void onItemRangeMoved(ObservableList<ModelItem> sender, int fromPosition, int toPosition, int itemCount) {
//
//            }
//
//            @Override
//            public void onItemRangeRemoved(ObservableList<ModelItem> sender, int positionStart, int itemCount) {
//                int a = 0;
//            }
//        });
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        final ItemAdapter adapter = new ItemAdapter(items, new ItemAdapter.ItemAdapterListener() {
            @Override
            public void onModelItemClicked(ModelItem ModelItem) {
                //ModelItem.getTitle().set("iiiiiiiiii");

                items.remove(ModelItem);


                //items.remove(ModelItem);

            }
        });
        binding.recycler.setAdapter(adapter);
    }
}
