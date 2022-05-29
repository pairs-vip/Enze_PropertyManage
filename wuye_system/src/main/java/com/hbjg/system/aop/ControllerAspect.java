package com.hbjg.system.aop;


import com.hbjg.system.controller.OfficalWebController;
import com.hbjg.system.pojo.Operationlog;
import com.hbjg.system.pojo.User;
import com.hbjg.system.service.IOperationlogService;
import com.hbjg.system.utils.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@CrossOrigin
@Component //被spring管理
@Aspect
public class ControllerAspect {

    @Autowired
    private IOperationlogService iOperationlogService;

    private Object runAndSaveLog(ProceedingJoinPoint proceedingJoinPoint) {
        //定义日期
        Date date = new Date();
        Object target = proceedingJoinPoint.getTarget();
        Signature signature = proceedingJoinPoint.getSignature();
        Operationlog operationlog = new Operationlog();
        Object result = null;

        try {
            if(target.getClass().getSimpleName().equals("OfficalWebController")) {
                result = proceedingJoinPoint.proceed();
            }
            else if (signature.getName().equals("login")) {
                result = proceedingJoinPoint.proceed();
                R r = (R) result;
                User u = (User) r.getData();
                if(u!=null){
                    operationlog.setUserUsername(u.getUsername());
                    operationlog.setUserName(u.getName());
                }

            } else if (signature.getName().equals("exit")) {
                result = proceedingJoinPoint.proceed();
            } else {
//                result = proceedingJoinPoint.proceed();
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession(true);
                User user = (User) session.getAttribute("user");
//                System.out.println("User=============="+user);
                operationlog.setUserUsername(user.getUsername());
                operationlog.setUserName(user.getName());
                result = proceedingJoinPoint.proceed();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {

        }
        if(target.getClass().getSimpleName().equals("UserController")){
            operationlog.setOperationObj("用户");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("login")){
                operationlog.setOperationType("登录");
            }
            if(signature.getName().equals("save")){
                operationlog.setOperationType("新增");
            }
            if(signature.getName().equals("update")||signature.getName().equals("updateRole")){
                operationlog.setOperationType("修改");
            }
            if(signature.getName().equals("delete")){
                operationlog.setOperationType("删除");
               }
        }
        if(target.getClass().getSimpleName().equals("PropertyController")){
            operationlog.setOperationObj("资产");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("delete")){
                operationlog.setOperationType("删除");
            }
            if(signature.getName().equals("update")){
                operationlog.setOperationType("修改");
            }
            if(signature.getName().equals("warehousing")){
                operationlog.setOperationType("入库");
            }
            if(signature.getName().equals("delivery")){
                operationlog.setOperationType("出库");
            }
        }
        if(target.getClass().getSimpleName().equals("LendlogController")){
            operationlog.setOperationObj("借出记录");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("updateStatusByLlid")){
                operationlog.setOperationType("审核");
            }
        }
        if(target.getClass().getSimpleName().equals("ReturnlogController")){
            operationlog.setOperationObj("归还记录");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("updateStatusByRlid")){
                operationlog.setOperationType("审核");
            }
        }
        if(target.getClass().getSimpleName().equals("ProjectController")){
            operationlog.setOperationObj("项目");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("save")){
                operationlog.setOperationType("新增");
            }
            if(signature.getName().equals("delete")){
                operationlog.setOperationType("删除");
            }
        }
        if(target.getClass().getSimpleName().equals("StorageitemsController")){
            operationlog.setOperationObj("资产所在地");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("save")){
                operationlog.setOperationType("新增");
            }
            if(signature.getName().equals("update")){
                operationlog.setOperationType("修改");
            }
            if(signature.getName().equals("delete")){
                operationlog.setOperationType("删除");
            }
        }
        if(target.getClass().getSimpleName().equals("Type2Controller")){
            operationlog.setOperationObj("资产类型");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("saveType2")){
                operationlog.setOperationType("新增");
            }
            if(signature.getName().equals("updateType2")){
                operationlog.setOperationType("修改");
            }
            if(signature.getName().equals("deleteType2")){
                operationlog.setOperationType("删除");
            }
        }
        if(target.getClass().getSimpleName().equals("DepartmentController")){
            operationlog.setOperationObj("公司部门");
            operationlog.setOperationTime(date);
            if(signature.getName().equals("save")){
                operationlog.setOperationType("新增");
            }
            if(signature.getName().equals("update")){
                operationlog.setOperationType("修改");
            }
            if(signature.getName().equals("delete")){
                operationlog.setOperationType("删除");
            }
        }

        if(operationlog.getOperationType()!=null&&operationlog.getOperationObj()!=null&&operationlog.getOperationTime()!=null&&operationlog.getUserUsername()!=null){
            iOperationlogService.save(operationlog);
        }
        return result;
    }

//    @Around("@within(org.springframework.stereotype.Controller)")
//    Object aroundController(ProceedingJoinPoint proceedingJoinPoint){
//        return runAndSaveLog(proceedingJoinPoint);
//    }
//    @Around("@within(org.springframework.web.bind.annotation.RestController)")
//    Object aroundRestController(ProceedingJoinPoint proceedingJoinPoint) {
//        return runAndSaveLog(proceedingJoinPoint);
//    }
//    value="execution(* com.cxsw.spring.service.impl.*.*(..))
    @Around(value="execution(* com.hbjg.system.controller.*.*(..))")
    Object aroundRestController(ProceedingJoinPoint proceedingJoinPoint) {
        return runAndSaveLog(proceedingJoinPoint);
    }
}
