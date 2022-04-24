package com.hbjg.system.controller;

import com.hbjg.system.pojo.Operationlog;
import com.hbjg.system.service.IOperationlogService;
import com.hbjg.system.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/operationlogs")
public class OperationlgController {

    @Autowired
    private IOperationlogService iOperationlogService;

    @PostMapping("/{currentPage}/{pageSize}")
    public R getOperationlogByPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestBody Operationlog operationlog){
        return new R(true,20000,iOperationlogService.getOperationlogMyPage(currentPage,pageSize,operationlog));
    }
}
