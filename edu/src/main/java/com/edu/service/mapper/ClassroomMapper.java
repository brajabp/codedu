package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.ClassroomDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Classroom and its DTO ClassroomDTO.
 */
@Mapper(componentModel = "spring", uses = {ScheduleMapper.class})
public interface ClassroomMapper extends EntityMapper<ClassroomDTO, Classroom> {

    @Mapping(source = "scheduleId.id", target = "scheduleIdId")
    ClassroomDTO toDto(Classroom classroom);

    @Mapping(target = "classLogIds", ignore = true)
    @Mapping(source = "scheduleIdId", target = "scheduleId")
    Classroom toEntity(ClassroomDTO classroomDTO);

    default Classroom fromId(Long id) {
        if (id == null) {
            return null;
        }
        Classroom classroom = new Classroom();
        classroom.setId(id);
        return classroom;
    }
}
