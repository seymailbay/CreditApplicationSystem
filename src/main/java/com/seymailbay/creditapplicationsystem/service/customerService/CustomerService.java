package com.seymailbay.creditapplicationsystem.service.customerService;

import com.seymailbay.creditapplicationsystem.dto.customer.CustomerCreateDto;
import com.seymailbay.creditapplicationsystem.dto.customer.CustomerUpdateDto;
import com.seymailbay.creditapplicationsystem.dto.customer.CustomerViewDto;
import java.util.*;
import com.seymailbay.creditapplicationsystem.model.Customer;

public interface CustomerService {

    List<CustomerViewDto> getCustomers();

    CustomerViewDto createCustomer(CustomerCreateDto customerCreateDto);

    CustomerViewDto updateCustomer(CustomerUpdateDto customerUpdateDto);

    void deleteCustomer(Long id);







}
