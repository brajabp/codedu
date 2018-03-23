package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.EnquiryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Enquiry and its DTO EnquiryDTO.
 */
@Mapper(componentModel = "spring", uses = {OrganizationMapper.class})
public interface EnquiryMapper extends EntityMapper<EnquiryDTO, Enquiry> {

    @Mapping(source = "organizationId.id", target = "organizationIdId")
    EnquiryDTO toDto(Enquiry enquiry);

    @Mapping(target = "followUpIds", ignore = true)
    @Mapping(source = "organizationIdId", target = "organizationId")
    Enquiry toEntity(EnquiryDTO enquiryDTO);

    default Enquiry fromId(Long id) {
        if (id == null) {
            return null;
        }
        Enquiry enquiry = new Enquiry();
        enquiry.setId(id);
        return enquiry;
    }
}
