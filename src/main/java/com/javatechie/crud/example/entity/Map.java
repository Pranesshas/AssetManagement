package com.javatechie.crud.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "map")
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="assigned_user_id", nullable = true)
	private User user;

    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="product_type", nullable = true)
    private Asset product_type;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="assigned_asset_id", nullable = true)
	private Product product;
 
    @Column(name="status")
    private boolean status = true;

    // @Column(name="received_date")
    // private Instant date;
    
}
