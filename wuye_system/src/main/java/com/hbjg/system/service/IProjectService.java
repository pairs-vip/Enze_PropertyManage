package com.hbjg.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Project;
import com.hbjg.system.pojo.ProjectListDto;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import java.util.List;

public interface IProjectService extends IService<Project> {

    List<ProjectListDto> selectAll();

    Integer addUserByCode(Project project, HttpSession session);

    Project selectByUserId(Integer userId);
}
