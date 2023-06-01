package com.example.CaNhan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "MaNV")
    @NotEmpty(message = "")
    @Size(max = 3, min = 1, message = "")
    private String MaNV;

    @Column(name = "TenNV")
    @NotEmpty(message = "TenNV must no be empty")
    @Size(max = 100, min = 1, message = "")
    private String TenNV;

    @Column(name = "Phai")
    private String Phai;

    @Column(name = "NoiSinh")
    @Size(max = 100, min = 1, message = "")
    private String NoiSinh;

    @ManyToOne
    @JoinColumn(name = "MaPhong_id", referencedColumnName = "MaPhong")
    private Office MaPhong;


    @Column(name = "Luong")
    private Integer Luong;

}
