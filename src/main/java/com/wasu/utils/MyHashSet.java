package com.wasu.utils;

import java.util.HashMap;
import java.util.Observable;

/**
 * Created by kale on 2017/3/30.
 */
public class MyHashSet {
    HashMap map;

    private static  final Object PRESENT=new Object();

    public MyHashSet(){
        map=new HashMap();
    }

    public int size(){
        return map.size();
    }

    public void add(Object obj){
        map.put(obj,PRESENT);
    }

    public void remove(Object obj){
        for (Object item:map.keySet()){
            if(item.equals(obj)){
                map.remove(obj);
            }
        }
    }
}
