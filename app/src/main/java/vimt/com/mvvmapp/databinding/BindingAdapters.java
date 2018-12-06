package vimt.com.mvvmapp.databinding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class BindingAdapters {
    @BindingAdapter("greetings")
    public static void setName(TextView view, String text) {
        view.setText("Welcome, " + text);
    }
}
