package com.maskman97a.baiketthuc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maskman97a.baiketthuc.dto.DonHangDto;
import com.maskman97a.baiketthuc.dto.LoaiSanPhamDto;
import com.maskman97a.baiketthuc.repository.OrderRepository;
import com.maskman97a.baiketthuc.repository.ProductRepository;
import com.maskman97a.baiketthuc.repository.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTypeService {
    private final ProductTypeRepository productTypeService;
    private final ObjectMapper objectMapper;

    public List<LoaiSanPhamDto> getListLoaiSanPham() {
        return productTypeService.findAll().stream().map(productType -> objectMapper.convertValue(productType, LoaiSanPhamDto.class)).toList();
    }

}
