package vimt.com.mvvmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vimt.com.mvvmapp.ui.main.MainFragment;
import vimt.com.mvvmapp.view.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        App.setActivity(this);
        if (savedInstanceState == null) {
            App.getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ProfileFragment.newInstance(), ProfileFragment.class.getName())
                    .addToBackStack(ProfileFragment.class.getName())
                    .commitAllowingStateLoss();
        }
    }
}
