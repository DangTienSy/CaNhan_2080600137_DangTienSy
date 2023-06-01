package com.example.CaNhan.repository;

import com.example.CaNhan.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepository extends JpaRepository<Staff, String> {
}
