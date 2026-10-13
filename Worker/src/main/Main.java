/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import constants.Messages;
import controller.WorkerController;
import dto.WorkerRequestDTO;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WorkerController controller = new WorkerController();

        while (true) {
            System.out.print(Messages.MENU);
            System.out.print(Messages.INPUT_CHOICE);
            try {
                int choice = Validation.getChoice(sc.nextLine(), 1, 5);
                switch (choice) {
                    case 1:
                        WorkerRequestDTO dto = new WorkerRequestDTO();
                        System.out.print(Messages.TITLLE_ADD);
                        System.out.print(Messages.INPUT_CODE);
                        dto.setId(Validation.getString(sc.nextLine()));
                        System.out.print(Messages.INPUT_NAME);
                        dto.setName(Validation.getString(sc.nextLine()));
                        System.out.print(Messages.INPUT_AGE);
                        dto.setAge(Validation.getAge(sc.nextLine()));
                        System.out.print(Messages.INPUT_SALARY);
                        dto.setSalary(Validation.getPositiveDouble(sc.nextLine()));
                        System.out.print(Messages.INPUT_LOCATION);
                        dto.setLocation(Validation.getString(sc.nextLine()));
                        controller.addWorker(dto);
                        break;
                    case 2:
                        System.out.print(Messages.TITLLE_UP_DOWN);
                        System.out.print(Messages.INPUT_CODE);
                        String incCode = Validation.getString(sc.nextLine());
                        System.out.print(Messages.INPUT_SALARY);
                        double incSalary = Validation.getPositiveDouble(sc.nextLine());
                        controller.increaseSalary(incCode, incSalary);
                        break;
                    case 3:
                        System.out.print(Messages.TITLLE_UP_DOWN);
                        System.out.print(Messages.INPUT_CODE);
                        String decCode = Validation.getString(sc.nextLine());
                        System.out.print(Messages.INPUT_SALARY);
                        double decSalary = Validation.getPositiveDouble(sc.nextLine());
                        controller.decreaseSalary(decCode, decSalary);
                        break;
                    case 4:
                        System.out.print(Messages.TITLLE_DISPLAY_SALARY);
                        controller.displaySalaryHistory();
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
