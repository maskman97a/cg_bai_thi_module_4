package com.maskman97a.baiketthuc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loai_san_pham")
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_sp")
    protected Long maLoaiSp;

    @Column(name = "ten_loai_sp", length = 500)
    protected String tenLoaiSp;

}
