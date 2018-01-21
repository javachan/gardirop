package com.oguzhanuzman.github.gardirop.controller.rest;

import com.oguzhanuzman.github.gardirop.Constants;
import com.oguzhanuzman.github.gardirop.controller.rest.dto.ProductCategoryCreateDto;
import com.oguzhanuzman.github.gardirop.controller.rest.dto.ProductCategoryDetailDto;
import com.oguzhanuzman.github.gardirop.controller.rest.dto.ProductCategoryUpdateDto;
import com.oguzhanuzman.github.gardirop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/product-category")
public class ProductCategoryRestController {
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryRestController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    @Secured(Constants.Security.Roles.MEMBER)
    public List<ProductCategoryDetailDto> list() {
        return this.productCategoryService.listDetails();
    }

    @PostMapping
    @Secured(Constants.Security.Roles.ADMIN)
    public ProductCategoryDetailDto create(@Valid ProductCategoryCreateDto productCategoryCreateDto) {
        return this.productCategoryService.create(productCategoryCreateDto);
    }

    @PutMapping("/{id}")
    @Secured(Constants.Security.Roles.ADMIN)
    public ProductCategoryDetailDto update(@Valid @ModelAttribute ProductCategoryUpdateDto productCategoryUpdateDto) {
        return this.productCategoryService.update(productCategoryUpdateDto);
    }
}
