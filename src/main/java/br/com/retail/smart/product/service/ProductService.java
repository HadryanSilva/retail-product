package br.com.retail.smart.product.service;

import br.com.retail.smart.product.mapper.ProductMapper;
import br.com.retail.smart.product.mapper.request.ProductRequest;
import br.com.retail.smart.product.mapper.response.ProductResponse;
import br.com.retail.smart.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductResponse> findAll(int page, int size) {
        log.info("Finding all products");
        return repository.findAll(PageRequest.of(page, size))
                .stream()
                .map(mapper::modelToResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse findById(Long id) {
        log.info("Finding product by id: {}", id);
        var product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapper.modelToResponse(product);
    }

    public ProductResponse createProduct(ProductRequest request) {
        log.info("Creating product: {}", request.getName());
        var product = mapper.requestToModel(request);
        var savedProduct = repository.save(product);
        return mapper.modelToResponse(savedProduct);
    }

    public void updateProduct(Long id, ProductRequest request) {
        var productFound = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (StringUtils.isNotBlank(request.getName())) {
            productFound.setName(request.getName());
        }
        if (StringUtils.isNotBlank(request.getBrand())) {
            productFound.setBrand(request.getBrand());
        }
        if (StringUtils.isNotBlank(request.getDescription())) {
            productFound.setDescription(request.getDescription());
        }
        if (request.getCategory() != null) {
            productFound.setCategory(request.getCategory());
        }
        if (request.getPurchasePrice() != null) {
            productFound.setPurchasePrice(request.getPurchasePrice());
        }
        if (request.getSalePrice() != null) {
            productFound.setSalePrice(request.getSalePrice());
        }
        if (request.getActive() != null) {
            productFound.setActive(request.getActive());
        }
        repository.save(productFound);
    }

}
