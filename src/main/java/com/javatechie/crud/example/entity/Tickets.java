package com.javatechie.crud.example.entity;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tickets")
public class Tickets {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id", nullable = true)
	private User user;

    @Column(name="status")
    private boolean status = false;

    @Column(name="step", columnDefinition = "integer default 0")
    private long steps ;
}
