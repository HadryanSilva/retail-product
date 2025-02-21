package br.com.retail.smart.product.mapper;

import br.com.retail.smart.product.mapper.request.ProductRequest;
import br.com.retail.smart.product.mapper.response.ProductResponse;
import br.com.retail.smart.product.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product requestToModel(ProductRequest request);

    ProductResponse modelToResponse(Product model);

}
