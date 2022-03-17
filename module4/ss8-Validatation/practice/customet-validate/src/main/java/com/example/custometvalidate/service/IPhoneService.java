package com.example.custometvalidate.service;

import com.example.custometvalidate.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhoneService {

    Page<Phone> findAll(Pageable pageable);

    void save(Phone phone);
}
