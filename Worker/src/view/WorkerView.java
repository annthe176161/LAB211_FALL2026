/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import dto.SalaryHistoryResponseDTO;
import java.util.List;

/**
 *
 * @author admin
 */
public class WorkerView {

    private List<SalaryHistoryResponseDTO> data;

    public void setData(List<SalaryHistoryResponseDTO> historyList) {
        this.data = historyList;
    }

    public void display() {
        System.out.printf("%-10s%-15s%-10s%-15s%-10s%-15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (SalaryHistoryResponseDTO h : data) {
            System.out.println(h);
        }
    }

}
