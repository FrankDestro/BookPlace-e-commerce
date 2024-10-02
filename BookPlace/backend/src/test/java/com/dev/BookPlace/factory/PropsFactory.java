package com.dev.BookPlace.factory;

import com.dev.BookPlace.models.entities.Props;
import com.dev.BookPlace.enums.PropType;

public class PropsFactory {

    public static Props createProps() {
        Props prop = new Props();
        prop.setId(1L);
        prop.setName("value1");
        prop.setType(PropType.PRODUCT);
        prop.setProduct(ProductFactory.createProduct());

        return prop;
    }
}
