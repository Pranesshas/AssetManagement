package com.javatechie.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javatechie.crud.example.model.ProductDTO;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;


@SqlResultSetMapping(
	name = "ProductMapping",
	classes = @ConstructorResult(
				targetClass = ProductDTO.class,
				columns = {
					@ColumnResult(name="id", type = Long.class),
					@ColumnResult(name="cd_rom", type = String.class),
					@ColumnResult(name="hdd", type = String.class),
					@ColumnResult(name="os", type = String.class),
					@ColumnResult(name="processor", type = String.class),
					@ColumnResult(name="ram", type = String.class),
                    @ColumnResult(name="date", type = Date.class),
                    @ColumnResult(name="is_available", type = boolean.class),
                    @ColumnResult(name="is_declared", type = boolean.class),
					@ColumnResult(name="laptop_number", type = String.class),					
					
					
                    
					@ColumnResult(name="make", type = String.class),
					@ColumnResult(name="model_no", type = String.class),
                    @ColumnResult(name="is_old", type = boolean.class),
					@ColumnResult(name="product_name", type = String.class),
					@ColumnResult(name="product_number", type = String.class),
                    @ColumnResult(name="is_active",type = boolean.class),
                    @ColumnResult(name="note",type = String.class)

										
					
			}
	)
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_available")
    private boolean is_available=true;

    // @ManyToOne(fetch= FetchType.EAGER)
    // @JoinColumn(name="assignedUser_id", nullable = true)
	// private User user;

    @Column(name = "laptop_number")
    private String laptop_number;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="product_type", nullable = true)
    private Asset product_type;

    @Column(name = "make")
    private String make;

    @Column(name = "Processor")
    private String Processor;
    
    @Column(name = "product_number")
    private String product_number;

    @Column(name="RAM")
    private String ram;

    @Column(name="HDD")
    private String hdd;

    @Column(name="CD_ROM")
    private String cd_rom;

    // @Column(name="mouse")
    // private String mouse;

    // @Column(name="Mic")
    // private String mic;

    @Column(name="OS")
    private String os;

    @Column(name="model_no")
    private String model_no;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    // @Convert(converter = LocalDatePersistanceConverter.class)
    private Instant date;

    @Column(name="is_old")
    private boolean old = false;

    @Column(name="is_declared")
    private boolean is_declared = false;
    
    @Column(name="is_active")
    private boolean is_active = true;

    @Column(name = "Asset_number", length=500)
    private String Asset_number;
    
    @Column(name = "note", length=500)
    private String note;
    

   


}
