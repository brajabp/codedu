package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.FollowUpDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity FollowUp and its DTO FollowUpDTO.
 */
@Mapper(componentModel = "spring", uses = {EnquiryMapper.class, EmployeeMapper.class})
public interface FollowUpMapper extends EntityMapper<FollowUpDTO, FollowUp> {

    @Mapping(source = "enquiryId.id", target = "enquiryIdId")
    @Mapping(source = "employeeId.id", target = "employeeIdId")
    FollowUpDTO toDto(FollowUp followUp);

    @Mapping(source = "enquiryIdId", target = "enquiryId")
    @Mapping(source = "employeeIdId", target = "employeeId")
    FollowUp toEntity(FollowUpDTO followUpDTO);

    default FollowUp fromId(Long id) {
        if (id == null) {
            return null;
        }
        FollowUp followUp = new FollowUp();
        followUp.setId(id);
        return followUp;
    }
}
