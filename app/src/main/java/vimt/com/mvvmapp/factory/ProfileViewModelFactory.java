package vimt.com.mvvmapp.factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import vimt.com.mvvmapp.view.ProfileFragment;
import vimt.com.mvvmapp.viewmodel.ProfileViewModel;

public class ProfileViewModelFactory implements ViewModelProvider.Factory {
    private ProfileFragment.ICallBack callBack;


    public ProfileViewModelFactory(ProfileFragment.ICallBack callBack) {
        this.callBack = callBack;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProfileViewModel(callBack);
    }
}
