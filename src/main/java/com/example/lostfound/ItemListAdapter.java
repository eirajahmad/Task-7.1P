package com.example.lostfound;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    private Context context;
    private List<Item> itemList;

    public ItemListAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.textViewType.setText(item.getType());
        holder.textViewName.setText(item.getName());
        holder.textViewPhone.setText(item.getPhone());
        holder.textViewDescription.setText(item.getDescription());
        holder.textViewDate.setText(item.getDate());
        holder.textViewLocation.setText(item.getLocation());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetailActivity.class);
                intent.putExtra("ITEM_ID", item.getId());
                intent.putExtra("ITEM_TYPE", item.getType());
                intent.putExtra("ITEM_NAME", item.getName());
                intent.putExtra("ITEM_DESCRIPTION", item.getDescription());
                intent.putExtra("ITEM_DATE", item.getDate());
                intent.putExtra("ITEM_LOCATION", item.getLocation());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewType, textViewName, textViewPhone, textViewDescription, textViewDate, textViewLocation;

        public ViewHolder(View view) {
            super(view);
            textViewType = view.findViewById(R.id.textViewType);
            textViewName = view.findViewById(R.id.textViewName);
            textViewPhone = view.findViewById(R.id.textViewPhone);
            textViewDescription = view.findViewById(R.id.textViewDescription);
            textViewDate = view.findViewById(R.id.textViewDate);
            textViewLocation = view.findViewById(R.id.textViewLocation);
        }
    }
}
