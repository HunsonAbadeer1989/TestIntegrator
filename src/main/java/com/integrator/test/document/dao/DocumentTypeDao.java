package com.integrator.test.document.dao;

import com.integrator.test.document.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeDao extends JpaRepository<DocumentType, Long> {

    DocumentType findByCode(Integer docCode);
}
