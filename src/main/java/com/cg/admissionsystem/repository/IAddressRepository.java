package com.cg.admissionsystem.repository;

/**
 * User Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Address;

// Spring Data JPA
@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

	Address findBycity(String city);

}
