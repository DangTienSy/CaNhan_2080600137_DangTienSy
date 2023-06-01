package com.example.CaNhan.repository;

import com.example.CaNhan.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOfficeRepository extends JpaRepository<Office, String> {
}
