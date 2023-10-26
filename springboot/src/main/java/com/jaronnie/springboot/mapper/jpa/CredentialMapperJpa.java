package com.jaronnie.springboot.mapper.jpa;

import com.jaronnie.springboot.domain.po.Credential;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CredentialMapperJpa extends JpaRepository<Credential, Long> {
    @Query("SELECT c FROM Credential c")
    List<Credential> list(Pageable pageable);
}

