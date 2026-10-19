/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import constants.SalaryStatus;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Worker {

    private String id;
    private String name;
    private int age;
    private double currentSalary;
    private String location;
    private List<SalaryHistory> history;

    public Worker(String id, String name, int age, double currentSalary, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.currentSalary = currentSalary;
        this.location = location;
        this.history = new ArrayList<>();
        this.history.add(new SalaryHistory(currentSalary, SalaryStatus.NEW, LocalDate.now()));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public String getLocation() {
        return location;
    }

    public List<SalaryHistory> getHistory() {
        return history;
    }

    // Ham chinh sua luong
    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }

    // Ham them lich su moi
    public void addHistory(SalaryHistory salaryHistory) {
        this.history.add(salaryHistory);
    }
}
