package com.integrator.test.document.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DocumentId implements Serializable {

    /**
     * Код документа
     */
    private String docCode;

    /**
     * Номер документа
     */
    private String docNumber;

}
