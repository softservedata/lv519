package com.softserve.edu.collect;

public class BoxWrapper {
    private Box box;

    public BoxWrapper() {
        box = new Box();
    }

    public void set(Integer obj) {
        // this.obj = obj;
        box.set(obj);
    }

    public Integer get() {
        // return obj;
        return (Integer) box.get(); // Ok
    }
}