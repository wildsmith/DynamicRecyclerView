package com.wildsmith.dynamicrecyclerview.generic;

import android.support.annotation.LayoutRes;

import com.wildsmith.dynamicrecyclerview.RecyclerModel;

/**
 * GenericRecyclerViewItem interface used to enforce a generic structure onto the implementers of this interface which is used by the {@link
 * GenericRecyclerAdapter}
 */
public interface GenericRecyclerModel extends RecyclerModel {

    @LayoutRes
    int getLayoutId();
}