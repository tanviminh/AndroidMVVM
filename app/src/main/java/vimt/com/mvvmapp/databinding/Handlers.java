package vimt.com.mvvmapp.databinding;

import android.view.View;

public abstract class Handlers {
    public abstract void onClick(View view);

    public  boolean onLongClick(View view){
        return false;
    }
}
