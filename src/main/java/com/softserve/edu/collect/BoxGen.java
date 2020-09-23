package com.softserve.edu.collect;

public class BoxGen<T> {
    private T obj;  // new T(); Error
    //static T t;

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }
}