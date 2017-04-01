package com.wasu.utils;

/**
 * Created by kale on 2017/3/26.
 */
public class MyLinkedList1 {
    private Node first;
    private Node last;

    private int size;

    public void add(Object obj) {
        Node n = new Node();
        if (first == null) {
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
            last = n;
        } else {
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);
            last = n;
        }
        size++;
    }

    public int size() {
        return size;
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

    public Object get(int index) {
        rangeCheck(index);
        Node tmp = node(index);
        return tmp.getObj();
    }

    public Node node(int index) {
        Node tmp = null;
        if (first != null) {
            if (index < size >> 1) {
                tmp = first;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.getNext();
                }
            } else {
                tmp = last;
                for (int i = size - 1; i > index; i--) {
                    tmp = tmp.getPrevious();
                }
            }
        }
        return tmp;
    }

    public void remove(int index) {
        rangeCheck(index);
        Node tmp = node(index);
        if (tmp != null) {
            Node up = tmp.getPrevious();
            Node down = tmp.getNext();
            up.setNext(down);
            down.setPrevious(up);
            size--;
        }
    }

    public void add(int index, Object obj) {
        Node tmp = node(index);
        Node newNode = new Node();
        newNode.setObj(obj);
        if (tmp != null) {
            Node up = tmp.getPrevious();
            up.setNext(newNode);
            newNode.setPrevious(up);

            newNode.setNext(tmp);
            tmp.setPrevious(newNode);

            size++;
        }
    }
}
