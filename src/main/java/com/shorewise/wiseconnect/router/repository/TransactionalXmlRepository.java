package com.shorewise.wiseconnect.router.repository;

import com.shorewise.wiseconnect.router.entity.TransactionalXml;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionalXmlRepository extends JpaRepository<TransactionalXml, String> {
    List<TransactionalXml> findByStatus(String status);
}
