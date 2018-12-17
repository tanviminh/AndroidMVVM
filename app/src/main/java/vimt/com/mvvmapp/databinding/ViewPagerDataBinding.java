package vimt.com.mvvmapp.databinding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import vimt.com.mvvmapp.adapter.ViewPagerAdapter;

public class ViewPagerDataBinding {
    @BindingAdapter({"app:adapter"})
    public void bind(ViewPager viewPager, ViewPagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }
}
