package com.example.restapiprojectsem4.Service;

import com.example.restapiprojectsem4.Entity.Province;
import com.example.restapiprojectsem4.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> getAllProvince(){
        return provinceRepository.findAll();
    }
}
