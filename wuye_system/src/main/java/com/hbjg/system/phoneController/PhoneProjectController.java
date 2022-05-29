package com.hbjg.system.phoneController;

import com.hbjg.system.pojo.Project;
import com.hbjg.system.pojo.User;
import com.hbjg.system.service.IProjectService;
import com.hbjg.system.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@CrossOrigin
@RestController
@RequestMapping("/phoneprojects")
public class PhoneProjectController {

    @Autowired
    private IProjectService iProjectService;

    //加入项目
    @PutMapping()
    public R updateproject(@RequestBody Project project, HttpSession session){
        return new R(true,20000,iProjectService.addUserByCode(project,session));
    }

    //查看当前用户是否在项目中
    @GetMapping
    public R checkProject(HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        return new R(true,20000,iProjectService.selectByUserId(userId));
    }
}
