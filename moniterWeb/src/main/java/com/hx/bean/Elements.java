package com.hx.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yahchen on 2017/10/22.
 */
public class Elements {
    private int elementSize;
    private Map<String, Object> elements = new HashMap<>();

    public Map<String, Object> getElements() {
        return elements;
    }

    public void setElements(Map<String, Object> elements) {
        this.elements = elements;
    }

    public void putAttri(String k, Object v) {
        this.elements.put(k, v);
        elementSize++;
    }
}
