package util;

import java.util.Scanner;

// Lop tien ich doc va kiem tra du lieu nhap tu ban phim
public class DataInputHelper {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Chan tao instance cua lop tien ich
    private DataInputHelper() {
    }

    // Doc so thuc tu nguoi dung, yeu cau gia tri lon hon min
    public static double inputDouble(
            String prompt, String errFormat, String errNegative, double min) {
        while (true) {
            try {
                System.out.print(prompt);
                double result = Double.parseDouble(SCANNER.nextLine().trim());
                if (result > min) {
                    return result;
                }
                System.out.println(errNegative);
            } catch (NumberFormatException e) {
                System.out.println(errFormat);
            }
        }
    }
}