package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.EnrollDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Enroll and its DTO EnrollDTO.
 */
@Mapper(componentModel = "spring", uses = {CourseMapper.class, StudentMapper.class, BatchMapper.class})
public interface EnrollMapper extends EntityMapper<EnrollDTO, Enroll> {

    @Mapping(source = "courseId.id", target = "courseIdId")
    @Mapping(source = "studentId.id", target = "studentIdId")
    @Mapping(source = "batchId.id", target = "batchIdId")
    EnrollDTO toDto(Enroll enroll);

    @Mapping(target = "paymentIds", ignore = true)
    @Mapping(source = "courseIdId", target = "courseId")
    @Mapping(source = "studentIdId", target = "studentId")
    @Mapping(source = "batchIdId", target = "batchId")
    Enroll toEntity(EnrollDTO enrollDTO);

    default Enroll fromId(Long id) {
        if (id == null) {
            return null;
        }
        Enroll enroll = new Enroll();
        enroll.setId(id);
        return enroll;
    }
}
