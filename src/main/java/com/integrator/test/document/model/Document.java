package com.integrator.test.document.model;

import com.integrator.test.user.model.User;
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
public class Document {

    @Id
    private Long id;

    /**
     * Код документа
     */
    @Column(name = "doc_name", nullable = false, length = 255)
    private String docName;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", nullable = false, length = 255)
    private String docNumber;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date")
    private LocalDate docDate;

    /**
     * Пользователь, которому принадлежит документ
     */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Тип документа
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id", nullable = false)
    private DocumentType docType;
}
