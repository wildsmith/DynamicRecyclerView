package com.wildsmith.dynamicrecyclerview.generic;

import com.wildsmith.dynamicrecyclerview.RecyclerModelView;

/**
 * GenericRecyclerViewItemView is an interface that all recycler views should use to ensure they have the mandatory methods for view
 * population by {@link GenericRecyclerViewHolder}
 */
public interface GenericRecyclerModelView<M extends GenericRecyclerModel, L extends GenericRecyclerModelListener> extends
    RecyclerModelView {

    void populateView(M model, int position, int size);

    void setListener(L listener);
}