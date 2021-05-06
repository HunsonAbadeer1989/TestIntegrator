package com.integrator.test.country.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Страна сотрудника, граждансво
 */
@Entity
@Table(name = "country")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Код страны
     */
    @Column(name = "citizenship_code", nullable = false)
    private String citizenshipCode;

    /**
     * Название страны
     */
    @Column(name = "citizenship_name", length = 100, nullable = false)
    private String citizenshipName;

}
