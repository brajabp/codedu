package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.ClassLogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ClassLog and its DTO ClassLogDTO.
 */
@Mapper(componentModel = "spring", uses = {ClassroomMapper.class})
public interface ClassLogMapper extends EntityMapper<ClassLogDTO, ClassLog> {

    @Mapping(source = "classroomId.id", target = "classroomIdId")
    ClassLogDTO toDto(ClassLog classLog);

    @Mapping(source = "classroomIdId", target = "classroomId")
    ClassLog toEntity(ClassLogDTO classLogDTO);

    default ClassLog fromId(Long id) {
        if (id == null) {
            return null;
        }
        ClassLog classLog = new ClassLog();
        classLog.setId(id);
        return classLog;
    }
}
