package model;

import constant.DisplayMessages;
import constant.ShapeConstants;
import constant.ValidationMessages;

// Lop hinh chu nhat co chieu rong va chieu dai
public class Rectangle extends Shape {

    private final double width;
    private final double length;

    // Khoi tao hinh chu nhat voi kich thuoc cu the
    public Rectangle(double width, double length) {
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException(
                    ValidationMessages.ERROR_RECTANGLE_POSITIVE);
        }
        this.width = width;
        this.length = length;
    }

    // Lay chieu rong
    public double getWidth() {
        return width;
    }

    // Lay chieu dai
    public double getLength() {
        return length;
    }

    // Tinh dien tich hinh chu nhat
    @Override
    public double getArea() {
        return this.width * this.length;
    }

    // Tinh chu vi hinh chu nhat
    @Override
    public double getPerimeter() {
        return (this.width + this.length) * ShapeConstants.RECTANGLE_SIDE_COUNT;
    }

    // Hien thi thong tin hinh chu nhat
    @Override
    public void printResult() {
        System.out.println(DisplayMessages.RECTANGLE_HEADER);
        System.out.println(DisplayMessages.LABEL_WIDTH + this.width);
        System.out.println(DisplayMessages.LABEL_LENGTH + this.length);
        System.out.println(DisplayMessages.LABEL_AREA + getArea());
        System.out.println(DisplayMessages.LABEL_PERIMETER + getPerimeter());
    }
}