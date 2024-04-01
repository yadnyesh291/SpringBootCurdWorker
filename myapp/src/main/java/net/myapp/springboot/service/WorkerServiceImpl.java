package net.myapp.springboot.service;

import net.myapp.springboot.model.Worker;
import net.myapp.springboot.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public void saveWorker(Worker worker) {
        workerRepository.save(worker);
    }

    @Override
    public Worker getWorkerById(long id) {
        Optional<Worker> optional = workerRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteWorkerById(long id) {
        workerRepository.deleteById(id);
    }
}
