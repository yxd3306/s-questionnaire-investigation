package com.questionnaire.common;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.student.api.StudentApi;
import com.questionnaire.teacher.api.TeacherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.common
 * @Auther: yxd
 * @Date: 2019-02-19 12:28:34
 * @Description:
 */
@Controller
public class CommonApi {

    @Autowired
    StudentApi studentApi;
    @Autowired
    TeacherApi teacherApi;

    /**
     * 使用restful风格api 跟据path的不同执行老师和学生的登录操作
     * @param path
     * @param request
     * @return
     */
    @RequestMapping(value = "/{path}/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject doLogin(@PathVariable String path, HttpServletRequest request){
        if("student".equals(path))
            // 学生登录
            return studentApi.login(request);
        else if("teacher".equals(path))
            // 老师登录
            return teacherApi.login(request);
        else
            return null;
    }

    /**
     * 使用restful风格api 跟据path的不同执行老师和学生的注册操作
     * @param path
     * @param request
     * @return
     */
    @RequestMapping(value = "/{path}/register",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject doRegister(@PathVariable String path, HttpServletRequest request){
        if("student".equals(path))
            // 学生注册
            return studentApi.register(request);
        else if("teacher".equals(path))
            // 老师注册
            return teacherApi.register(request);
        else
            return null;
    }

    /**
     * 使用restful风格api 跟据path的不同返回老师或者学生的登录页面
     * @param path
     * @return
     */
    @RequestMapping("/{path}/login.html")
    public String toLoginPage(@PathVariable String path){
            return "login";
    }

    /**
     * 使用restful风格api 跟据path的不同返回页面
     * @param path
     * @param page
     * @return index.html--首页   register.html--注册页面   forgot.html--找回密码页面
     */
    @RequestMapping("/{path}/{page}")
    public String toIndexPage(@PathVariable String path ,@PathVariable String page){
        if("login.html".equals(page))
            return page;
        else if("student".equals(path)&&"index.html".equals(page))
            return "/student/index.html";
        else if("teacher".equals(path)&&"index.html".equals(page))
            return "/teacher/index.html";
        else if("student".equals(path)&&"register.html".equals(page))
            return "/register.html";
        else if("teacher".equals(path)&&"register.html".equals(page))
            return "/register.html";
        else if("student".equals(path)&&"forgot.html".equals(page))
            return "/forgot.html";
        else if("teacher".equals(path)&&"forgot.html".equals(page))
            return "/forgot.html";
        else
            return null;
    }

    /**
     * 使用restful风格api 跟据queryQuestionnaireById的不同返回添加问卷页面和修改问卷页面
     * @param queryQuestionnaireById
     * @param questionnaireId
     * @return addInfo.html--添加问卷页面   updateInfo.html--修改问卷页面
     */
    @RequestMapping("/teacher/{queryQuestionnaireById}/{questionnaireId}")
    public String toLoginPage(@PathVariable String queryQuestionnaireById,@PathVariable Integer questionnaireId){
        if(null!= questionnaireId && 0<=questionnaireId){
            if("queryQuestionnaireById".equals(queryQuestionnaireById))
                return "/teacher/addInfo.html";
            else if("updateQuestionnaireById".equals(queryQuestionnaireById))
                return "/teacher/updateInfo.html";
        }
        return null;
    }

    /**
     * 返回提交页面
     * @param queryQuestionnaireById
     * @param questionnaireId
     * @return
     */
    @RequestMapping("/student/{queryQuestionnaireById}/{questionnaireId}")
    public String toInfoPage(@PathVariable String queryQuestionnaireById,@PathVariable Integer questionnaireId){
        return "/student/info.html";
    }

    /**
     * 返回老师查看学生提交详情页面
     * @param id
     * @return
     */
    @RequestMapping("/teacher/loadSubmitStudent/{id}")
    public String loadSubmitStudent(@PathVariable Integer id){
        return "/teacher/loadSubmitStudent.html";
    }

    /**
     * 返回学生提交详情页面
     * @param studentId
     * @param questionnaireId
     * @return
     */
    @RequestMapping("/teacher/loadSubmitInfo/{studentId}/{questionnaireId}")
    public String loadSubmitInfo(@PathVariable Integer studentId,@PathVariable Integer questionnaireId){
        return "/teacher/loadSubmitInfo.html";
    }



}
