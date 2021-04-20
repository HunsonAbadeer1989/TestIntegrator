package com.integrator.test.document.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Тип документа сотрудника
 */
@Entity
@Table(name = "doc_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentType {

    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Название документа
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Код документа
     */
    @Column(nullable = false, length = 2)
    private Integer code;

}
