package com.wildsmith.dynamicrecyclerview.generic;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.wildsmith.dynamicrecyclerview.RecyclerAdapter;

import java.lang.ref.WeakReference;

/**
 * GenericRecyclerAdapter handles the inflation of {@link GenericRecyclerModelView}s
 */
public class GenericRecyclerAdapter<M extends GenericRecyclerModel, V extends GenericRecyclerModelView>
    extends RecyclerAdapter<M, V, GenericRecyclerViewHolder<M, V>> {

    protected WeakReference<GenericRecyclerModelListener> listenerWeakReference;

    public GenericRecyclerAdapter() {

    }

    public GenericRecyclerAdapter(GenericRecyclerModelListener listener) {
        this.listenerWeakReference = new WeakReference<>(listener);
    }

    @Override
    public GenericRecyclerViewHolder<M, V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GenericRecyclerViewHolder<>(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false), getListener());
    }

    @Override
    public int getItemViewType(int position) {
        GenericRecyclerModel viewItem = getRecyclerObject(position);
        return (viewItem == null) ? -1 : viewItem.getLayoutId();
    }

    @Nullable
    public GenericRecyclerModelListener getListener() {
        if (listenerWeakReference == null) {
            return null;
        }

        return listenerWeakReference.get();
    }
}