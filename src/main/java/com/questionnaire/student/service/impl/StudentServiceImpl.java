package com.questionnaire.student.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.questionnaire.common.page.PageBean;
import com.questionnaire.common.util.BaseUtil;
import com.questionnaire.common.util.DateUtil;
import com.questionnaire.dao.*;
import com.questionnaire.entity.*;
import com.questionnaire.student.dao.StudentMapper;
import com.questionnaire.student.entity.Student;
import com.questionnaire.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * @Package: com.questionnaire.student.service.impl
 * @Auther: yxd
 * @Date: 2019-02-19 12:43:21
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    QuestionnaireMapper questionnaireMapper;
    @Autowired
    TeacherQuestionnaireStudentMapper teacherQuestionnaireStudentMapper;

    @Autowired
    QuestionnaireContextTitleMapper questionnaireContextTitleMapper;
    @Autowired
    QuestionnaireContextMapper questionnaireContextMapper;
    @Autowired
    SubmitContextMapper submitContextMapper;
    @Autowired
    SubmitQuestionnaireMapper submitQuestionnaireMapper;

    @Override
    public JSONObject login(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        if (requestParam.get("username").isEmpty() || requestParam.get("password").isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "账号或者密码不能为空");

        } else {
            String md5Pass = DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
            Student student = studentMapper.login(requestParam.get("username"), md5Pass);
            if (null != student) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "登陆成功");
                jsonObject.put("data", student);
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "账号或者密码错误");
            }
        }
        return jsonObject;

    }

    @Override
    public JSONObject register(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        if (requestParam.get("username").isEmpty() || requestParam.get("password").isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "账号或者密码不能为空");

        } else {
            Student s = new Student();
            s.setUsername(requestParam.get("username"));
            String md5Pass = DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
            s.setPassword(md5Pass);
            s.setName(requestParam.get("name"));
            s.setEmail(requestParam.get("email"));
            s.setState(1);
            int count = studentMapper.insert(s);
            if (count > 0) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "注册成功");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "注册失败");
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectQuestionnaires(HttpServletRequest request) {

        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        Integer studentId = Integer.parseInt(requestParam.get("studentId"));
        Integer currentPage = Integer.parseInt(requestParam.get("currentPage"));
        Integer pageSize = Integer.parseInt(requestParam.get("pageSize"));
        if (null != studentId && studentId > 0) {


            List<RestQuestionnaireObject> restQuestionnaireObjects = new ArrayList<>();

            List<SubmitQuestionnaire> submitQuestionnaires=submitQuestionnaireMapper.selectQuestionnaireByStudentId(studentId);
            int countNums = 0;


            if (null != pageSize && pageSize > 0) {
                PageHelper.startPage(currentPage, pageSize);
            } else {
                PageHelper.startPage(currentPage);
            }


            Page<Questionnaire> questionnaires = questionnaireMapper.selectByPrimaryKeys();
            countNums = questionnaireMapper.countByKey();
            for (int i = 0; i < questionnaires.size(); i++) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                restQuestionnaireObject.setQuestionnaireId(questionnaires.get(i).getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaires.get(i).getTitle());
                restQuestionnaireObject.setQuestionnaireState(questionnaires.get(i).getState());
                try {
                    restQuestionnaireObject.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaires.get(i).getReleaseTime(), DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(submitQuestionnaires.size()==0){
                    restQuestionnaireObject.setSubmitQuestionnaireState(0);
                }
                for(int j = 0; j < submitQuestionnaires.size();j++){
                    System.out.println(questionnaires.get(i).getId()+":"+submitQuestionnaires.get(j).getQuestionnaireId()+":"+submitQuestionnaires.get(j).getSubmitState());
                    if(questionnaires.get(i).getId().equals(submitQuestionnaires.get(j).getQuestionnaireId())){
                        restQuestionnaireObject.setSubmitQuestionnaireState(submitQuestionnaires.get(j).getSubmitState());
                    }else{
                        restQuestionnaireObject.setSubmitQuestionnaireState(0);
                    }
                    continue;
                }
                restQuestionnaireObjects.add(restQuestionnaireObject);
            }

            PageBean<RestQuestionnaireObject> pageData = new PageBean<>(currentPage, pageSize, countNums);
            pageData.setItems(restQuestionnaireObjects);
            jsonObject.put("code", 1);
            jsonObject.put("msg", "问卷返回成功");
            jsonObject.put("data", pageData);
        }


        return jsonObject;
    }

    @Override
    public JSONObject selectQuestionnaireByStateForStudentId(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        Integer studentId = Integer.parseInt(requestParam.get("studentId"));
        Integer state = Integer.parseInt(requestParam.get("state"));
        Integer currentPage = Integer.parseInt(requestParam.get("currentPage"));
        Integer pageSize = Integer.parseInt(requestParam.get("pageSize"));

        if (null != studentId && studentId > 0) {
            List<RestQuestionnaireObject> restQuestionnaireObjects = new ArrayList<>();

            int countNums = 0;


            if (null != pageSize && pageSize > 0) {
                PageHelper.startPage(currentPage, pageSize);
            } else {
                PageHelper.startPage(currentPage);
            }

            List<SubmitQuestionnaire> submitQuestionnaires=submitQuestionnaireMapper.selectQuestionnaireByStudentId(studentId);

            Page<Questionnaire> questionnaires = questionnaireMapper.selectByPrimaryKeysForStatte(state);
            countNums = questionnaireMapper.countByKeyByForStatte(state);
            for (int i = 0; i < questionnaires.size(); i++) {


                if(state==3){// 已提交
                    for(int j = 0; j < submitQuestionnaires.size();j++){

                        if(questionnaires.get(i).getId().equals(submitQuestionnaires.get(j).getQuestionnaireId())){
                            RestQuestionnaireObject restQuestionnaireObject1 = new RestQuestionnaireObject();
                            restQuestionnaireObject1.setQuestionnaireId(questionnaires.get(i).getId());
                            restQuestionnaireObject1.setQuestionnaireTitle(questionnaires.get(i).getTitle());
                            restQuestionnaireObject1.setQuestionnaireState(questionnaires.get(i).getState());
                            restQuestionnaireObject1.setSubmitQuestionnaireState(submitQuestionnaires.get(j).getSubmitState());
                            try {
                                restQuestionnaireObject1.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaires.get(i).getReleaseTime(), DateUtil.HOUR_PATTERN));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            restQuestionnaireObjects.add(restQuestionnaireObject1);
                        }

                    }
                }else if(state==2){ //进行中
                    for(int j = 0; j < submitQuestionnaires.size();j++){

                        if(!questionnaires.get(i).getId().equals(submitQuestionnaires.get(j).getQuestionnaireId())){
                            RestQuestionnaireObject restQuestionnaireObject1 = new RestQuestionnaireObject();
                            restQuestionnaireObject1.setQuestionnaireId(questionnaires.get(i).getId());
                            restQuestionnaireObject1.setQuestionnaireTitle(questionnaires.get(i).getTitle());
                            restQuestionnaireObject1.setQuestionnaireState(questionnaires.get(i).getState());
                            restQuestionnaireObject1.setSubmitQuestionnaireState(submitQuestionnaires.get(j).getSubmitState());
                            try {
                                restQuestionnaireObject1.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaires.get(i).getReleaseTime(), DateUtil.HOUR_PATTERN));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            restQuestionnaireObjects.add(restQuestionnaireObject1);
                        }

                    }

                }else{// 全部
                    RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                    restQuestionnaireObject.setQuestionnaireId(questionnaires.get(i).getId());
                    restQuestionnaireObject.setQuestionnaireTitle(questionnaires.get(i).getTitle());
                    restQuestionnaireObject.setQuestionnaireState(questionnaires.get(i).getState());
                    try {
                        restQuestionnaireObject.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaires.get(i).getReleaseTime(), DateUtil.HOUR_PATTERN));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(submitQuestionnaires.size()==0&&questionnaires.get(i).getState()!=4){
                        restQuestionnaireObject.setSubmitQuestionnaireState(0);
                    }
                    if(submitQuestionnaires.size()>0){
                        for(int j = 0; j < submitQuestionnaires.size();j++){
                            System.out.println(questionnaires.get(i).getId()+":"+submitQuestionnaires.get(j).getQuestionnaireId()+":"+submitQuestionnaires.get(j).getSubmitState());
                            if(questionnaires.get(i).getId().equals(submitQuestionnaires.get(j).getQuestionnaireId())){
                                restQuestionnaireObject.setSubmitQuestionnaireState(submitQuestionnaires.get(j).getSubmitState());
                            }else{
                                restQuestionnaireObject.setSubmitQuestionnaireState(0);
                            }
                        }
                    }
                    restQuestionnaireObjects.add(restQuestionnaireObject);
                }



            }


            PageBean<RestQuestionnaireObject> pageData = new PageBean<>(currentPage, pageSize, countNums);
            pageData.setItems(restQuestionnaireObjects);
            jsonObject.put("code", 1);
            jsonObject.put("msg", "问卷返回成功");
            jsonObject.put("data", pageData);

        }


        return jsonObject;
    }

    @Override
    public JSONObject selectQuestionnaireById(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();

        Integer id = Integer.parseInt(requestParam.get("questionnaireId"));
        Integer state = Integer.parseInt(requestParam.get("state"));

        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        if (null != id && id > 0) {
            Questionnaire questionnaire = questionnaireMapper.selectByPrimaryKeyAndState(id, state);
            List<QuestionnaireContext> r_questionnaireContexts = new ArrayList<>();
            if (null != questionnaire) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                try {
                    restQuestionnaireObject.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaire.getReleaseTime(), DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                List<QuestionnaireContextTitle> questionnaireContextTitles = questionnaireContextTitleMapper.selectQuestionnaireContextTitles(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireContextTitles(questionnaireContextTitles);
                for (QuestionnaireContextTitle questionnaireContextTitle : questionnaireContextTitles) {

                    List<QuestionnaireContext> questionnaireContexts = questionnaireContextMapper.selectQuestionnaireContexts(questionnaireContextTitle.getId());
                    for (QuestionnaireContext questionnaireContext : questionnaireContexts) {
                        r_questionnaireContexts.add(questionnaireContext);
                    }

                }
                restQuestionnaireObject.setQuestionnaireContexts(r_questionnaireContexts);


                jsonObject.put("code", 1);
                jsonObject.put("msg", "返回成功");
                jsonObject.put("data", restQuestionnaireObject);
            }
        }

        return jsonObject;
    }

    @Override
    public JSONObject submitQuestionnaire(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();

        Integer questionnaireId = Integer.parseInt(requestParam.get("questionnaireId"));
        Integer studentId = Integer.parseInt(requestParam.get("userid"));
        String titles = requestParam.get("titles");
        String[] contexts = requestParam.get("contexts").split(",");
        int restId = 0;
        if (null != questionnaireId && questionnaireId > 0
                && null != studentId && studentId > 0
                && !titles.isEmpty() && null != titles
                && null != contexts && contexts.length > 0) {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setId(questionnaireId);
            questionnaire.setState(3);
            restId += questionnaireMapper.updateByPrimaryKeySelective(questionnaire);
            for (String context : contexts) {
                SubmitContext submitQuestionnaire = new SubmitContext();
                submitQuestionnaire.setQuestionnaireId(questionnaireId);
                submitQuestionnaire.setStudentId(studentId);
                submitQuestionnaire.setQuestionnaireContextId(Integer.parseInt(context));
                submitQuestionnaire.setSubmitState(1);
                restId += submitContextMapper.insert(submitQuestionnaire);
            }
            SubmitQuestionnaire submitQuestionnaire = new SubmitQuestionnaire();
            submitQuestionnaire.setStudentId(studentId);
            submitQuestionnaire.setQuestionnaireId(questionnaireId);
            submitQuestionnaire.setSubmitState(1);
            submitQuestionnaire.setSubmitTime(new Date());
            restId += submitQuestionnaireMapper.insert(submitQuestionnaire);
            if (restId > 0) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "提交成功");
            }
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "提交失败");
        }
        return jsonObject;
    }

    @Override
    public JSONObject loadSubmitData(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        int questionnaireId = Integer.parseInt(requestParam.get("questionnaireId"));
        int studentId = Integer.parseInt(requestParam.get("studentId"));
        int state = Integer.parseInt(requestParam.get("state"));
        if(questionnaireId>0
                &&studentId>0
                &&state>2){
            Questionnaire questionnaire = questionnaireMapper.selectByPrimaryKeyAndState(questionnaireId, state);
            List<RestSubmitContext> restSubmitContexts = new ArrayList<>();
            if (null != questionnaire) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                try {
                    restQuestionnaireObject.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaire.getReleaseTime(), DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                List<QuestionnaireContextTitle> questionnaireContextTitles = questionnaireContextTitleMapper.selectQuestionnaireContextTitles(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireContextTitles(questionnaireContextTitles);
                for (QuestionnaireContextTitle questionnaireContextTitle : questionnaireContextTitles) {

                    List<QuestionnaireContext> questionnaireContexts = questionnaireContextMapper.selectQuestionnaireContexts(questionnaireContextTitle.getId());
                    List<SubmitContext> submitContexts = submitContextMapper.selectByQuestionnaireIdAndStudentId(questionnaire.getId(),studentId);
                    for (int i = 0; i < questionnaireContexts.size(); i++) {
                        if(i<submitContexts.size()){
                            if(questionnaireContexts.get(i).getId().equals(submitContexts.get(i).getQuestionnaireContextId())){
                                RestSubmitContext restSubmitContext = new RestSubmitContext();
                                restSubmitContext.setContextId(questionnaireContexts.get(i).getId());
                                restSubmitContext.setContext(questionnaireContexts.get(i).getContext());
                                restSubmitContext.setContextState(questionnaireContexts.get(i).getState());
                                restSubmitContext.setQuestionnaireContextTitleId(questionnaireContexts.get(i).getQuestionnaireContextTitleId());
                                restSubmitContext.setQuestionnaireId(questionnaireId);
                                restSubmitContext.setSubmitState(submitContexts.get(i).getSubmitState());
                                restSubmitContext.setStudentId(submitContexts.get(i).getStudentId());
                                restSubmitContexts.add(restSubmitContext);
                            }
                        }else{
                            RestSubmitContext restSubmitContext = new RestSubmitContext();
                            restSubmitContext.setContextId(questionnaireContexts.get(i).getId());
                            restSubmitContext.setContext(questionnaireContexts.get(i).getContext());
                            restSubmitContext.setContextState(questionnaireContexts.get(i).getState());
                            restSubmitContext.setQuestionnaireContextTitleId(questionnaireContexts.get(i).getQuestionnaireContextTitleId());
                            restSubmitContext.setQuestionnaireId(questionnaireId);
                            restSubmitContext.setSubmitState(-1);
                            restSubmitContexts.add(restSubmitContext);
                        }
                    }

                }
                restQuestionnaireObject.setSubmitContexts(restSubmitContexts);


                jsonObject.put("code", 1);
                jsonObject.put("msg", "返回成功");
                jsonObject.put("data", restQuestionnaireObject);
            }
        }

        return jsonObject;
    }

    @Override
    public JSONObject selectTeacherByUserName(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String userName = requestParam.get("userName");
        if(userName.isEmpty()&&null==userName){
            jsonObject.put("code", 0);
            jsonObject.put("msg", "注册异常");
            jsonObject.put("data", "");
        }else {
            Student student = studentMapper.selectByUserName(userName);
            if (student != null) {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "注册异常");
                jsonObject.put("data", "");
            } else {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "");
                jsonObject.put("data", "");
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject forgot(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String username = requestParam.get("username");
        String name = requestParam.get("name");
        String email = requestParam.get("email");
        String md5Pass = DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
        Student student = studentMapper.selectByUserNameAndNameAndEmail(username,name,email);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "修改失败");
        jsonObject.put("data", "");
        if(null!=student){
            Student student1 = new Student();
            student1.setId(student.getId());
            student1.setUsername(username);
            student1.setName(name);
            student1.setPassword(md5Pass);
            student1.setEmail(email);
            int i = studentMapper.updateByPrimaryKeySelective(student1);
            if(i>0){
                jsonObject.put("code", 1);
                jsonObject.put("msg", "修改成功");
                jsonObject.put("data", "");
            }
        }
        return jsonObject;
    }
}
