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
@Table(name = "document_type")
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
    private Long id;

    /**
     * Название документа
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * Код документа
     */
    @Column(nullable = false)
    private Integer code;

}
