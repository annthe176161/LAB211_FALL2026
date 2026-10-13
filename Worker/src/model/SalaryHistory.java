/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import constants.SalaryStatus;
import java.time.LocalDate;

/**
 *
 * @author admin
 */
public class SalaryHistory {

    private double salaryAfter;
    private SalaryStatus status;
    private LocalDate date;

    public SalaryHistory() {
    }

    public SalaryHistory(double salaryAfter, SalaryStatus status, LocalDate date) {
        this.salaryAfter = salaryAfter;
        this.status = status;
        this.date = date;
    }

    public double getSalaryAfter() {
        return salaryAfter;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }
}
