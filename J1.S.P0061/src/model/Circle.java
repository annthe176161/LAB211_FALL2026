package model;

import constant.DisplayMessages;
import constant.ShapeConstants;
import constant.ValidationMessages;

// Lop hinh tron co ban kinh
public class Circle extends Shape {

    private final double radius;

    // Khoi tao hinh tron voi ban kinh cu the
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                    ValidationMessages.ERROR_RADIUS_POSITIVE);
        }
        this.radius = radius;
    }

    // Lay ban kinh
    public double getRadius() {
        return radius;
    }

    // Tinh dien tich hinh tron
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    // Tinh chu vi hinh tron
    @Override
    public double getPerimeter() {
        return ShapeConstants.CIRCLE_DIAMETER_FACTOR * Math.PI * this.radius;
    }

    // Hien thi thong tin hinh tron
    @Override
    public void printResult() {
        System.out.println(DisplayMessages.CIRCLE_HEADER);
        System.out.println(DisplayMessages.LABEL_RADIUS + this.radius);
        System.out.println(DisplayMessages.LABEL_AREA + getArea());
        System.out.println(DisplayMessages.LABEL_PERIMETER + getPerimeter());
    }
}