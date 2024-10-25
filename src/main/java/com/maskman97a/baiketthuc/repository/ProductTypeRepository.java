package com.maskman97a.baiketthuc.repository;

import com.maskman97a.baiketthuc.dto.DonHangDto;
import com.maskman97a.baiketthuc.entity.DonHang;
import com.maskman97a.baiketthuc.entity.LoaiSanPham;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductTypeRepository extends JpaRepository<LoaiSanPham, Long> {

}
