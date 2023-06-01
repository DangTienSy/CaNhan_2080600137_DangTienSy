package com.example.CaNhan.services;

import com.example.CaNhan.entity.Staff;
import com.example.CaNhan.repository.IStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private IStaffRepository staffRepository;
    public List<Staff> getAllStaffs(){
        return staffRepository.findAll();
    }
    public Staff getStaffId(String MaNV){
        Optional<Staff> optional = staffRepository.findById(MaNV);
        return optional.orElse(null);
    }
    public void addStaff(Staff staff){
        staffRepository.save(staff);
    }
    public void updateStaff(Staff staff){
        staffRepository.save(staff);
    }
    public void deleteStaff(String staff){
        staffRepository.deleteById(staff);
    }
}
