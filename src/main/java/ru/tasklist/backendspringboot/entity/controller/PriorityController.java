package ru.tasklist.backendspringboot.entity.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tasklist.backendspringboot.entity.Priority;
import ru.tasklist.backendspringboot.entity.util.MyLogger;
import ru.tasklist.backendspringboot.repo.PriorityRepository;
import ru.tasklist.backendspringboot.search.PrioritySearchValues;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/priority")
public class PriorityController {
    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/all")
    public List<Priority> findAllBy() {
        MyLogger.showMethodName("PriorityController: all() -----------------------------------------------");
        return priorityRepository.findAllByOrderByIdDesc();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody Priority priority) {
        MyLogger.showMethodName("PriorityController: add() -----------------------------------------------");

        // проверка на обязательные параметры
        if (priority.getId() != null && priority.getId() != 0) {
            // id создается автоматически в БД (autoincrement), поэтому его передавать не нужно, иначе может быть конфликт уникальности значения
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение title
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }


        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> update(@RequestBody Priority priority) {
        MyLogger.showMethodName("PriorityController: update() -----------------------------------------------");

        // проверка на обязательные параметры
        if (priority.getId() == null && priority.getId() == 0) {

            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение title
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }

        // если передали пустое значение color
        if (priority.getColor() == null || priority.getColor().trim().length() == 0) {
            return new ResponseEntity("missed param: color", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(priorityRepository.save(priority));
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id) {
        MyLogger.showMethodName("PriorityController: id() -----------------------------------------------");

        Priority priority = null;
        try {
            priority = priorityRepository.findById(id).get();
        }catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id =" +id+ " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priority) ;
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Priority> delete(@PathVariable Long id) {
        MyLogger.showMethodName("PriorityController: delete/{id}() -----------------------------------------------");


        try {
            priorityRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id =" +id+ " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }




    @PostMapping("/search")
    public ResponseEntity<List<Priority>> search(@RequestBody PrioritySearchValues prioritySearchValues) {
        MyLogger.showMethodName("PriorityController: delete/{id}() -----------------------------------------------");

        return ResponseEntity.ok(priorityRepository.findByTitle(prioritySearchValues.getText()));
    }
}



