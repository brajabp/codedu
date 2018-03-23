package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.PaymentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Payment and its DTO PaymentDTO.
 */
@Mapper(componentModel = "spring", uses = {OrganizationMapper.class, EnrollMapper.class})
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {

    @Mapping(source = "organizationId.id", target = "organizationIdId")
    @Mapping(source = "enrollId.id", target = "enrollIdId")
    PaymentDTO toDto(Payment payment);

    @Mapping(source = "organizationIdId", target = "organizationId")
    @Mapping(source = "enrollIdId", target = "enrollId")
    Payment toEntity(PaymentDTO paymentDTO);

    default Payment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Payment payment = new Payment();
        payment.setId(id);
        return payment;
    }
}
