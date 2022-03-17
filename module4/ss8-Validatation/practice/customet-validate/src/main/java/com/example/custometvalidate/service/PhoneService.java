package com.example.custometvalidate.service;

import com.example.custometvalidate.model.Phone;
import com.example.custometvalidate.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhoneService implements IPhoneService{
    @Autowired
    private IPhoneRepository iPhoneRepository;


    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return iPhoneRepository.findAll(pageable);
    }

    @Override
    public void save(Phone phone) {
        iPhoneRepository.save(phone);
    }


}
