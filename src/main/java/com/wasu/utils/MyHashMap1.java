package com.wasu.utils;

/**
 * Created by kale on 2017/3/26.
 */
public class MyHashMap1 {
    MyLinkedList1[] arr = new MyLinkedList1[999];
    int size;

    public void put(Object key, Object value) {
        MyEntry e = new MyEntry(key, value);

        int hash = key.hashCode();
        hash = hash < 0 ? -hash : hash;
        int a = hash % 999;
        if (arr[a] == null) {
            MyLinkedList1 list = new MyLinkedList1();
            arr[a] = list;
            list.add(e);
        } else {
            MyLinkedList1 list = arr[a];
            for (int i = 0; i < list.size(); i++) {
                MyEntry e2 = (MyEntry) list.get(i);
                if (e2.getKey().equals(key)) {
                    e2.setValue(value);
                    return;
                }
            }
            arr[a].add(e);
        }
    }

    public Object get(Object key) {
        int a = key.hashCode() % 999;
        if (arr[a] != null) {
            MyLinkedList1 list = arr[a];
            for (int i = 0; i < list.size(); i++) {
                MyEntry e = (MyEntry) list.get(i);
                if (e.getKey().equals(key)) {
                    return e.getValue();
                }
            }
        }
        return null;
    }


}
