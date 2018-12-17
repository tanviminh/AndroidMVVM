package vimt.com.mvvmapp.databinding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

public class TabLayoutDataBinding {
    @BindingAdapter({"app:pager", "app:addOnTabSelectedListener"})
    public void bind(TabLayout tabLayout, ViewPager pager, TabLayout.OnTabSelectedListener onTabSelectedListener) {
        tabLayout.setupWithViewPager(pager);
        tabLayout.addOnTabSelectedListener(onTabSelectedListener);
    }
}
