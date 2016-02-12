package com.wildsmith.dynamicrecyclerview.utils;

import java.util.Collection;

public class CollectionUtils {

    /**
     * Is this list empty. Checks for null as well as size.
     *
     * @return true if empty, false if not
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Check to see if the given index is with in the range of collection items
     *
     * @return true if the index is a index in the list, false otherwise
     */
    public static boolean isValidIndex(Collection collection, int index) {
        return !isEmpty(collection) && index < collection.size() && index >= 0;
    }
}