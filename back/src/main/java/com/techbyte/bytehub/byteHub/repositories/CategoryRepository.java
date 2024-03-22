package com.techbyte.bytehub.byteHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbyte.bytehub.byteHub.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
