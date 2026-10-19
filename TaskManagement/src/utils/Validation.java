package utils;

import constants.Message;
import constants.TaskType;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Validation {

    private Validation() {
    }

    // Chuoi khong duoc rong
    public static String getString(String input) throws Exception {
        if ((input == null) || (input.trim().isEmpty())) {
            throw new Exception(Message.EMPTY_INPUT);
        }
        return input.trim();
    }

    // So nguyen duong
    public static int getPositiveInt(String input) throws Exception {
        try {
            int value = Integer.parseInt(getString(input));
            if (value <= 0) {
                throw new Exception(Message.INVALID_ID_POSITIVE);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_ID_NUMBER);
        }
    }

    // So thuc duong
    public static double getPositiveDouble(String input) throws Exception {
        try {
            return Double.parseDouble(getString(input));
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_TIME_NUMBER);
        }
    }

    // Validate task type
    public static int validateTaskType(String input) throws Exception {
        try {
            int id = Integer.parseInt(getString(input));
            if (id < 1 || id > TaskType.values().length) {
                throw new Exception(Message.INVALID_TASK_TYPE_RANGE);
            }
            return id;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_TASK_TYPE_NUMBER);
        }
    }

    // Validate date
    public static Date validateDate(String input) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            return sdf.parse(input);
        } catch (Exception e) {
            throw new Exception(Message.INVALID_DATE);
        }
    }

    public static double validatePlanTimeInput(String input) throws Exception {
        BigDecimal value;
        try {
            value = new BigDecimal(getString(input));
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_TIME_NUMBER);
        }

        validateHalfHourStep(value);
        validateTimeRange(value);
        return value.doubleValue();
    }

    private static void validateHalfHourStep(BigDecimal value) throws Exception {
        if (value.remainder(new BigDecimal("0.5")).compareTo(BigDecimal.ZERO) != 0) {
            throw new Exception(Message.INVALID_TIME_FORMAT);
        }
    }

    private static void validateTimeRange(BigDecimal value) throws Exception {
        if (value.compareTo(new BigDecimal("8.0")) < 0
                || value.compareTo(new BigDecimal("17.5")) > 0) {
            throw new Exception(Message.INVALID_TIME_RANGE);
        }
    }

    /*
    public static double validatePlanTimeInputWithoutBigDecimal(String input) throws Exception {
        String normalized = getString(input);
        if (!normalized.matches("\\d+(?:\\.0+|\\.5(?:0*)?)?")) {
            throw new Exception(Message.INVALID_TIME_FORMAT);
        }

        double value = getPositiveDouble(normalized);
        if (value < 8.0 || value > 17.5) {
            throw new Exception(Message.INVALID_TIME_RANGE);
        }
        return value;
    }
    */

    // Validate working time
    public static void validatePlanTime(double from, double to) throws Exception {
        if (to <= from) {
            throw new Exception(Message.INVALID_TIME_ORDER);
        }
    }

    // Validate menu choice
    public static int getChoice(String input, int min, int max) throws Exception {
        try {
            int choice = Integer.parseInt(getString(input));
            if ((choice < min) || (choice > max)) {
                throw new Exception(Message.INVALID_CHOICE_RANGE);
            }
            return choice;
        } catch (NumberFormatException e) {
            throw new Exception(Message.INVALID_CHOICE_NUMBER);
        }
    }

    public static int validateTaskId(String input) throws Exception {
        return getPositiveInt(input);
    }
}
