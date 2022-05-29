package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.ProjectMapper;
import com.hbjg.system.pojo.Project;
import com.hbjg.system.pojo.ProjectListDto;
import com.hbjg.system.pojo.User;
import com.hbjg.system.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectListDto> selectAll() {
        return projectMapper.findAll();
    }

    @Override
    public Integer addUserByCode(Project project, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        project.setUserId(id);
        System.out.println(project);
        return projectMapper.addUserByCode(project);
    }

    @Override
    public Project selectByUserId(Integer userId) {
        return projectMapper.selectByUserId(userId);
    }

}
