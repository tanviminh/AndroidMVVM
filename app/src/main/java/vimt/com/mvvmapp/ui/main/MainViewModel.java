package vimt.com.mvvmapp.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;

import com.google.gson.annotations.SerializedName;

import java.util.Observable;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    @SerializedName("id")
    public ObservableInt score = new ObservableInt();
    ObservableList<String> items = new ObservableArrayList<>();

    //public int score;
    public MainViewModel() {

    }

}
