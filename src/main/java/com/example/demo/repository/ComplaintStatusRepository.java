package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ComplaintStatus;
public interface ComplaintStatusRepository extends JpaRepository<ComplaintStatus, Long>{

}