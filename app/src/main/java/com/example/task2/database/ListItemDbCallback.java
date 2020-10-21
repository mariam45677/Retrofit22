package com.example.task2.database;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ListItemDbCallback extends DiffUtil.ItemCallback<Movies> {
    @Override
    public boolean areItemsTheSame(@NonNull Movies oldItem, @NonNull Movies newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movies oldItem, @NonNull Movies newItem) {
        return false;
    }
}
