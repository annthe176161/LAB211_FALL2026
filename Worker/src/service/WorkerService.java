/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import constants.Messages;
import constants.SalaryStatus;
import dto.SalaryHistoryResponseDTO;
import dto.WorkerRequestDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.SalaryHistory;
import model.Worker;
import repository.WorkerRepository;

/**
 *
 * @author admin
 */
public class WorkerService {

    private WorkerRepository repository;

    public WorkerService() {
        this.repository = new WorkerRepository();
    }

    public void addWorker(WorkerRequestDTO dto) throws Exception {
        if (this.repository.exists(dto.getId())) {
            throw new Exception(Messages.DUPLICATE);
        } else {
            Worker worker = new Worker(dto.getId(), dto.getName(), dto.getAge(), dto.getSalary(), dto.getLocation());
            // Them lich su luong khoi diem
            worker.addHistory(new SalaryHistory(worker.getCurrentSalary(), SalaryStatus.UP, LocalDate.now()));
            this.repository.save(worker);
        }
    }

    public void increaseSalary(String workerId, double amount) throws Exception {
        if (this.repository.isEmpty()) {
            throw new Exception(Messages.EMPTY_DATABASE);
        } else {
            Worker worker = this.repository.findById(workerId);
            if (Objects.isNull(worker)) {
                throw new Exception(Messages.DONT_EXISTS);
            } else {
                double currentSalary = worker.getCurrentSalary();
                double newSalary = currentSalary + amount;
                worker.setCurrentSalary(newSalary);
                worker.addHistory(new SalaryHistory(newSalary, SalaryStatus.UP, LocalDate.now()));
            }
        }
    }

    public void decreaseSalary(String workerId, double amount) throws Exception {
        if (this.repository.isEmpty()) {
            throw new Exception(Messages.EMPTY_DATABASE);
        } else {
            Worker worker = this.repository.findById(workerId);
            if (Objects.isNull(worker)) {
                throw new Exception(Messages.DONT_EXISTS);
            } else {
                double currentSalary = worker.getCurrentSalary();
                if (amount >= currentSalary) {
                    throw new Exception(Messages.ERROR_AMOUNT_DOWN);
                }
                double newSalary = currentSalary - amount;
                worker.setCurrentSalary(newSalary);
                worker.addHistory(new SalaryHistory(newSalary, SalaryStatus.DOWN, LocalDate.now()));
            }
        }
    }

    public List<SalaryHistoryResponseDTO> getSalaryHistory() {
        List<SalaryHistoryResponseDTO> result = new ArrayList<>();
        List<Worker> workers = this.repository.findAll();
        for (Worker w : workers) {
            for (SalaryHistory h : w.getHistory()) {
                result.add(new SalaryHistoryResponseDTO(
                        w.getId(), w.getName(), w.getAge(), h.getSalaryAfter(), h.getStatus().name(), h.getDate()
                ));
            }
        }
        return result;
    }
}
