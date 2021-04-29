package com.integrator.test.country.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    /**
     * Код страны
     */
    @Id
    @Column(nullable = false, unique = true)
    private String code;

    /**
     * Название страны
     */
    @Column(nullable = false, length = 100)
    private String name;

}
