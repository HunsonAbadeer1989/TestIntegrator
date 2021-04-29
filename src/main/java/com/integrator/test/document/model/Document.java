package com.integrator.test.document.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Документ сотрудника
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(value = DocumentId.class)
public class Document {

    /**
     * Код документа
     */
    @Id
    @Column(name = "doc_code", nullable = false, length = 255)
    private String docCode;

    /**
     * Номер документа
     */
    @Id
    @Column(name = "doc_number", nullable = false, length = 255)
    private String docNumber;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date", nullable = false)
    private LocalDate docDate;

}
