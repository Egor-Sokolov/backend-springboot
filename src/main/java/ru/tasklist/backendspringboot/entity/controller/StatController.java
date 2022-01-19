package ru.tasklist.backendspringboot.entity.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tasklist.backendspringboot.entity.Stat;
import ru.tasklist.backendspringboot.entity.util.MyLogger;
import ru.tasklist.backendspringboot.repo.StatRepository;


@RestController
@RequestMapping("/stat")
public class StatController {
    private final StatRepository statRepository;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    private final Long defaultId  = 1L;
    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {
        MyLogger.showMethodName("StatController: stat() -----------------------------------------------");

        return ResponseEntity.ok(statRepository.findById(defaultId).get());
    }
}
