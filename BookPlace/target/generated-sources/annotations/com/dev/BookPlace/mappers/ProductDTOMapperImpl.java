package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.CategoryDTO;
import com.dev.BookPlace.models.dto.ProductDTO;
import com.dev.BookPlace.models.dto.ProductImageDTO;
import com.dev.BookPlace.models.dto.PropsDTO;
import com.dev.BookPlace.models.entities.Category;
import com.dev.BookPlace.models.entities.Product;
import com.dev.BookPlace.models.entities.ProductImage;
import com.dev.BookPlace.models.entities.Props;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T17:46:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Red Hat, Inc.)"
)
@Component
public class ProductDTOMapperImpl implements ProductDTOMapper {

    @Autowired
    private CategoryDTOMapper categoryDTOMapper;
    @Autowired
    private ProductImagesDTOMapper productImagesDTOMapper;
    @Autowired
    private PropsDTOMapper propsDTOMapper;

    @Override
    public ProductDTO toProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setCashPrice( product.getCashPrice() );
        productDTO.setInstallmentPrice( product.getInstallmentPrice() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setDetails( product.getDetails() );
        productDTO.setCreatedAt( product.getCreatedAt() );
        productDTO.setUpdatedAt( product.getUpdatedAt() );
        productDTO.setCategories( categorySetToCategoryDTOList( product.getCategories() ) );
        productDTO.setProductImages( productImageListToProductImageDTOList( product.getProductImages() ) );
        productDTO.setProps( propsListToPropsDTOList( product.getProps() ) );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setPrice( productDTO.getPrice() );
        product.setCashPrice( productDTO.getCashPrice() );
        product.setInstallmentPrice( productDTO.getInstallmentPrice() );
        product.setDescription( productDTO.getDescription() );
        product.setDetails( productDTO.getDetails() );
        product.setProps( propsDTOListToPropsList( productDTO.getProps() ) );
        product.setCreatedAt( productDTO.getCreatedAt() );
        product.setUpdatedAt( productDTO.getUpdatedAt() );
        product.setCategories( categoryDTOListToCategorySet( productDTO.getCategories() ) );
        product.setProductImages( productImageDTOListToProductImageList( productDTO.getProductImages() ) );

        return product;
    }

    @Override
    public void updateProductFromDTO(ProductDTO productDTO, Product product) {
        if ( productDTO == null ) {
            return;
        }

        product.setName( productDTO.getName() );
        product.setPrice( productDTO.getPrice() );
        product.setCashPrice( productDTO.getCashPrice() );
        product.setInstallmentPrice( productDTO.getInstallmentPrice() );
        product.setDescription( productDTO.getDescription() );
        product.setDetails( productDTO.getDetails() );
        if ( product.getProps() != null ) {
            List<Props> list = propsDTOListToPropsList( productDTO.getProps() );
            if ( list != null ) {
                product.getProps().clear();
                product.getProps().addAll( list );
            }
            else {
                product.setProps( null );
            }
        }
        else {
            List<Props> list = propsDTOListToPropsList( productDTO.getProps() );
            if ( list != null ) {
                product.setProps( list );
            }
        }
        product.setCreatedAt( productDTO.getCreatedAt() );
        product.setUpdatedAt( productDTO.getUpdatedAt() );
        if ( product.getCategories() != null ) {
            Set<Category> set = categoryDTOListToCategorySet( productDTO.getCategories() );
            if ( set != null ) {
                product.getCategories().clear();
                product.getCategories().addAll( set );
            }
            else {
                product.setCategories( null );
            }
        }
        else {
            Set<Category> set = categoryDTOListToCategorySet( productDTO.getCategories() );
            if ( set != null ) {
                product.setCategories( set );
            }
        }
        if ( product.getProductImages() != null ) {
            List<ProductImage> list1 = productImageDTOListToProductImageList( productDTO.getProductImages() );
            if ( list1 != null ) {
                product.getProductImages().clear();
                product.getProductImages().addAll( list1 );
            }
            else {
                product.setProductImages( null );
            }
        }
        else {
            List<ProductImage> list1 = productImageDTOListToProductImageList( productDTO.getProductImages() );
            if ( list1 != null ) {
                product.setProductImages( list1 );
            }
        }
    }

    protected List<CategoryDTO> categorySetToCategoryDTOList(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( set.size() );
        for ( Category category : set ) {
            list.add( categoryDTOMapper.toCategoryDTO( category ) );
        }

        return list;
    }

    protected List<ProductImageDTO> productImageListToProductImageDTOList(List<ProductImage> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductImageDTO> list1 = new ArrayList<ProductImageDTO>( list.size() );
        for ( ProductImage productImage : list ) {
            list1.add( productImagesDTOMapper.toProductImagesDTO( productImage ) );
        }

        return list1;
    }

    protected List<PropsDTO> propsListToPropsDTOList(List<Props> list) {
        if ( list == null ) {
            return null;
        }

        List<PropsDTO> list1 = new ArrayList<PropsDTO>( list.size() );
        for ( Props props : list ) {
            list1.add( propsDTOMapper.toPropsDTO( props ) );
        }

        return list1;
    }

    protected List<Props> propsDTOListToPropsList(List<PropsDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Props> list1 = new ArrayList<Props>( list.size() );
        for ( PropsDTO propsDTO : list ) {
            list1.add( propsDTOMapper.toPropsEntity( propsDTO ) );
        }

        return list1;
    }

    protected Set<Category> categoryDTOListToCategorySet(List<CategoryDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Category> set = new LinkedHashSet<Category>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( CategoryDTO categoryDTO : list ) {
            set.add( categoryDTOMapper.toCategoryEntity( categoryDTO ) );
        }

        return set;
    }

    protected List<ProductImage> productImageDTOListToProductImageList(List<ProductImageDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductImage> list1 = new ArrayList<ProductImage>( list.size() );
        for ( ProductImageDTO productImageDTO : list ) {
            list1.add( productImagesDTOMapper.toEntity( productImageDTO ) );
        }

        return list1;
    }
}
