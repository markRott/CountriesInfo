package com.test.countriesapp.base;

/**
 * Created by sma on 10.10.17.
 */

public interface IRecyclerItemTouchListener<Item> {

    void onTouch(int position, Item data);
}