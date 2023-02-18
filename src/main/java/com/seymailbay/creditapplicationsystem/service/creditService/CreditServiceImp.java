package com.seymailbay.creditapplicationsystem.service.creditService;

import com.seymailbay.creditapplicationsystem.dto.creditDto.CreditDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerCreateDto;
import com.seymailbay.creditapplicationsystem.dto.customerDto.CustomerViewDto;
import com.seymailbay.creditapplicationsystem.exception.NotFoundException;
import com.seymailbay.creditapplicationsystem.model.Credit;
import com.seymailbay.creditapplicationsystem.model.Customer;
import com.seymailbay.creditapplicationsystem.repository.CreditRepository;
import com.seymailbay.creditapplicationsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CreditServiceImp implements CreditService {

    private final CreditRepository creditRepository;
    private final CustomerRepository customerRepository;

    private final int creditLimitMultiplier=4;

    @Override
    public CreditDto applyCredit(Long id,CreditDto creditDto) {
        Credit credit = creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found"));
        credit.setCreditApplyingStatus(true);
        return CreditDto.ofCreditResult(creditRepository.save(credit));
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Credit getCreditResult(Long id,CreditDto creditDto, CustomerViewDto customerViewDto) {

        Credit credit=creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));
        Customer customer= customerRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));
        if(credit.getCreditScore()<500 ){
            credit.setCreditResult(false);
            creditRepository.save(credit);
            return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

        }

        if(credit.getCreditScore()>=500 && credit.getCreditScore()<1000 ){
            if(customer.getSalary()<5000){
                credit.setCreditResult(true);
                credit.setCreditLimit((10000 + (customer.getAmountOfGuarantee())%10));
                creditRepository.save(credit);
                return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

            }
            else if(customer.getSalary()>5000 && customer.getSalary()<10000){
                credit.setCreditResult(true);
                credit.setCreditLimit(20000+(customer.getAmountOfGuarantee()%20));
                creditRepository.save(credit);
                return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

            } else {

                credit.setCreditResult(true);
                credit.setCreditLimit(customer.getSalary()*creditLimitMultiplier/2 + (customer.getAmountOfGuarantee()%25));
                creditRepository.save(credit);
                return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

            }
        }
        if(credit.getCreditScore()>=1000){
            credit.setCreditResult(true);
            credit.setCreditLimit(customer.getSalary()*creditLimitMultiplier +(customer.getAmountOfGuarantee()%50));
            creditRepository.save(credit);
            return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));


        }
        return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

    }




   /* public Credit applyCredit(Long id,CreditDto creditDto, CustomerViewDto customerViewDto) {
        Credit credit=creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));
        Customer customer= customerRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));
        if(credit.getCreditScore()<500 ){
            credit.setCreditResult(false);
            creditRepository.save(credit);
            return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));
        }

        if(credit.getCreditScore()>=500 && credit.getCreditScore()<1000 ){
            if(customer.getSalary()<5000){
                credit.setCreditResult(true);
                credit.setCreditLimit((10000 + (customer.getAmountOfGuarantee())%10));
                creditRepository.save(credit);
                return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

            }
            else if(customer.getSalary()>5000 && customer.getSalary()<10000){
                credit.setCreditResult(true);
                credit.setCreditLimit(20000+(customer.getAmountOfGuarantee()%20));
                creditRepository.save(credit);
                return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

            } else {

                credit.setCreditResult(true);
                credit.setCreditLimit(customer.getSalary()*creditLimitMultiplier/2 + (customer.getAmountOfGuarantee()%25));
                creditRepository.save(credit);
                return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

            }
        }
        if(credit.getCreditScore()>=1000){
            credit.setCreditResult(true);
            credit.setCreditLimit(customer.getSalary()*creditLimitMultiplier +(customer.getAmountOfGuarantee()%50));
            creditRepository.save(credit);
            return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));


        }
        return creditRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found"));

    }

    public Credit getCreditResult(Long id,CustomerViewDto customerViewDto){


    }*/



    public int calculateCreditScore() {
        Random random =new Random();
        int creditScore =random.nextInt(0,1500);
        creditRepository.save(new Credit(creditScore));
        return creditScore;
    }

}
