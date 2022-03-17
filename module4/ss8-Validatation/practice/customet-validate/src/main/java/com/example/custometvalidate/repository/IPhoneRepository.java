package com.example.custometvalidate.repository;

import com.example.custometvalidate.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPhoneRepository extends JpaRepository<Phone,Integer> {

}
