package com.maskman97a.baiketthuc.controller;

import com.maskman97a.baiketthuc.dto.LoaiSanPhamDto;
import com.maskman97a.baiketthuc.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("product-type")
@RequiredArgsConstructor
@RestController
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @GetMapping("/find-all")
    public List<LoaiSanPhamDto> findAll() {
        return productTypeService.getListLoaiSanPham();
    }
}
