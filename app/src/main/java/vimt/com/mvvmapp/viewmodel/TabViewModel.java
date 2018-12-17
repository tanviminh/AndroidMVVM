package vimt.com.mvvmapp.viewmodel;

import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.logging.Handler;

import vimt.com.mvvmapp.App;
import vimt.com.mvvmapp.adapter.ViewPagerAdapter;
import vimt.com.mvvmapp.view.DetailTabFragment;
import vimt.com.mvvmapp.BR;

public class TabViewModel extends BaseViewModel {
    private ObservableInt age = new ObservableInt();
    private ViewPagerAdapter adapter;
    private TabLayout.OnTabSelectedListener onTabSelectedListener;

    public TabViewModel(FragmentManager fragmentManager) {
        setAdapter(new ViewPagerAdapter(fragmentManager));
        getAdapter().addFrag(DetailTabFragment.newInstance(), "111");
        getAdapter().addFrag(DetailTabFragment.newInstance(), "222");
        getAdapter().addFrag(DetailTabFragment.newInstance(), "333");
        onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = getAdapter().getItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }

    @Bindable
    public ViewPagerAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ViewPagerAdapter adapter) {
        this.adapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    //@Bindable("aaa")
    public ObservableInt getAge() {
        return age;
    }

    public void setAge(ObservableInt age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public TabLayout.OnTabSelectedListener getOnTabSelectedListener() {
        return onTabSelectedListener;
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.onTabSelectedListener = onTabSelectedListener;
    }
}
