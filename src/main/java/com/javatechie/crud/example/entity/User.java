package com.javatechie.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javatechie.crud.example.response.DashboardData;
@SqlResultSetMapping(
		name = "WidgetSettingMapping",
		classes = @ConstructorResult(
					targetClass = DashboardData.class,
					columns = {
                            @ColumnResult(name="user_id", type = Long.class),
                            @ColumnResult(name="asset_id", type = Long.class),
							@ColumnResult(name="name", type = String.class),
							@ColumnResult(name="project", type = String.class),
							@ColumnResult(name="make", type = String.class),
							@ColumnResult(name="product_type", type = String.class),
                            @ColumnResult(name="model_no", type = String.class),
                            @ColumnResult(name="product_number", type = String.class),



				}
		)
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user",
        uniqueConstraints = {
            @UniqueConstraint(name="uk_user_username", columnNames={"username"}),
            @UniqueConstraint(name="uk_user_email", columnNames={"email"})
        })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password ;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Long phone;
        
    @Column(name = "active")
    private boolean active = true;

    @Column(name = "project")
    private String project;
}
