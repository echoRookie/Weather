package util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by rookie on 2017/3/13.
 */

public class ItemPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> viewList;
    public ItemPagerAdapter(FragmentManager fm,List<Fragment> viewList){
        super(fm);
        this.viewList=viewList;
    }
    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
