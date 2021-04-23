package com.integrator.test.office.model;

import com.integrator.test.organization.model.Organization;
import com.integrator.test.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Офис
 */
@Entity
@Table(name = "office")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
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
    @NonNull
    @Column(nullable = false, length = 50)
    private String name;

    /**
     *  Адресс офиса
     */
    @NonNull
    @Column(nullable = false, length = 50)
    private String address;

    /**
     * Телефон офиса
     */
    @NonNull
    @Column(length = 50)
    private String phone;

    /**
     * Статус активности
     */
    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * Поле связи с первичным ключём организации
     */
    @NonNull
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
