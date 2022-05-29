package com.hbjg.system.mapper;

import com.hbjg.system.pojo.Project;
import com.hbjg.system.pojo.ProjectListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper extends MyBaseMapper<Project> {

    List<ProjectListDto> findAll();

    Integer addUserByCode(Project project);

    Project selectByUserId(Integer userId);
}
