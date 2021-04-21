package com.integrator.test.office.model;

import com.integrator.test.organization.model.Organization;
import com.integrator.test.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Офис
 */
@Entity
@Table(name = "office")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Office {

    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название офиса
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     *  Адресс офиса
     */
    @Column(nullable = false, length = 50)
    private String address;

    /**
     * Телефон офиса
     */
    @Column(length = 50)
    private String phone;

    /**
     * Статус активности
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Поле связи с первичным ключём организации
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;

    /**
     * Сотрудники офиса
     */
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<User> users;


}
