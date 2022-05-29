package com.hbjg.system.service.impl;

import com.hbjg.system.service.SendMailService;
import com.hbjg.system.utils.CodeUtils;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private CodeUtils codeUtils;

    //发送人
    private String form = "1436786590@qq.com";
    //接收人
    private String to = "";
    //标题
    private String subject = "恩泽物业资产管理系统后台验证";
    //正文
    private String context = "";

    @Override
    public void sendMail(String email,String code) {
        to = email;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(form+"(恩泽物业资产管理系统后台)");
        message.setTo(to);
        message.setSubject(subject);
        context = "欢迎使用恩泽物业资产管理系统，这封邮件包含您加入项目需要的验证码，请妥善保管。验证码：【"+code+"】";
        message.setText(context);
        javaMailSender.send(message);

    }
}
