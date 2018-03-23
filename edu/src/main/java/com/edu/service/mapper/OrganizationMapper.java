package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.OrganizationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Organization and its DTO OrganizationDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrganizationMapper extends EntityMapper<OrganizationDTO, Organization> {


    @Mapping(target = "divisionIds", ignore = true)
    @Mapping(target = "paymentIds", ignore = true)
    @Mapping(target = "enquiryIds", ignore = true)
    @Mapping(target = "courseIds", ignore = true)
    @Mapping(target = "studentIds", ignore = true)
    @Mapping(target = "employeeIds", ignore = true)
    Organization toEntity(OrganizationDTO organizationDTO);

    default Organization fromId(Long id) {
        if (id == null) {
            return null;
        }
        Organization organization = new Organization();
        organization.setId(id);
        return organization;
    }
}
