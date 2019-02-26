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

            /*List<TeacherQuestionnaireStudent> teacherQuestionnaireStudents = teacherQuestionnaireStudentMapper.selectQuestionnaireByStudentId(studentId);*/
            int countNums = 0;


            if (null != pageSize && pageSize > 0) {
                PageHelper.startPage(currentPage, pageSize);
            } else {
                PageHelper.startPage(currentPage);
            }


            Page<Questionnaire> questionnaires = questionnaireMapper.selectByPrimaryKeys();
            countNums = questionnaireMapper.countByKey();
            for (Questionnaire questionnaire : questionnaires) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());
                try {
                    restQuestionnaireObject.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaire.getReleaseTime(), DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
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

            /*List<TeacherQuestionnaireStudent> teacherQuestionnaireStudents = teacherQuestionnaireStudentMapper.selectQuestionnaireByStudentId(studentId);*/
            int countNums = 0;


            if (null != pageSize && pageSize > 0) {
                PageHelper.startPage(currentPage, pageSize);
            } else {
                PageHelper.startPage(currentPage);
            }

            List<Integer> ids = new ArrayList<>();
            Page<Questionnaire> questionnaires = questionnaireMapper.selectByPrimaryKeysForStatte(state);
            countNums = questionnaireMapper.countByKeyByForStatte(state);
            for (Questionnaire questionnaire : questionnaires) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());
                try {
                    restQuestionnaireObject.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaire.getReleaseTime(), DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
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
                SubmitQuestionnaire submitQuestionnaire = new SubmitQuestionnaire();
                submitQuestionnaire.setQuestionnaireId(questionnaireId);
                submitQuestionnaire.setStudentId(studentId);
                submitQuestionnaire.setQuestionnaireContextId(Integer.parseInt(context));
                submitQuestionnaire.setSubmitState(1);
                restId += submitQuestionnaireMapper.insert(submitQuestionnaire);
            }
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
                    List<SubmitQuestionnaire> submitQuestionnaires = submitQuestionnaireMapper.selectByQuestionnaireIdAndStudentId(questionnaire.getId(),studentId);
                    for (int i = 0; i < questionnaireContexts.size(); i++) {
                        if(i<submitQuestionnaires.size()){
                            System.out.println(questionnaireContexts.get(i).getId()+"::"+submitQuestionnaires.get(i).getQuestionnaireContextId());
                            if(questionnaireContexts.get(i).getId().equals(submitQuestionnaires.get(i).getQuestionnaireContextId())){
                                RestSubmitContext restSubmitContext = new RestSubmitContext();
                                restSubmitContext.setContextId(questionnaireContexts.get(i).getId());
                                restSubmitContext.setContext(questionnaireContexts.get(i).getContext());
                                restSubmitContext.setContextState(questionnaireContexts.get(i).getState());
                                restSubmitContext.setQuestionnaireContextTitleId(questionnaireContexts.get(i).getQuestionnaireContextTitleId());
                                restSubmitContext.setQuestionnaireId(questionnaireId);
                                restSubmitContext.setSubmitState(submitQuestionnaires.get(i).getSubmitState());
                                restSubmitContext.setStudentId(submitQuestionnaires.get(i).getStudentId());
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
}
