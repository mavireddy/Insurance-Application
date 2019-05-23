package com.ektha.insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ektha.insurance.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {



}
