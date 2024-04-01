package net.myapp.springboot.service;

import net.myapp.springboot.model.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> getAllWorkers();

    void saveWorker(Worker worker);

    Worker getWorkerById(long id);

    void deleteWorkerById(long id);
}
