package com.seymailbay.creditapplicationsystem.dto.customerDto;

import com.seymailbay.creditapplicationsystem.model.Credit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CustomerCreateDto {

    @NotNull(message = "")
    private Long customerID;

    @NotNull(message = "{backend.constraints.turkish_republicId.notNull.message}")
    //@Size(min = 11,max=11,message = "{backend.constraints.turkish_republicId.Size.message}")
    private String turkishRepublicId;

    @NotNull(message = "{backend.constraints.first_name.notNull.message}")
    private String name;

    @NotNull(message = "{backend.constraints.last_name.notNull.message}")
    private String surname;

    @NotNull(message = "{backend.constraints.salary.notNull.message}")
    private double salary;

    @NotNull(message = "{backend.constraints.phone.notNull.message}")
    private String phone;

    private String dateOfBirth;

    private double amountOfGuarantee;

    private int creditScore;

    private Credit credit;

}
