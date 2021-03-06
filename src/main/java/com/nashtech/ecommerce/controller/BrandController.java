package com.nashtech.ecommerce.controller;

import com.nashtech.ecommerce.domain.Brand;
import com.nashtech.ecommerce.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brand-management")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/{id}")
    public Brand getBrandById(@PathVariable("id") int id) {
        return brandService.findBrandById(id);
    }

    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Brand addBrand(@RequestParam String name) {
        return brandService.addBrand(name);
    }

    @PutMapping("/brands/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Brand updateBrandName(@PathVariable("id") int id, @RequestParam String newName) {
        return brandService.updateBrandName(id, newName);
    }

    @DeleteMapping("/brands/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Brand toggleBrandStatus(@PathVariable("id") int id) {
        return brandService.updateBrandStatus(id);
    }
}
