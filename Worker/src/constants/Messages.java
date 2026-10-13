/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constants;

/**
 *
 * @author admin
 */
public final class Messages {

    private Messages() {
    }

    public final static String MENU
            = "\n========= Worker Management =========\n"
            + "1. Add Worker\n"
            + "2. Up Salary\n"
            + "3. Down Salary\n"
            + "4. Display Information salary\n"
            + "5. Exit\n";

    public final static String TITLLE_ADD = "--------- Add Worker ---------\n";
    public final static String TITLLE_UP_DOWN = "------- Up/Down Salary -------\n";
    public final static String TITLLE_DISPLAY_SALARY = "----------------------- Display Information Salary -----------------------\n";

    public final static String INPUT_CHOICE = "Enter your choice: ";
    public final static String INPUT_CODE = "Enter Code: ";
    public final static String INPUT_NAME = "Enter Name: ";
    public final static String INPUT_AGE = "Enter Age: ";
    public final static String INPUT_SALARY = "Enter Salary: ";
    public final static String INPUT_LOCATION = "Enter work location: ";

    public final static String DUPLICATE = "WorkerId is exists in system!";
    public final static String EMPTY_DATABASE = "Dont have worker in system!";
    public final static String DONT_EXISTS = "Worker dont not exists!";
    public final static String ERROR_AMOUNT_DOWN = "Amount must be smaller than current salary!";
    public final static String EMPTY_INPUT = "Input is empty!";
    public final static String INVALID_RANGE = "Choice out of range!";
    public final static String INVALID_NUMBER = "Choice must be number!";
    public final static String AGE_ERROR = "Age must be in range!";
    public final static String POSITIVE_NUMBER = "Value must be greater than 0!";
}
