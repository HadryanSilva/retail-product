package br.com.retail.smart.product.controller;

import br.com.retail.smart.product.mapper.request.ProductRequest;
import br.com.retail.smart.product.mapper.response.ProductResponse;
import br.com.retail.smart.product.service.ProductService;
import jakarta.validation.Valid;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService service;

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse>> findAll(@QueryParam("page") int page,
                                                         @QueryParam("size") int size) {
        return ResponseEntity.ok(service.findAll(page, size));
    }

    @GetMapping
    public ResponseEntity<ProductResponse> findById(@QueryParam("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        var response = service.createProduct(request);
        return ResponseEntity
                .created(URI.create("/api/v1/product/" + response.getId()))
                .body(response);
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(@QueryParam("id") Long id,
                                              @Valid @RequestBody ProductRequest request) {
        service.updateProduct(id, request);
        return ResponseEntity.noContent().build();
    }

}
