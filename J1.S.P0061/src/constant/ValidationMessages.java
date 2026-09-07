package constant;

// Lop chua thong bao loi nest ra tu constructors
public final class ValidationMessages {

    public static final String ERROR_RADIUS_POSITIVE =
            "Radius must be greater than 0.";
    public static final String ERROR_RECTANGLE_POSITIVE =
            "Width and length must be greater than 0.";
    public static final String ERROR_TRIANGLE_INVALID =
            "Sides do not form a valid triangle.";

    // Chan tao instance cua lop hang so
    private ValidationMessages() {
    }
}