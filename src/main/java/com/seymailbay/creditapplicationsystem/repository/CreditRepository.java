package com.seymailbay.creditapplicationsystem.repository;

import com.seymailbay.creditapplicationsystem.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

}
