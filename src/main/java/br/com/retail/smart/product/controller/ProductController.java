package br.com.retail.smart.product.controller;

import br.com.retail.smart.product.mapper.request.ProductRequest;
import br.com.retail.smart.product.mapper.response.ProductResponse;
import br.com.retail.smart.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        var response = service.createProduct(request);
        return ResponseEntity
                .created(URI.create("/api/v1/product/" + response.getId()))
                .body(response);
    }

}
