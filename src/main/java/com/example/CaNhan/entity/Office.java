package com.example.CaNhan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "office")
public class Office {
    @Id
    @Column(name = "MaPhong")
    @NotEmpty(message = "")
    private String MaPhong;

    @Column(name = "Ten_Phong")
    @NotEmpty(message = "")
    private String TenPhong;
}
