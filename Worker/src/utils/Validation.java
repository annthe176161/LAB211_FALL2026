/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import constants.Messages;

/**
 *
 * @author admin
 */
public final class Validation {

    public static int getChoice(String input, int min, int max) throws Exception {
        try {
            int choice = Integer.parseInt(input);
            if ((choice < min) || (choice > max)) {
                throw new Exception(Messages.INVALID_RANGE);
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new Exception(Messages.INVALID_NUMBER);
        }
    }

    public static String getString(String input) throws Exception {
        if ((input == null) || (input.trim().isEmpty())) {
            throw new Exception(Messages.EMPTY_INPUT);
        }
        return input.trim();
    }

    public static int getAge(String input) throws Exception {
        try {
            int age = Integer.parseInt(input);
            if ((age < 18) || (age > 50)) {
                throw new Exception(Messages.AGE_ERROR);
            }
            return age;
        } catch (NumberFormatException e) {
            throw new Exception(Messages.INVALID_NUMBER);
        }
    }

    public static double getPositiveDouble(String input) throws Exception {
        try {
            double number = Double.parseDouble(input);
            if (number <= 0) {
                throw new Exception(Messages.POSITIVE_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception(Messages.INVALID_NUMBER);
        }
    }

    private Validation() {
    }
}
