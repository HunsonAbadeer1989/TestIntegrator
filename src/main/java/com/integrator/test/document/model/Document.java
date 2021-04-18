package com.integrator.test.document.model;

import com.integrator.test.user.model.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Документ сотрудника
 */
@Entity
@Table(name = "document")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Document {

    /**
     * Первичный ключ
     */
    @Id
    private Long id;

    /**
     * Номер документа
     */
    @Column(name = "doc_number", nullable = false, length = 30)
    private String docNumber;

    /**
     * Дата выдачи документа
     */
    @Column(name = "doc_date", nullable = false)
    private LocalDate docDate;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    /**
     * Поле связи с типом документа
     */
    @ManyToOne
    @JoinColumn(name = "doc_type_id")
    private DocumentType documentType;

}
