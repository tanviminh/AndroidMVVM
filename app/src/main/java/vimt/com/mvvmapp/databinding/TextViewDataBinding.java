package vimt.com.mvvmapp.databinding;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class TextViewDataBinding {
    @BindingAdapter("app:welcome")
    public void bind(TextView textView, String text) {
        if(text == null){
            textView.setText("");
        }
        textView.setText("WelCome" + text);
    }
}
