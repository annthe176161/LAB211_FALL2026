package constant;

// Lop chua hang so prompt va thong bao loi khi nhap lieu
public final class InputMessages {

    public static final String PROMPT_RECTANGLE_WIDTH =
            "Please input side width of Rectangle: ";
    public static final String PROMPT_RECTANGLE_LENGTH =
            "Please input length of Rectangle: ";
    public static final String PROMPT_CIRCLE_RADIUS =
            "Please input radius of Circle: ";
    public static final String PROMPT_TRIANGLE_SIDE_A =
            "Please input side A of Triangle: ";
    public static final String PROMPT_TRIANGLE_SIDE_B =
            "Please input side B of Triangle: ";
    public static final String PROMPT_TRIANGLE_SIDE_C =
            "Please input side C of Triangle: ";

    public static final String ERROR_NOT_A_NUMBER =
            "Data input must be a number. Please input again!";
    public static final String ERROR_NON_POSITIVE =
            "Data input must be greater than 0. Please input again!";
    public static final String ERROR_INVALID_TRIANGLE =
            "These sides do not form a valid triangle! "
            + "Please re-input all 3 sides.";

    // Chan tao instance cua lop hang so
    private InputMessages() {
    }
}