package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.OrderProduct;

@Repository
public interface OrderproductRepository extends JpaRepository<OrderProduct, Long> {

	List<OrderProduct> findByUserId(Long userId);


}
