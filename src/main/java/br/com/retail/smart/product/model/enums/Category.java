package br.com.retail.smart.product.model.enums;

import lombok.Getter;

@Getter
public enum Category {

    ELECTRONICS("Electronics", "ELEC"),
    CLOTHING("Clothing", "CLOT"),
    FOOD("Food", "FOOD"),
    BOOKS("Books", "BOOK"),
    TOYS("Toys", "TOYS"),
    SPORTS("Sports", "SPOR"),
    BEAUTY("Beauty", "BEAU"),
    HOME("Home", "HOME"),
    GAMES("Games", "GAME"),
    OTHERS("Others", "OTHE");

    private final String description;
    private final String code;

    Category(String description, String code) {
        this.description = description;
        this.code = code;
    }

}
