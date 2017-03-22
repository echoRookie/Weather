package util;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by rookie on 2017/3/22.
 */

public class CityManageItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    private CityAdapter cityAdapter;
    public CityManageItemTouchHelper(CityAdapter cityAdapter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.cityAdapter=cityAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
               cityAdapter.onRemove(viewHolder.getAdapterPosition());
    }
}
