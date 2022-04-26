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

    //查询所有
    @GetMapping()
    public R getAll(){
        return new R(true,20000,iUserService.list());
    }

    //根据username和password查询
    //登录
//    @GetMapping("/login/{username}/{password}")
//    public R login(@PathVariable String username, @PathVariable String password, HttpSession session){
//        User user = iUserService.getUserByUsernameAndPwd(username, password);
//        if(user!=null){
//                //添加头像
//                user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//                //登录成功，添加token
//                user.setToken(JwtUtil.createToken(username));
//                //将当前登录用户存到session中,然后返回给前端
//                session.setAttribute("user",user);
//                return new R(true,20000,user);
//            } else{
//            return new R(true,20000,"用户名或密码错误！");
//        }
//    }
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
    private R wxlogin(String code,HttpSession session) {
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
        User user = new User();
        if(openid!=null){
            user = iUserService.getByUsername(openid);
        }
        //如果此openid在数据库中存在
        if(user!=null){
            user.setToken(JwtUtil.createToken(openid));
            session.setAttribute("user",user);
            return new R(true,20000,user);
        }else {
            User user1 = new User();
            user1.setUsername(openid);
            user1.setRole(4);
            Date date = new Date();
            user1.setJoindate(date);
            user1.setToken(JwtUtil.createToken(openid));
            iUserService.save(user1);
            return new R(true,20000,iUserService.getByUsername(openid));
        }
    }


    //根据username或者id查询
//    @GetMapping("/{UsernameOrId}")
//    public R getOneByUsername(@PathVariable String UsernameOrId){
//
//        if(UsernameOrId.matches(".*[a-zA-Z].*")){
//            return new R(true,iUserService.getByUsername(UsernameOrId));
//        }else{
//            return new R(true,iUserService.getById(UsernameOrId));
//
//        }
//    }
      //分页查询
//    @GetMapping("/getPage/{currentPage}/{pageSize}")
//    public R getByPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
//        return new R(true,iUserService.getByPage(currentPage,pageSize));
//    }

    //添加操作
//    @PostMapping
//    public R save(@RequestBody User user){
//        return new R(iUserService.save(user));
//    }

    //修改职位
//    @PutMapping("/updateRole/{uid}/{rid}")
//    public R updateRole(@PathVariable Integer uid,@PathVariable Integer rid ){
//        return new R(iUserService.updateRole(uid,rid));
//    }

    //更新操作
    @PutMapping
    public R update(@RequestBody User user){
        return new R(true,20000,iUserService.updateById(user));
    }

    //注销
    @DeleteMapping
    public R delete(HttpSession session){
        User user = (User)session.getAttribute("user");
        return new R(true,20000,iUserService.removeById(user.getUid()));
    }

    //分页查询，带条件，多表查询
//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,User user){
//
//        IPage<UserListDto> page = iUserService.getUserMyPage(currentPage,pageSize,user);
//        if(currentPage > page.getPages()){
//            page = iUserService.getUserMyPage((int)page.getPages(),pageSize,user);
//        }
//        return new R(true,page);
//    }
}
