package com.wildsmith.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.wildsmith.recyclerview.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerAdapter<M extends RecyclerModel, V extends RecyclerModelView, P extends RecyclerViewHolder<M, V>> extends
    RecyclerView.Adapter<P> {

    protected List<M> recyclerObjects = new ArrayList<>(8);

    @Override
    public abstract P onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(P holder, int position) {
        M recyclerObject = getRecyclerObject(position);
        if (recyclerObject == null) {
            return;
        }

        holder.populateView(recyclerObject, position, getItemCount());
    }

    @Override
    public int getItemCount() {
        if (recyclerObjects == null) {
            return 0;
        }

        return recyclerObjects.size();
    }

    public void addRecyclerObject(M recyclerObject) {
        addRecyclerObject(recyclerObjects.size(), recyclerObject);
    }

    public void addRecyclerObject(int position, M recyclerObject) {
        recyclerObjects.add(position, recyclerObject);
        notifyItemInserted(position);
    }

    public void addRecyclerObjects(List<M> recyclerObjects) {
        addRecyclerObjects(this.recyclerObjects.size(), recyclerObjects);
    }

    public void addRecyclerObjects(int position, List<M> recyclerObjects) {
        this.recyclerObjects.addAll(position, recyclerObjects);
        notifyItemRangeInserted(position, recyclerObjects.size());
    }

    public void removeRecyclerObject(M recyclerObject) {
        int position = recyclerObjects.indexOf(recyclerObject);
        if (position == -1) {
            return;
        }

        removeRecyclerObject(position);
    }

    public void removeRecyclerObject(int position) {
        recyclerObjects.remove(position);
        notifyItemRemoved(position);
    }

    public void updateRecyclerObject(int position, M recyclerObject) {
        if (CollectionUtils.isValidIndex(recyclerObjects, position)) {
            recyclerObjects.remove(position);
            recyclerObjects.add(position, recyclerObject);
            notifyItemChanged(position);
        }
    }

    public M getRecyclerObject(int position) {
        if (recyclerObjects.size() <= position || position < 0) {
            return null;
        }

        return recyclerObjects.get(position);
    }

    public List<M> getRecyclerObjects() {
        return recyclerObjects;
    }

    public void setRecyclerObjects(List<M> recyclerObjects) {
        this.recyclerObjects = recyclerObjects;
        notifyDataSetChanged();
    }
}