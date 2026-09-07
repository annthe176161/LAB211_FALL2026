package main;

import constant.DisplayMessages;
import constant.InputMessages;
import constant.ShapeConstants;
import model.Circle;
import model.Rectangle;
import model.Triangle;
import util.DataInputHelper;

public class Main {

    // Entry point cua chuong trinh
    public static void main(String[] args) {
        System.out.println(DisplayMessages.PROGRAM_TITLE);

        double width = inputShapeValue(
                InputMessages.PROMPT_RECTANGLE_WIDTH);
        double length = inputShapeValue(
                InputMessages.PROMPT_RECTANGLE_LENGTH);
        Rectangle rectangle = new Rectangle(width, length);

        double radius = inputShapeValue(
                InputMessages.PROMPT_CIRCLE_RADIUS);
        Circle circle = new Circle(radius);

        Triangle triangle = inputTriangle();

        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

    // Doc so duong nguoi dung nhap cho mot kich thuoc cua hinh
    private static double inputShapeValue(String prompt) {
        return DataInputHelper.inputDouble(
                prompt,
                InputMessages.ERROR_NOT_A_NUMBER,
                InputMessages.ERROR_NON_POSITIVE,
                ShapeConstants.MIN_POSITIVE_VALUE);
    }

    // Nhap ba canh va kiem tra den khi tao duoc tam giac hop le
    private static Triangle inputTriangle() {
        while (true) {
            double sideA = inputShapeValue(
                    InputMessages.PROMPT_TRIANGLE_SIDE_A);
            double sideB = inputShapeValue(
                    InputMessages.PROMPT_TRIANGLE_SIDE_B);
            double sideC = inputShapeValue(
                    InputMessages.PROMPT_TRIANGLE_SIDE_C);

            if (Triangle.isValid(sideA, sideB, sideC)) {
                return new Triangle(sideA, sideB, sideC);
            }
            System.out.println(InputMessages.ERROR_INVALID_TRIANGLE);
        }
    }
}