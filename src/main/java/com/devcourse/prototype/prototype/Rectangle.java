package com.devcourse.prototype.prototype;

public class Rectangle extends Shape {

    private int inch;

    public Rectangle() {}

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.inch = target.inch;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Rectangle) || !super.equals(object)) return false;
        Rectangle shape = (Rectangle) object;
        return shape.inch == inch;
    }

}
