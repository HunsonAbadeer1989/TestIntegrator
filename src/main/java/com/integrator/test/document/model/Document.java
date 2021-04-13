package com.integrator.test.document.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "document")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Document {

    @Id
    private Long id;

    @Column(name = "doc_name", nullable = false, length = 50)
    private String docName;

    @Column(name = "doc_number", nullable = false, length = 30)
    private String docNumber;

    @Column(name = "doc_date", nullable = false)
    private LocalDate docDate;

    @Column(nullable = false)
    private Integer code;



}
