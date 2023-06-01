package com.example.CaNhan.services;

import com.example.CaNhan.entity.Office;
import com.example.CaNhan.repository.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {
    private final IOfficeRepository officeRepository;

    @Autowired
    public OfficeService(IOfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getOfficeById(String maPhong) {
        return officeRepository.findById(maPhong)
                .orElseThrow(() -> new RuntimeException("Office not found"));
    }

    public Office saveOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(String maPhong) {
        officeRepository.deleteById(maPhong);
    }
}

