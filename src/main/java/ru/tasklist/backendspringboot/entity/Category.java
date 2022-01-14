package ru.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Setter
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    private String title;
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "completed_count", nullable = true)
    private Long completedCount;
    public Long getCompletedCount() {
        return completedCount;
    }

    @Basic
    @Column(name = "uncompleted_count", nullable = true)
    private Long uncompletedCount;
    public Long getUncompletedCount() {
        return uncompletedCount;
    }


}
