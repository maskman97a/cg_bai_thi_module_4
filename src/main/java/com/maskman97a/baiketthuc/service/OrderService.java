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
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductTypeRepository productTypeService;
    private final ProductRepository productService;
    private final ObjectMapper objectMapper;

    public List<DonHangDto> filter(Date startDate, Date endDate, Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "maDonHang");
        Pageable pageable = PageRequest.of(page - 1, 5, sort);
        List<DonHangDto> donHangDtos = orderRepository.findBetweenDates(pageable, startDate, endDate);
        int i = 1;
        for (DonHangDto donHangDto : donHangDtos) {
            donHangDto.setStt(i++);
        }
        return donHangDtos;
    }

    public List<DonHangDto> viewTop(Integer top) {
        Pageable pageable = PageRequest.of(0, top != null ? top : 5);
        List<DonHangDto> donHangDtos = orderRepository.findTop(pageable);
        int i = 1;
        for (DonHangDto donHangDto : donHangDtos) {
            donHangDto.setStt(i++);
        }
        return donHangDtos;
    }

    public List<LoaiSanPhamDto> getListLoaiSanPham() {
        return productTypeService.findAll().stream().map(productType -> objectMapper.convertValue(productType, LoaiSanPhamDto.class)).toList();
    }

}
