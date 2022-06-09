package com.techleap.conference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techleap.conference.model.PricingCategory;

@Repository
public interface PricingCategoryRepository extends JpaRepository<PricingCategory, String> {

}
