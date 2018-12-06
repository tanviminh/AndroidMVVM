package vimt.com.mvvmapp.model;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

public class ModelItem extends ViewModel{
    private ObservableField title = new ObservableField();



    public ObservableField getTitle() {
        return title;
    }



//    private MutableLiveData<String> title = new MutableLiveData();
//
//    public MutableLiveData<String> getTitle() {
//        return title;
//    }
//
//    public void setTitle(MutableLiveData<String> title) {
//        this.title = title;
//    }


//    private String title;
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
