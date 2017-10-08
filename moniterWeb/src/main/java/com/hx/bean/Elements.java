package com.hx.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahchen on 2017/10/8.
 */
public class Elements {
    private List<String> keys = new ArrayList<>();
    private List<List<String>> values = new ArrayList<>();

    public List<String> getKeys() {
        return keys;
    }

    public void addKey(String key) {
        this.keys.add(key);
    }

    public List<List<String>> getValues() {
        return values;
    }

    public void addValue(List<String> value) {
        this.values.add(value);
    }
}
