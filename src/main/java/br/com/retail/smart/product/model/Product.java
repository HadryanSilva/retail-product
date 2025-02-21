package br.com.retail.smart.product.model;

import br.com.retail.smart.product.model.enums.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Brand;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Positive
    @Column(nullable = false)
    private BigDecimal purchasePrice;

    @Positive
    @Column(nullable = false)
    private BigDecimal salePrice;

    @Column(nullable = false)
    private Boolean active;

    @CreatedDate
    private Instant createdAt;

}
