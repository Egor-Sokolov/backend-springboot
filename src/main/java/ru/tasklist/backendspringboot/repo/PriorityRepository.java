package ru.tasklist.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tasklist.backendspringboot.entity.Category;
import ru.tasklist.backendspringboot.entity.Priority;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    List<Priority> findAllByOrderByIdDesc();
}
