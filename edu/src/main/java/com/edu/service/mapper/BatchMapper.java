package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.BatchDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Batch and its DTO BatchDTO.
 */
@Mapper(componentModel = "spring", uses = {SubjectMapper.class, StudentMapper.class, EmployeeMapper.class})
public interface BatchMapper extends EntityMapper<BatchDTO, Batch> {

    @Mapping(source = "subjectId.id", target = "subjectIdId")
    @Mapping(source = "studentId.id", target = "studentIdId")
    @Mapping(source = "employeeId.id", target = "employeeIdId")
    BatchDTO toDto(Batch batch);

    @Mapping(target = "scheduleIds", ignore = true)
    @Mapping(target = "enrollIds", ignore = true)
    @Mapping(source = "subjectIdId", target = "subjectId")
    @Mapping(source = "studentIdId", target = "studentId")
    @Mapping(source = "employeeIdId", target = "employeeId")
    Batch toEntity(BatchDTO batchDTO);

    default Batch fromId(Long id) {
        if (id == null) {
            return null;
        }
        Batch batch = new Batch();
        batch.setId(id);
        return batch;
    }
}
