package com.integrator.test.document.dao;

import com.integrator.test.document.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDao extends JpaRepository<Document , String> {

    Document findByDocName(String docName);
}
