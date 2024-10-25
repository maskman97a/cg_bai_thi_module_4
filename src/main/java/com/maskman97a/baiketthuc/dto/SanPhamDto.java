package com.maskman97a.baiketthuc.dto;

import com.maskman97a.baiketthuc.entity.SanPham;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SanPhamDto extends SanPham {
    private LoaiSanPhamDto loaiSanPhamDto;
}
