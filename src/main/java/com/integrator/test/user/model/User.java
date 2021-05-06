package com.integrator.test.user.model;

import com.integrator.test.country.model.Country;
import com.integrator.test.document.model.Document;
import com.integrator.test.office.model.Office;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Сотрудник
 */
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя сотрудника
     */
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    /**
     * Фамилия сотрудника
     */
    @Column(name = "second_name", nullable = false, length = 50)
    private String secondName;

    /**
     * Отчество сотрудника
     */
    @Column(name = "middle_name", nullable = false, length = 50)
    private String middleName;

    /**
     * Должность сотрудника
     */
    @Column(nullable = false, length = 50)
    private String position;

    /**
     * Телефон сотрудника
     */
    @Column(length = 50)
    private String phone;

    /**
     * Страна сотрудника, гражданство
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country citizenshipCode;

    /**
     * Статус подтверждения документа сотрудника
     */
    @Column(name = "is_identified")
    private Boolean isIdentified;

    /**
     * Документ сотрудника
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Document document;

    /**
     * Офис сотрудника
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", nullable = false)
    private Office office;

}
