package com.maskman97a.baiketthuc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "don_hang")
@NoArgsConstructor
@AllArgsConstructor
public class DonHang {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    protected Long maDonHang;

    @Column(name = "ngay_mua")
    protected java.util.Date ngayMua;

    @Column(name = "so_luong")
    protected Integer soLuong;

    @Column(name = "ma_sp")
    protected Long maSp;

    public DonHang(Long maDonHang, java.util.Date ngayMua, Integer soLuong) {
        this.maDonHang = maDonHang;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
    }

}
