package ru.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode

public class Priority {
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
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    public String getColor() {
        return color;
    }

}
