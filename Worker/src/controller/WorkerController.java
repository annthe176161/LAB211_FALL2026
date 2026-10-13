/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dto.SalaryHistoryResponseDTO;
import dto.WorkerRequestDTO;
import java.util.List;
import service.WorkerService;
import view.WorkerView;

/**
 *
 * @author admin
 */
public class WorkerController {

    private WorkerService service;
    private WorkerView view;

    public WorkerController() {
        this.service = new WorkerService();
        this.view = new WorkerView();
    }

    public void addWorker(WorkerRequestDTO dto) throws Exception {
        this.service.addWorker(dto);
    }

    public void increaseSalary(String workerId, double amount) throws Exception {
        this.service.increaseSalary(workerId, amount);
    }

    public void decreaseSalary(String workerId, double amount) throws Exception {
        this.service.decreaseSalary(workerId, amount);
    }

    public void displaySalaryHistory() {
        List<SalaryHistoryResponseDTO> historyList = this.service.getSalaryHistory();
        this.view.setData(historyList);
        this.view.display();
    }

}
