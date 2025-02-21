package br.com.retail.smart.product.service;

import br.com.retail.smart.product.mapper.ProductMapper;
import br.com.retail.smart.product.mapper.request.ProductRequest;
import br.com.retail.smart.product.mapper.response.ProductResponse;
import br.com.retail.smart.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        log.info("Creating product: {}", request.getName());
        var product = mapper.requestToModel(request);
        var savedProduct = repository.save(product);
        return mapper.modelToResponse(savedProduct);
    }

}
