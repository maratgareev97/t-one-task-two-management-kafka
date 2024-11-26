package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.TaskProducerService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskProducerService taskProducerService;

    @PostMapping("/{taskId}/status")
    public void updateTaskStatus(@PathVariable String taskId, @RequestBody String status) {

        log.info("Method updateTaskStatus invoked with taskId: {} and status: {}", taskId, status);

        String message = String.format("{\"id\":\"%s\", \"status\":\"%s\"}", taskId, status);
        taskProducerService.sendMessage("test-topic", message);
    }
}