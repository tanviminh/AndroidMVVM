package vimt.com.mvvmapp.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vimt.com.mvvmapp.R;
import vimt.com.mvvmapp.databinding.RowItemBinding;
import vimt.com.mvvmapp.model.ModelItem;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private ObservableList<ModelItem> ModelItemList;
    private ItemAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final RowItemBinding binding;

        public MyViewHolder(final RowItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }


    public ItemAdapter(ObservableList<ModelItem> ModelItemList, ItemAdapterListener listener) {
        this.ModelItemList = ModelItemList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.row_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.binding.setModel(ModelItemList.get(position));
        holder.binding.aaVaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onModelItemClicked(ModelItemList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ModelItemList.size();
    }

    public interface ItemAdapterListener {
        void onModelItemClicked(ModelItem ModelItem);
    }
}