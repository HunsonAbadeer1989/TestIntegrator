package com.integrator.test.organization.model;

import lombok.*;

import javax.persistence.*;

/**
 * Организация
 */
@Entity
@Table(name = "organization")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organization {

    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название организации
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Полное название организации
     */
    @Column(nullable = false, name = "full_name", length = 500)
    private String fullName;

    /**
     * ИНН организации
     */
    @Column(nullable = false, length = 12)
    private String inn;

    /**
     * Код причны постановки на учет
     */
    @Column(nullable = false, length = 10)
    private String kpp;

    /**
     *  Адрес организации
     */
    @Column(nullable = false, length = 500)
    private String address;

    /**
     * Телефон организации
     */
    @Column(length = 50)
    private String phone;

    /**
     * Статус активности
     */
    @Column(name = "is_active")
    private boolean isActive;

}
