package com.example.demo3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private List<Category> listCategory;
    private View view;

    private void BindingView() {
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame_category, container, false);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        BindingView();
        listCategory = addDataToList();
        adapter = new CategoryAdapter(getContext(), listCategory);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Category> addDataToList() {
        listCategory = new ArrayList<>();
        listCategory.add(new Category("pharmacy", R.drawable.ic_pharmacy));
        listCategory.add(new Category("registry", R.drawable.ic_registry));
        listCategory.add(new Category("cartwheel", R.drawable.ic_cartwheel));
        listCategory.add(new Category("clothing", R.drawable.ic_clothing));
        listCategory.add(new Category("shoes", R.drawable.ic_shoes));
        listCategory.add(new Category("accessories", R.drawable.ic_accessories));
        listCategory.add(new Category("baby", R.drawable.ic_baby));
        listCategory.add(new Category("home", R.drawable.ic_home));
        listCategory.add(new Category("patio & garden", R.drawable.ic_patio_garden));
        return listCategory;
    }
}
