package vimt.com.mvvmapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vimt.com.mvvmapp.App;
import vimt.com.mvvmapp.BR;
import vimt.com.mvvmapp.R;
import vimt.com.mvvmapp.adapter.ProfileAdapter;
import vimt.com.mvvmapp.model.ProfileModel;
import vimt.com.mvvmapp.view.ProfileFragment;

public class ProfileViewModel extends BaseViewModel {
    public ObservableField<String> myName;
    public ObservableInt myAge;
    public ObservableList<ProfileModel> data;
    public ProfileAdapter adapter;
    public GridLayoutManager linearLayoutManager;


    public ProfileViewModel(ProfileFragment.ICallBack iCallBack) {
        this.myAge = new ObservableInt();
        this.myName = new ObservableField<>();
        this.data = new ObservableArrayList<>();
        this.adapter = new ProfileAdapter(this.data, iCallBack);
        this.linearLayoutManager = new GridLayoutManager(App.getContext(), 3);
    }

    @Bindable
    public ProfileAdapter getAdapter() {
        return this.adapter;
    }

    @Bindable
    public List<ProfileModel> getData() {
        return data;
    }


    public void addData() {
        for (int i = 0; i < 100; i++) {
            ProfileModel model = new ProfileModel();
            model.setName("Nguyen " + i);
            model.setAge(i);
            if (i % 2 == 0) {
                model.setHide(true);
            }
            this.data.add(model);
        }
        //notifyPropertyChanged(BR.data);
        notifyPropertyChanged(BR.adapter);
    }

    public void remove(ProfileModel profileModel) {
        if (this.data == null) {
            return;
        }
        int index = this.data.indexOf(profileModel);
        this.data.remove(profileModel);
        this.adapter.notifyItemRemoved(index);

    }
}
