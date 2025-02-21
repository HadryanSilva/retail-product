package br.com.retail.smart.product.mapper.response;

import br.com.retail.smart.product.model.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private Long id;
    private String brand;
    private String name;
    private String description;
    private Category category;
    private Double purchasePrice;
    private Double salePrice;

}
