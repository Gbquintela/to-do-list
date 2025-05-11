package com.to_do_list.to_do_list.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.to_do_list.to_do_list.enums.StatusTask;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 40)
    private String taskName;

    @Column(nullable = false, length = 150)
    private String taskDescription;


    @Column(nullable = false)
    private StatusTask statusTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
