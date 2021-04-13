package com.integrator.test.country.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "country")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer code;

    @Column(nullable = false, length = 100)
    private String name;


}
