package vimt.com.mvvmapp;

import android.app.Application;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentActivity;

import vimt.com.mvvmapp.databinding.AppDataBindingComponent;

public class App extends Application {

    private static Context context;
    private static FragmentActivity activity;

    public static FragmentActivity getActivity() {
        return activity;
    }

    public static void setActivity(FragmentActivity activity) {
        App.activity = activity;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.setContext(getApplicationContext());
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }

    public static Context getContext() {
        return context;
    }

    private void setContext(Context context) {
        this.context = context;
    }

}
