package com.maskman97a.baiketthuc.repository;

import com.maskman97a.baiketthuc.dto.DonHangDto;
import com.maskman97a.baiketthuc.entity.DonHang;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<DonHang, Long> {

    @Query(value = """
                SELECT new com.maskman97a.baiketthuc.dto.DonHangDto(dh.maDonHang, sp.tenSp, sp.giaSp, lsp.tenLoaiSp, dh.ngayMua, dh.soLuong, lsp.maLoaiSp, sp.maSp) 
                FROM DonHang dh 
                LEFT JOIN SanPham sp ON dh.maSp = sp.maSp
                LEFT JOIN LoaiSanPham lsp ON sp.maLoaiSp = lsp.maLoaiSp
                WHERE 1=1 
                AND (:startDate IS NULL OR dh.ngayMua >= :startDate) AND (:endDate IS NULL OR DATE(dh.ngayMua) <= :endDate)
            """)
    List<DonHangDto> findBetweenDates(Pageable pageable, Date startDate, Date endDate);

    @Query(value = """
                SELECT new com.maskman97a.baiketthuc.dto.DonHangDto(dh.maDonHang, sp.tenSp, sp.giaSp, lsp.tenLoaiSp, dh.ngayMua, dh.soLuong, lsp.maLoaiSp, sp.maSp) 
                FROM DonHang dh 
                LEFT JOIN SanPham sp ON dh.maSp = sp.maSp
                LEFT JOIN LoaiSanPham lsp ON sp.maLoaiSp = lsp.maLoaiSp
                ORDER BY dh.soLuong*sp.giaSp DESC
            """)
    List<DonHangDto> findTop(Pageable pageable);
}
