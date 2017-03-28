package com.wasu.utils;

/**
 * Created by kale on 2017/3/26.
 */
public class MyHashMap {
    MyEntry[] arr = new MyEntry[999];
    int size;

    public void put(Object key, Object value) {

        for (int i = 0; i < size; i++) {
            if (arr[i].getKey().equals(key)) {
                arr[i].setValue(value);
                return;
            }
        }

        MyEntry tmp = new MyEntry(key, value);
        arr[size++] = tmp;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getKey().equals(key)) {
                return arr[i].getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (arr[i].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
