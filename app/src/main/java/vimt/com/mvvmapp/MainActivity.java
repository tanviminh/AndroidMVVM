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
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ProfileFragment.newInstance())
                    .commitNow();
        }
    }
}
