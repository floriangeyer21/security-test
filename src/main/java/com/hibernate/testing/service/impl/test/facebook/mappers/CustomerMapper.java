package com.hibernate.testing.service.impl.test.facebook.mappers;

import com.hibernate.testing.domain.test.facebook.Customer;
import com.hibernate.testing.domain.test.facebook.CustomerRequestDto;
import com.hibernate.testing.domain.test.facebook.CustomerResponseDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "authProvider", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Customer mapCustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto mapCustomerToCustomerResponseDto(Customer customer);
}
