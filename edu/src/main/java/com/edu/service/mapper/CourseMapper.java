package com.edu.service.mapper;

import com.edu.domain.*;
import com.edu.service.dto.CourseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Course and its DTO CourseDTO.
 */
@Mapper(componentModel = "spring", uses = {OrganizationMapper.class})
public interface CourseMapper extends EntityMapper<CourseDTO, Course> {

    @Mapping(source = "organizationId.id", target = "organizationIdId")
    CourseDTO toDto(Course course);

    @Mapping(target = "enrollIds", ignore = true)
    @Mapping(target = "subjectIds", ignore = true)
    @Mapping(source = "organizationIdId", target = "organizationId")
    Course toEntity(CourseDTO courseDTO);

    default Course fromId(Long id) {
        if (id == null) {
            return null;
        }
        Course course = new Course();
        course.setId(id);
        return course;
    }
}
