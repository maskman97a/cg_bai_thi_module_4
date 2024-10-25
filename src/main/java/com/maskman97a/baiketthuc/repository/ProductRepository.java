
package com.maskman97a.baiketthuc.repository;

import com.maskman97a.baiketthuc.entity.LoaiSanPham;
import com.maskman97a.baiketthuc.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<SanPham, Long> {

}
