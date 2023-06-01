package com.example.CaNhan.controller;

import com.example.CaNhan.entity.Staff;
import com.example.CaNhan.services.StaffService;
import com.example.CaNhan.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private  StaffService staffService;
    @Autowired
    private  OfficeService officeService;

    @GetMapping
    public String showAllStaffs(Model model) {
        List<Staff> staffs = staffService.getAllStaffs();
        model.addAttribute("staffs", staffs);
        return "staff/list";
    }

    @GetMapping("/add")
    public String addStaffForm(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("offices", officeService.getAllOffices());
        return "Staff/add";
    }

    @PostMapping("/add")
    public String addStaff(@ModelAttribute("staff") Staff staff) {
        staffService.addStaff(staff);
        return "redirect:/staffs";
    }
    @GetMapping("/edit/{MaNV}")
    public String editStaffForm(@PathVariable("MaNV") String MaNV, Model model) {
        Staff staff = staffService.getStaffId(MaNV);
        if (staff != null) {
            model.addAttribute("staff", staff);
            model.addAttribute("offices", officeService.getAllOffices());
            return "staff/edit";
        } else {
            return "redirect:/staffs";
        }
    }

    @PostMapping("/staff/edit/{MaNV}")
    public String editStaff(@PathVariable("MaNV") String MaNV, @ModelAttribute("staff") Staff updatedStaff) {
        Staff staff = staffService.getStaffId(MaNV);
        if (staff != null) {
            staff.setTenNV(updatedStaff.getTenNV());
            staff.setPhai(updatedStaff.getPhai());
            staff.setNoiSinh(updatedStaff.getNoiSinh());
            staff.setMaPhong(updatedStaff.getMaPhong());
            staff.setLuong(updatedStaff.getLuong());
            staffService.updateStaff(staff);
        }
        return "redirect:/staffs";
    }
    @GetMapping("/delete/{MaNV}")
    public String deleteStaff(@PathVariable("MaNV") String MaNV){
        staffService.deleteStaff(MaNV);
        return "redirect:/staffs";
    }

}

