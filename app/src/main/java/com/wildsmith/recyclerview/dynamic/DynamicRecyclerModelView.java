package com.wildsmith.recyclerview.dynamic;

import com.wildsmith.recyclerview.RecyclerModelView;

/**
 * GenericRecyclerViewItemView is an interface that all recycler views should use to ensure they have the mandatory methods for view
 * population by {@link DynamicRecyclerViewHolder}
 */
public interface DynamicRecyclerModelView<M extends DynamicRecyclerModel, L extends DynamicRecyclerModelListener> extends
    RecyclerModelView {

    void populateView(M model, int position, int size);

    void setListener(L listener);
}