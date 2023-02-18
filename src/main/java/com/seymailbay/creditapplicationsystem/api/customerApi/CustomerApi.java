package com.seymailbay.creditapplicationsystem.api.customerApi;


import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerCreateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerUpdateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerViewDto;
import com.seymailbay.creditapplicationsystem.service.customerService.CustomerService;
import com.seymailbay.creditapplicationsystem.shared.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerApi {

    private final CustomerService customerService;

    @GetMapping("v1/customer")
    public ResponseEntity<List<CustomerViewDto>> getCustomers(){
        final List<CustomerViewDto> customerViewDtoList =customerService.getCustomers();
        return ResponseEntity.ok(customerViewDtoList);
    }

    @PostMapping("v1/customer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerCreateDto customerCreateDto){
        customerService.createCustomer(customerCreateDto);
        return ResponseEntity.ok(new GenericResponse("Customer created."));
    }

    @PutMapping("v1/customer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id,@RequestBody CustomerUpdateDto customerUpdateDto){
        final CustomerViewDto customer = customerService.updateCustomer(id,customerUpdateDto);
        return ResponseEntity.ok(new GenericResponse("Customer updated."));
    }

    @DeleteMapping("v1/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(new GenericResponse("Customer deleted."));
    }
}
