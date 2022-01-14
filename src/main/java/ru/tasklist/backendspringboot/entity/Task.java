package ru.tasklist.backendspringboot.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@EqualsAndHashCode

public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer completed;
    private Date date;
    private Priority priority;
    private Category category;
    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }
    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }
    @Basic
    @Column(name = "completed", nullable = true)
    public Integer getCompleted() {
        return completed;
    }
    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

//Ссылка на объект Priority
//Одна ссылка на один объект
    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    public Priority getPriority() {
        return priority;
    }

    //Ссылка на объект Category
//Одна ссылка на один объект
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public Category getCategory() {
        return category;
    }

}
