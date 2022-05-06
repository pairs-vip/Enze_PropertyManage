package com.hbjg.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Project;
import com.hbjg.system.pojo.ProjectListDto;

import java.util.List;

public interface IProjectService extends IService<Project> {

    List<ProjectListDto> selectAll();
}
