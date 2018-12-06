package vimt.com.mvvmapp.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class BindingAdapters {

    @BindingAdapter("greetings")
    public static void setName(TextView view, String text) {
        view.setText("Welcome, " + text);
    }
//
//    @BindingAdapter("adapter")
//    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
//        recyclerView.setAdapter(adapter);
//    }
//    @BindingAdapter("layout_manager")
//    public static void setLayoutManager(RecyclerView recyclerView, LinearLayoutManager layoutManager) {
//        recyclerView.setLayoutManager(layoutManager);
//    }
}
