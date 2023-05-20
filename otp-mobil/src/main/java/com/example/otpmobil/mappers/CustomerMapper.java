package com.example.otpmobil.mappers;

import com.example.otpmobil.dto.CustomerDTO;
import com.example.otpmobil.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mapping( target = "webshopCustomerId", expression = "java(customerDTO.getWebshopId() + \" \" + customerDTO.getCustomerId())")
    Customer customerDtoToCustmer(CustomerDTO customerDTO);
    CustomerDTO customerToCustomerDTO(Customer customer);

}
