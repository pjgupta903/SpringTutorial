package io.javabrains.springbootstarter.repository;

import io.javabrains.springbootstarter.model.Phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long>,PhoneRepositoryCustom {

}
