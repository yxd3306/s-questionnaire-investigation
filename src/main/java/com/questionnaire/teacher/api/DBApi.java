package com.questionnaire.teacher.api;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.questionnaire.teacher.api
 * @Auther: 喻湘东
 * @Email: Jyxd1997@163.com
 * @Date: 2019-02-20 09:44:52
 * @Description:
 */


@Controller
public class DBApi {


    @Autowired
    TeacherService teacherService;

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/selectQuestionnaires",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaires(HttpServletRequest request){
        return teacherService.selectQuestionnaires(request);
    }

    /**
     * 添加标题
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/addTitle",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addTitle(HttpServletRequest request){
        return teacherService.addTitle(request);
    }

    /**
     * 根据id查询问卷
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/selectQuestionnaireByKey",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireByKey(HttpServletRequest request){
        return teacherService.selectQuestionnaireByKey(request);
    }

    /**
     * 添加问卷内容
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/addContext",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addContext(HttpServletRequest request){
        return teacherService.addContext(request);
    }

    /**
     * 根据id删除问卷
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/deleteQuestionnaireById",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteQuestionnaireById(HttpServletRequest request){
        return teacherService.deleteQuestionnaireById(request);
    }

    /**
     * 根据标题id删除内容
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/deleteContextByTitleId",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteContextByTitleId(HttpServletRequest request){
        return teacherService.deleteContextByTitleId(request);
    }

    /**
     * 修改内容
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/updateContext",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateContext(HttpServletRequest request){
        return teacherService.updateContext(request);
    }

    /**
     * 发布问卷
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/releaseQuestionnaire",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject releaseQuestionnaire(HttpServletRequest request){
        return teacherService.releaseQuestionnaire(request);
    }

    /**
     * 根据问卷状态查询问卷
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/selectQuestionnaireByState",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireByState(HttpServletRequest request){
        return teacherService.selectQuestionnaireByState(request);
    }

    /**
     * 根据输入关键字查询问卷
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/selectQuestionnaireBySearch",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectQuestionnaireBySearch(HttpServletRequest request){
        return teacherService.selectQuestionnaireBySearch(request);
    }

    /**
     * 根据id收回发布的问卷
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/backQuestionnaireById",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject backQuestionnaireById(HttpServletRequest request){
        return teacherService.backQuestionnaireById(request);
    }

    /**
     * 根据id查询提交的数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/selectSubmitDataById",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectSubmitDataById(HttpServletRequest request){
        return teacherService.selectSubmitDataById(request);
    }

    /**
     * 加载提交的数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/loadSubmitData",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject loadSubmitData(HttpServletRequest request){
        return teacherService.loadSubmitData(request);
    }

    /**
     * 异步判断注册名是否已经注册
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/selectTeacherByUserName",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectTeacherByUserName(HttpServletRequest request){
        return teacherService.selectTeacherByUserName(request);
    }

    /**
     * 找回密码
     * @param request
     * @return
     */
    @RequestMapping(value = "/teacher/forgot",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject forgot(HttpServletRequest request){
        return teacherService.forgot(request);
    }





}
