package com.wildsmith.dynamicrecyclerview.generic;

import android.support.annotation.Nullable;
import android.view.View;

import com.wildsmith.dynamicrecyclerview.RecyclerViewHolder;

import java.lang.ref.WeakReference;

public class GenericRecyclerViewHolder<M extends GenericRecyclerModel, V extends GenericRecyclerModelView> extends
    RecyclerViewHolder<M, V> {

    private WeakReference<GenericRecyclerModelListener> listenerWeakReference;

    public GenericRecyclerViewHolder(View view) {
        super(view);
    }

    public GenericRecyclerViewHolder(View view, GenericRecyclerModelListener listener) {
        super(view);
        this.listenerWeakReference = new WeakReference<>(listener);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void populateView(M recyclerObject, int position, int size) {
        if (container == null) {
            return;
        }

        container.setListener(getListener());
        container.populateView(recyclerObject, position, size);
    }

    @Nullable
    public GenericRecyclerModelListener getListener() {
        if (listenerWeakReference == null) {
            return null;
        }

        return listenerWeakReference.get();
    }
}