package com.seymailbay.creditapplicationsystem.service.customerService;

import com.seymailbay.creditapplicationsystem.dto.creditDto.CreditDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerCreateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerUpdateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerViewDto;
import com.seymailbay.creditapplicationsystem.exception.NotFoundException;
import com.seymailbay.creditapplicationsystem.model.Customer;
import com.seymailbay.creditapplicationsystem.repository.CreditRepository;
import com.seymailbay.creditapplicationsystem.repository.CustomerRepository;
import com.seymailbay.creditapplicationsystem.service.creditService.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CreditService creditService;

    @Override
    @Transactional
    public List<CustomerViewDto> getCustomers() {
        return customerRepository.findAll().stream().map(CustomerViewDto::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerViewDto createCustomer(CustomerCreateDto customerCreateDto) {
        Customer customer = customerRepository.save
                (new Customer(customerCreateDto.getCustomerID(),
                        customerCreateDto.getTurkishRepublicId(),
                        customerCreateDto.getName(),
                        customerCreateDto.getSurname(),
                        customerCreateDto.getSalary(),
                        customerCreateDto.getPhone(),
                        customerCreateDto.getDateOfBirth(),
                        customerCreateDto.getAmountOfGuarantee(),
                        customerCreateDto.getCreditScore(),
                        customerCreateDto.getCredit()));
        customer.setCreditScore(creditService.calculateCreditScore());
        final Customer updatedCustomer = customerRepository.save(customer);
        return CustomerViewDto.of(updatedCustomer);
    }

    @Override
    public CustomerViewDto updateCustomer(Long id, CustomerUpdateDto customerUpdateDto) {
        final Customer customer =customerRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
        customer.setTurkishRepublicID(customerUpdateDto.getTurkishRepublicId());
        customer.setName(customerUpdateDto.getName());
        customer.setSurname(customerUpdateDto.getSurname());
        customer.setSalary(customerUpdateDto.getSalary());
        customer.setDateOfBirth(customerUpdateDto.getDateOfBirth());
        customer.setAmountOfGuarantee(customerUpdateDto.getAmountOfGuarantee());
        final Customer updatedCustomer = customerRepository.save(customer);
        return CustomerViewDto.of(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer=customerRepository.findById(id).orElseThrow(()->new NotFoundException("Not Found Exception"));
        customerRepository.deleteById(customer.getCustomerID());
    }
}
