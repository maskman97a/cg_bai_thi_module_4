package com.maskman97a.baiketthuc.dto;

import com.maskman97a.baiketthuc.entity.DonHang;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DonHangDto extends DonHang {
    private int stt;
    private SanPhamDto sanPhamDto;
    private Float tongTien;

    public DonHangDto(Long maDonHang, String tenSp, Float giaSp, String tenLoaiSp, Date ngayMua, Integer soLuong, Long maLoaiSp, Long maSanPham) {
        super(maDonHang, ngayMua, soLuong);
        this.sanPhamDto = new SanPhamDto();
        this.sanPhamDto.setMaSp(maSanPham);
        this.sanPhamDto.setTenSp(tenSp);
        this.sanPhamDto.setGiaSp(giaSp);
        this.sanPhamDto.setLoaiSanPhamDto(new LoaiSanPhamDto());
        this.sanPhamDto.getLoaiSanPhamDto().setTenLoaiSp(tenLoaiSp);
        this.sanPhamDto.getLoaiSanPhamDto().setMaLoaiSp(maLoaiSp);
    }

    public Float getTongTien() {
        if (sanPhamDto != null) {
            return sanPhamDto.getGiaSp() * soLuong;
        }
        return 0F;
    }
}
