package com.maskman97a.baiketthuc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "san_pham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sp")
    protected Long maSp;

    @Column(name = "ten_sp", length = 500)
    protected String tenSp;

    @Column(name = "gia_sp")
    protected Float giaSp;

    @Column(name = "tinh_trang_sp", length = 100)
    protected String tinhTrangSp;

    @Column(name = "ma_loai_sp", length = 100)
    protected Long maLoaiSp;
}
