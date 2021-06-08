package com.cg.admissionsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.admissionsystem.module.LoginEntity;

@Repository
public interface ILoginRepository extends JpaRepository<LoginEntity, String> {

}
