package com.hbjg.system.phoneController;


import com.hbjg.system.utils.JwtUtil;
import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.User;
import com.hbjg.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowWebServer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.Date;

@RestController
@RequestMapping("/wechat")
public class PhoneUserController {

    private String openid;
    private String session_key;
    //开发者平台申请
    private String appId="wxb6b68e7512b352a0";
    private String secret="89f23a598430eb1aa6424b706fb1dc59";


    @Autowired
    private IUserService iUserService;

    //查询所有人
    @GetMapping
    public R getAll(){
        return new R(true,20000,iUserService.list());
    }

    //根据职位查询
    @GetMapping("/getByRole/{rid}")
    public R getByRole(@PathVariable Integer rid){
        return new R(true,20000,iUserService.selectByRole(rid));
    }

    //根据username和password查询
    //登录
    @GetMapping("/login/{username}/{password}")
    public R login(@PathVariable String username, @PathVariable String password, HttpSession session){
        User user = iUserService.getUserByUsernameAndPwd(username, password);
        if(user!=null){
                //添加头像
                user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
                //登录成功，添加token
                user.setToken(JwtUtil.createToken(username));
                //将当前登录用户存到session中,然后返回给前端
                session.setAttribute("user",user);
                return new R(true,20000,user);
            } else{
            return new R(true,20000,"用户名或密码错误！");
        }
    }
    //验证token
    @GetMapping("/checkToken")
    public R checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return new R(true,20000,JwtUtil.checkToken(token));
    }
    //退出操作
    @GetMapping("/exit")
    public R exit(HttpSession session){
        session.removeAttribute("user");
        return new R(true,2000,"退出成功");
    }
    /**     * 微信小程序登录     *
     * 登录成功后，将用户身份信息存入token
     * * @param model
     * * @return     */
    @GetMapping("/wxLogin")
    public R wxlogin(String code,HttpSession session) {
        System.out.println(code);
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";

        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(resultString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 解析json
        com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSONObject.parse(resultString);
        session_key = jsonObject.get("session_key")+"";
        openid = jsonObject.get("openid")+"";
        System.out.println("openid:"+openid);
        if(openid!=null){
            User user = iUserService.getByUsername(openid);
//            session.setAttribute("user",user);
            //如果此openid在数据库中存在
            if(user!=null){
                user.setToken(JwtUtil.createToken(openid));
                session.setAttribute("user",user);
                User user11 = (User)session.getAttribute("user");
                String id = session.getId();
                System.out.println("sessionId:"+id);
                System.out.println("session:"+user11);
                R r = new R(true,20000,user,id);
                System.out.println("r:"+r);
                return new R(true,20000,user,id);
            }else {
                User user1 = new User();
                user1.setUsername(openid);
                user1.setRoleId(4);
                Date date = new Date();
                user1.setJoindate(date);
                iUserService.save(user1);
                User user2 = iUserService.getByUsername(openid);
                user2.setToken(JwtUtil.createToken(user2.getUsername()));
                session.setAttribute("user",user2);
                User user3 = (User)session.getAttribute("user");
                String id = session.getId();
                System.out.println("session:"+user3);
                return new R(true,20000,user2,id);
            }
        }
        return new R(true,20000,"openid解析失败");
    }


    //更新操作
    @PutMapping
    public R update(@RequestBody User user){
        return new R(true,20000,iUserService.updateById(user));
    }

    //注销
    @DeleteMapping
    public R delete(HttpSession session){
        User user = (User)session.getAttribute("user");
        return new R(true,20000,iUserService.removeById(user.getId()));
    }

}
