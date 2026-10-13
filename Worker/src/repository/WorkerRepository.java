/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dto.WorkerRequestDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Worker;

/**
 *
 * @author admin
 */
public class WorkerRepository {

    private Map<String, Worker> workerMap;

    public WorkerRepository() {
        this.workerMap = new HashMap<>();
    }

    public boolean exists(String id) {
        return this.workerMap.containsKey(id);
    }

    public boolean isEmpty() {
        return this.workerMap.isEmpty();
    }

    public Worker findById(String workerId) {
        return this.workerMap.get(workerId);
    }

    public List<Worker> findAll() {
        return new ArrayList<>(this.workerMap.values());
    }

    public void save(Worker worker) {
        this.workerMap.put(worker.getId(), worker);
    }
}
