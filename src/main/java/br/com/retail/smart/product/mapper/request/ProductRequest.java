package br.com.retail.smart.product.mapper.request;

import br.com.retail.smart.product.model.enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {

    private String brand;
    private String name;
    private String description;
    private Category category;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;

}
