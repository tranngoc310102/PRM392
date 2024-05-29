package com.example.demo3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> listCategory;
    private LayoutInflater inflater;

    public CategoryAdapter(Context context, List<Category> listCategory) {
        this.listCategory = listCategory;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.gird_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category item = listCategory.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView icon;

        private void bindingView() {
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);
        }

        private void bindingAction() {
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bindingView();
        }

        public void setData(Category item) {
            title.setText(item.getTitle());
            icon.setImageResource(item.getImage());
        }
    }
}
