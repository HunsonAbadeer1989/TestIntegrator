package com.integrator.test.country.model;

import com.integrator.test.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Код страны
     */
    @Column(nullable = false)
    private String code;

    /**
     * Название страны
     */
    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<User> userSet;

}
