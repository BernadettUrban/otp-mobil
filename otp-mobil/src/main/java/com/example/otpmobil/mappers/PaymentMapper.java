package com.example.otpmobil.mappers;

import com.example.otpmobil.dto.PaymentDTO;
import com.example.otpmobil.models.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(target = "webshopCustomerId", expression = "java(paymentDTO.getWebshopId() + \" \" + paymentDTO.getCustomerId())")
    Payment paymentDtoToPayment(PaymentDTO paymentDTO);

    PaymentDTO paymentToPaymentDTO(Payment payment);

}
