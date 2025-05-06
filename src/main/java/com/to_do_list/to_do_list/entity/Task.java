package com.to_do_list.to_do_list.entity;

import com.to_do_list.to_do_list.enums.StatusTask;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Task")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 40)
    private String taskName;

    @Column(nullable = false, length = 150)
    private String description;


    @Column(nullable = false)
    private StatusTask statusTask;
}
