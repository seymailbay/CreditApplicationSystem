package com.seymailbay.creditapplicationsystem.service.customerService;

import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerCreateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerUpdateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerViewDto;
import jakarta.validation.Valid;

import java.util.*;

public interface CustomerService {

    List<CustomerViewDto> getCustomers();

    CustomerViewDto createCustomer(CustomerCreateDto customerCreateDto);

    CustomerViewDto updateCustomer(Long id, CustomerUpdateDto customerUpdateDto);

    void deleteCustomer(Long id);







}
