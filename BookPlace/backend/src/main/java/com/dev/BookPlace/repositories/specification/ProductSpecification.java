package com.dev.BookPlace.repositories.specification;

import com.dev.BookPlace.models.entities.Category;
import com.dev.BookPlace.models.entities.Product;
import com.dev.BookPlace.models.entities.Props;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class ProductSpecification {

    public static Specification<Product> hasCategory(Long categoryId) {
        return (root, query, criteriaBuilder) -> {
            Join<Product, Category> categoryJoin = root.join("categories", JoinType.INNER);
            return criteriaBuilder.equal(categoryJoin.get("id"), categoryId);

        };
    }

    public static Specification<Product> hasFilters(Map<String, String> filters) {
        return (root, query, criteriaBuilder) -> {
            Predicate filtersPredicate = criteriaBuilder.conjunction();
            if (filters != null && !filters.isEmpty()) {
                for (Map.Entry<String, String> entry : filters.entrySet()) {
                    Join<Product, Props> propsJoin = root.join("props", JoinType.INNER);
                    filtersPredicate = criteriaBuilder.and(filtersPredicate,
                            criteriaBuilder.equal(propsJoin.get("name"), entry.getKey()),
                            criteriaBuilder.equal(propsJoin.get("propValue"), entry.getValue()));
                }
            }
            return filtersPredicate;
        };
    }

    public static Specification<Product> withCategoryAndFilters(Long categoryId, Map<String, String> filters) {
        Specification<Product> spec = hasCategory(categoryId);
        if (filters != null && !filters.isEmpty()) {
            spec = spec.and(hasFilters(filters));
        }
        return spec;
    }
}
