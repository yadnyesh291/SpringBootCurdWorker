package net.myapp.springboot.controller;

import net.myapp.springboot.model.Worker;
import net.myapp.springboot.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Worker> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);
        return "index";
    }

    @GetMapping("/showNewWorkerForm")
    public String showNewWorkerForm(Model model) {
        Worker worker = new Worker();
        model.addAttribute("worker", worker);
        return "new_worker";
    }

    @PostMapping("/saveWorker")
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        workerService.saveWorker(worker);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Worker worker = workerService.getWorkerById(id);
        model.addAttribute("worker", worker);
        return "update_worker";
    }

    @GetMapping("/deleteWorker/{id}")
    public String deleteWorker(@PathVariable(value = "id") long id) {
        workerService.deleteWorkerById(id);
        return "redirect:/";
    }
}
