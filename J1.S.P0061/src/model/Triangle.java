package model;

import constant.DisplayMessages;
import constant.ShapeConstants;
import constant.ValidationMessages;

// Lop hinh tam giac co ba canh
public class Triangle extends Shape {

    private final double sideA;
    private final double sideB;
    private final double sideC;

    // Khoi tao tam giac voi ba canh cu the
    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValid(sideA, sideB, sideC)) {
            throw new IllegalArgumentException(
                    ValidationMessages.ERROR_TRIANGLE_INVALID);
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Lay canh A
    public double getSideA() {
        return sideA;
    }

    // Lay canh B
    public double getSideB() {
        return sideB;
    }

    // Lay canh C
    public double getSideC() {
        return sideC;
    }

    // Kiem tra 3 canh co tao thanh tam giac hop le hay khong
    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Tinh dien tich tam giac theo cong thuc Heron
    @Override
    public double getArea() {
        double s = getPerimeter() / ShapeConstants.TRIANGLE_HALF_DIVISOR;
        return Math.sqrt(s * (s - this.sideA) * (s - this.sideB)
                * (s - this.sideC));
    }

    // Tinh chu vi tam giac
    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    // Hien thi thong tin tam giac
    @Override
    public void printResult() {
        System.out.println(DisplayMessages.TRIANGLE_HEADER);
        System.out.println(DisplayMessages.LABEL_SIDE_A + this.sideA);
        System.out.println(DisplayMessages.LABEL_SIDE_B + this.sideB);
        System.out.println(DisplayMessages.LABEL_SIDE_C + this.sideC);
        System.out.println(DisplayMessages.LABEL_AREA + getArea());
        System.out.println(DisplayMessages.LABEL_PERIMETER + getPerimeter());
    }
}