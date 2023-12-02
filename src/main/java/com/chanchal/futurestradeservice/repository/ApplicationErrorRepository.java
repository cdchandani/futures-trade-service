package com.chanchal.futurestradeservice.repository;

import com.chanchal.futurestradeservice.bo.ApplicationErrorBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationErrorRepository extends JpaRepository<ApplicationErrorBO, Long> {
}
