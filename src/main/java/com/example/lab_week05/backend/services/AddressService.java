package com.example.lab_week05.backend.services;

import com.example.lab_week05.backend.models.Address;
import com.example.lab_week05.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;


}
