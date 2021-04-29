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
     * Код документа
     */
    @Id
    @Column(name = "doc_code", nullable = false, length = 2, unique = true)
    private Integer code;

    /**
     * Название документа
     */
    @Column(name = "doc_name", nullable = false, length = 100, unique = true)
    private String name;



}
