package com.seymailbay.creditapplicationsystem.repository;

import com.seymailbay.creditapplicationsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
