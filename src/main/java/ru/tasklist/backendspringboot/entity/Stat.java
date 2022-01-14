package ru.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode
public class Stat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "completed_total", nullable = true)
    private Long completedTotal;
    public Long getCompletedTotal() {
        return completedTotal;
    }

    @Basic
    @Column(name = "uncompleted_total", nullable = true)
    private Long uncompletedTotal;
    public Long getUncompletedTotal() {
        return uncompletedTotal;
    }


}
