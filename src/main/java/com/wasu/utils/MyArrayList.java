package com.wasu.utils;

/**
 * Created by kale on 2017/3/25.
 */
public class MyArrayList {

    private Object[] value;

    private int size;

    public MyArrayList() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        } else {
            for (int i = 0; i < value.length; i++) {
                if (value[i] == obj) {
                    return i;
                }
            }
            return -1;
        }
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        } else {
            for (int i = value.length - 1; i >= 0; i--) {
                if (value[i] == obj) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Object set(int index, Object obj) {
        rangeCheck(index);
        Object old = value[index];
        value[index] = obj;
        return old;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MyArrayList(int size) {
        if (size < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        value = new Object[size];
    }

    public void add(Object obj) {

        ensureCapacity(size+1);
        value[size++] = obj;
    }

    public Object get(int index) {
        rangeCheck(index);
        return value[index];
    }

    public void remove(int index) {
        rangeCheck(index);
        for (int i = index; i < value.length - 1; i++) {
            value[i] = value[i + 1];
        }
        value[--size] = null;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    private void ensureCapacity(int capacity){
        if (size >= capacity) {
            int newCapacity = capacity * 2;
            Object[] newList = new Object[newCapacity];
            for (int i = 0; i < capacity; i++) {
                newList[i] = value[i];
            }
            value = newList;
        }
    }

    public void add(int index, Object obj) {
        rangeCheck(index);
        ensureCapacity(size+1);
        System.arraycopy(value, index, value, index + 1, size - index);
        value[index]=obj;
        size++;
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        list.add("123");
        list.add("234");
        list.add("345");
        list.add("456");
        list.remove(2);
        System.out.println(list.get(2));
    }

}
