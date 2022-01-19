package ru.tasklist.backendspringboot.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.tasklist.backendspringboot.entity.Stat;

import java.util.List;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {
    List<Stat> findAllByOrderByIdAsc();
}
