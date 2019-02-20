package com.questionnaire.common;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.student.api.StudentApi;
import com.questionnaire.teacher.api.TeacherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.common
 * @Auther: yxd
 * @Date: 2019-02-19 12:28:34
 * @Description:
 */
@Controller
public class LoginApi {

    @Autowired
    StudentApi studentApi;
    @Autowired
    TeacherApi teacherApi;

    @RequestMapping(value = "/{path}/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject doLogin(@PathVariable String path, HttpServletRequest request){
        if("student".equals(path)){
            return studentApi.login(request);
        }
        else if("teacher".equals(path)){
            return teacherApi.login(request);
        }
        return null;
    }
    @RequestMapping(value = "/{path}/register",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject doRegister(@PathVariable String path, HttpServletRequest request){
        if("student".equals(path)){
            return studentApi.register(request);
        }
        else if("teacher".equals(path)){
            return teacherApi.register(request);
        }
        return null;
    }

    @RequestMapping("/{path}/login.html")
    public String toLoginPage(@PathVariable String path){
            return "login";
    }

    @RequestMapping("/{path}/{page}")
    public String toIndexPage(@PathVariable String path ,@PathVariable String page){
        if("login.html".equals(page)){
            return page;
        }else if("student".equals(path)&&"index.html".equals(page)){
            return "/student/index.html";
        } else if("teacher".equals(path)&&"index.html".equals(page)){
            return "/teacher/index.html";
        }else if("student".equals(path)&&"register.html".equals(page)){
            return "/register.html";
        } else if("teacher".equals(path)&&"register.html".equals(page)){
            return "/register.html";
        }
        return null;
    }

}
