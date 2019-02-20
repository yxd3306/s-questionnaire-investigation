package com.questionnaire.teacher.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.common.util.BaseUtil;
import com.questionnaire.dao.QuestionnaireContextMapper;
import com.questionnaire.dao.QuestionnaireMapper;
import com.questionnaire.dao.QuestionnaireTypeMapper;
import com.questionnaire.entity.Questionnaire;
import com.questionnaire.entity.QuestionnaireContext;
import com.questionnaire.entity.QuestionnaireType;
import com.questionnaire.entity.RestQuestionnaireObject;
import com.questionnaire.teacher.dao.TeacherMapper;
import com.questionnaire.teacher.entity.Teacher;
import com.questionnaire.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Package: com.questionnaire.teacher.service.impl
 * @Auther: yxd
 * @Date: 2019-02-19 12:54:40
 * @Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    QuestionnaireMapper questionnaireMapper;
    @Autowired
    QuestionnaireContextMapper questionnaireContextMapper;
    @Autowired
    QuestionnaireTypeMapper questionnaireTypeMapper;

    // 登录
    @Override
    public JSONObject login(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        if (requestParam.get("username").isEmpty() || requestParam.get("password").isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "账号或者密码不能为空");

        } else {
            String md5Pass = DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
            Teacher teacher = teacherMapper.login(requestParam.get("username"), md5Pass);
            if (null != teacher) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "登陆成功");
                jsonObject.put("data", teacher);
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "账号或者密码错误");
            }
        }
        return jsonObject;
    }

    // 注册
    @Override
    public JSONObject register(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        if (requestParam.get("username").isEmpty() || requestParam.get("password").isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "账号或者密码不能为空");

        } else {
            Teacher teacher = new Teacher();
            teacher.setUsername(requestParam.get("username"));
            String md5Pass = DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
            teacher.setPassword(md5Pass);
            teacher.setName(requestParam.get("name"));
            teacher.setEmail(requestParam.get("email"));
            teacher.setState(1);
            int count = teacherMapper.insert(teacher);
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


    // 查询老师所拥有的问卷
    @Override
    public JSONObject selectQuestionnaires(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        String id = allRequestParam.get("id");

        JSONObject jsonObject = new JSONObject();
        List<RestQuestionnaireObject> restQuestionnaireObjects = new ArrayList<>();

        List<Questionnaire> questionnaires = questionnaireMapper.selectQuestionnaires(Integer.parseInt(id));

        if (!questionnaires.isEmpty() && questionnaires.size() > 0) {
            for (Questionnaire questionnaire : questionnaires) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();

                restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());

                List<QuestionnaireContext> questionnaireContexts = questionnaireContextMapper.selectQuestionnaireContexts(questionnaire.getId());

                QuestionnaireType questionnaireType = questionnaireTypeMapper.selectQuestionnaires(questionnaire.getId());

                if (!questionnaireContexts.isEmpty() && questionnaireContexts.size() > 0) {

                    restQuestionnaireObject.setQuestionnaireContexts(questionnaireContexts);
                    if (null != questionnaireType) {
                        restQuestionnaireObject.setQuestionnaireTypeId(questionnaireType.getId());
                        restQuestionnaireObject.setQuestionnaireTypeName(questionnaireType.getTypeName());
                    }
                }
                // 将单条问卷添加到返回结果集
                restQuestionnaireObjects.add(restQuestionnaireObject);

            }
            jsonObject.put("code", 1);
            jsonObject.put("msg", "问卷返回成功");
            jsonObject.put("data", restQuestionnaireObjects);
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "无相关问卷");
        }
        return jsonObject;
    }


    @Override
    public JSONObject addTitle(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String title = allRequestParam.get("title");
        String teacherUserId = allRequestParam.get("createId");
        if (title.isEmpty() || teacherUserId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "无相关问卷");
        }
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setTitle(allRequestParam.get("title"));
        questionnaire.setState(1);
        questionnaire.setTeacherId(Integer.parseInt(teacherUserId));
        int insert = questionnaireMapper.insertRest(questionnaire);
        jsonObject.put("code", 1);
        jsonObject.put("msg", "创建成功");
        jsonObject.put("data", questionnaire.getId());
        return jsonObject;
    }

    @Override
    public JSONObject selectQuestionnaireByKey(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String questionnaireId = allRequestParam.get("questionnaireId");
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "无相关问卷");
        } else {

            Questionnaire questionnaire = questionnaireMapper.selectByPrimaryKey(Integer.parseInt(questionnaireId));
            if (null == questionnaire) {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "无相关问卷");
            } else {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "");
                jsonObject.put("data", questionnaire.getTitle());
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject addContext(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String questionnaireId = allRequestParam.get("questionnaireId");
        String questionnaireContext1 = allRequestParam.get("questionnaireContext1");
        String questionnaireContext2 = allRequestParam.get("questionnaireContext2");
        String questionnaireContext3 = allRequestParam.get("questionnaireContext3");
        String questionnaireContext4 = allRequestParam.get("questionnaireContext4");
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "添加失败");
        } else {
            int count = questionnaireContextMapper.selectCount(Integer.parseInt(questionnaireId));
            if (0 <= count && count < 4) {
                QuestionnaireContext questionnaireContext = new QuestionnaireContext();
                questionnaireContext.setQuestionnaireId(Integer.parseInt(questionnaireId));
                questionnaireContext.setContext(questionnaireContext1);
                questionnaireContext.setState(1);
                questionnaireContextMapper.insert(questionnaireContext);
                questionnaireContext.setContext(questionnaireContext2);
                questionnaireContextMapper.insert(questionnaireContext);
                questionnaireContext.setContext(questionnaireContext3);
                questionnaireContextMapper.insert(questionnaireContext);
                questionnaireContext.setContext(questionnaireContext4);
                questionnaireContextMapper.insert(questionnaireContext);
                jsonObject.put("code", 1);
                jsonObject.put("msg", "添加成功");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "该标题已添加题目");
            }

        }


        return jsonObject;
    }

    @Override
    public JSONObject deleteQuestionnaireById(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String questionnaireId = allRequestParam.get("questionnaireId");
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "删除失败");
        } else {
            int count=0;
            count += questionnaireContextMapper.updateByQuestionnaireId(Integer.parseInt(questionnaireId));
            count += questionnaireMapper.updateByQuestionnaireId(Integer.parseInt(questionnaireId));
            System.out.println(count);
            if (count > 0) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "删除成功");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "删除失败");
            }
        }
        return jsonObject;
    }
}

