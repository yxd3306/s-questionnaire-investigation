package com.questionnaire.teacher.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.common.util.BaseUtil;
import com.questionnaire.dao.QuestionnaireContextMapper;
import com.questionnaire.dao.QuestionnaireContextTitleMapper;
import com.questionnaire.dao.QuestionnaireMapper;
import com.questionnaire.dao.QuestionnaireTypeMapper;
import com.questionnaire.entity.*;
import com.questionnaire.teacher.dao.TeacherMapper;
import com.questionnaire.teacher.entity.Teacher;
import com.questionnaire.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    QuestionnaireContextTitleMapper questionnaireContextTitleMapper;

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

        // 获取问卷集合
        List<Questionnaire> questionnaires = questionnaireMapper.selectQuestionnaires(Integer.parseInt(id));

        if (!questionnaires.isEmpty() && questionnaires.size() > 0) {
            // 将结合遍历并赋值给返回对象
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


    @Transactional
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
        if (null==questionnaireId||questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "无相关问卷");
        } else {
            Questionnaire questionnaire = questionnaireMapper.selectByPrimaryKey(Integer.parseInt(questionnaireId));
            if (null == questionnaire) {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "无相关问卷");
            } else {
                List<QuestionnaireContext> r_questionnaireContexts = new ArrayList<>();
                List<RestQuestionnaireObject> restQuestionnaireObjects = new ArrayList<>();
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();

                List<QuestionnaireContextTitle> questionnaireContextTitles = questionnaireContextTitleMapper.selectQuestionnaireContextTitles(Integer.parseInt(questionnaireId));
                if(!questionnaireContextTitles.isEmpty()&&questionnaireContextTitles.size()>0){


                    for (QuestionnaireContextTitle questionnaireContextTitle : questionnaireContextTitles) {

                        List<QuestionnaireContext> questionnaireContexts = questionnaireContextMapper.selectQuestionnaireContexts(questionnaireContextTitle.getId());
                        if(!questionnaireContexts.isEmpty()&&questionnaireContexts.size()>0){
                            for (QuestionnaireContext questionnaireContext : questionnaireContexts) {
                                r_questionnaireContexts.add(questionnaireContext);
                            }
                        }
                    }

                    restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                    restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                    restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());
                    restQuestionnaireObject.setQuestionnaireContextTitles(questionnaireContextTitles);
                    restQuestionnaireObject.setQuestionnaireContexts(r_questionnaireContexts);
                    restQuestionnaireObjects.add(restQuestionnaireObject);

                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "");
                    jsonObject.put("data", restQuestionnaireObject);
                }else{
                    restQuestionnaireObject.setQuestionnaireId(Integer.parseInt(questionnaireId));
                    restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                    restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());
                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "");
                    jsonObject.put("data", restQuestionnaireObject);
                }
            }
        }
        return jsonObject;
    }

    @Transactional
    @Override
    public JSONObject addContext(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String questionnaireId = allRequestParam.get("questionnaireId");
        String title = allRequestParam.get("title");
        String context = allRequestParam.get("context");
        String[] titles = title.split(",");
        String[] contexts = context.split(",");
        String s=null;
        String c=null;
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "添加失败");
        } else {
            int index=0;
            // 遍历题目标题
            for (int i = 0; i < titles.length; i++) {
                s = titles[i];
                QuestionnaireContextTitle questionnaireContextTitle = new QuestionnaireContextTitle();
                // 遍历题目内容
                questionnaireContextTitle.setQuestionnaireTitle(s);
                questionnaireContextTitle.setQuestionnaireId(Integer.parseInt(questionnaireId));
                questionnaireContextTitle.setState(1);
                int count = questionnaireContextTitleMapper.insertRest(questionnaireContextTitle);
                int restId =questionnaireContextTitle.getId();
                if(count>0){
                    restId=questionnaireContextTitle.getId();
                    for (int j = 0; j < contexts.length/titles.length; j++) {
                        c = contexts[index];
                        index++;
                        QuestionnaireContext questionnaireContext = new QuestionnaireContext();


                        questionnaireContext.setQuestionnaireId(Integer.parseInt(questionnaireId));
                        questionnaireContext.setQuestionnaireContextTitleId(restId);
                        questionnaireContext.setContext(c);
                        questionnaireContext.setState(1);

                        questionnaireContextMapper.insertRest(questionnaireContext);
                    }
                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "添加成功");
                }else{
                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "添加失败");
                }
            }



        }


        return jsonObject;
    }

    @Transactional
    @Override
    public JSONObject deleteQuestionnaireById(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String questionnaireId = allRequestParam.get("questionnaireId");
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "删除失败");
        } else {
            int count = 0;
            count += questionnaireContextMapper.updateByQuestionnaireId(Integer.parseInt(questionnaireId));
            count += questionnaireContextTitleMapper.updateByQuestionnaireId(Integer.parseInt(questionnaireId));
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

    @Transactional
    @Override
    public JSONObject deleteContextByTitleId(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String req_questionnaireContextTitleId = allRequestParam.get("titleId");
        String req_questionnaireContextTitle = allRequestParam.get("title");

        QuestionnaireContextTitle questionnaireContextTitle = new QuestionnaireContextTitle();
        QuestionnaireContext questionnaireContext = new QuestionnaireContext();

        questionnaireContextTitle.setId(Integer.parseInt(req_questionnaireContextTitleId));
        questionnaireContextTitle.setQuestionnaireTitle(req_questionnaireContextTitle);
        questionnaireContextTitle.setState(-1);
        questionnaireContext.setQuestionnaireContextTitleId(Integer.parseInt(req_questionnaireContextTitleId));
        questionnaireContext.setState(-1);

        int i = questionnaireContextTitleMapper.updateByPrimaryKey(questionnaireContextTitle);
        if(i>0) {
            questionnaireContextMapper.updateByQuestionnaireContextTitleId(questionnaireContext);
            jsonObject.put("code", 1);
            jsonObject.put("msg", "删除成功");
        }else{
            jsonObject.put("code", 0);
            jsonObject.put("msg", "删除失败");
        }



        return jsonObject;
    }

    @Transactional
    @Override
    public JSONObject updateContext(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();



        String questionnaireId = allRequestParam.get("questionnaireId");
        String questionnaireTitle = allRequestParam.get("questionnaireTitle");
        String title = allRequestParam.get("title");
        String titleId = allRequestParam.get("titleId");
        String context = allRequestParam.get("context");
        String[] titles = title.split(",");
        String[] contexts = context.split(",");
        String[] titleIds = titleId.split(",");
        String s=null;
        String c=null;
        String id=null;
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
        } else {

            int oldTitleIndex=0;
            int oldContextIndex=0;
            int rest=0;

            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setId(Integer.parseInt(questionnaireId));
            questionnaire.setTitle(questionnaireTitle);
            rest+= questionnaireMapper.updateByPrimaryKeySelective(questionnaire);




            for (int i = 0; i < titleIds.length; i++) {
                id = titleIds[oldTitleIndex];
                QuestionnaireContextTitle questionnaireContextTitle = new QuestionnaireContextTitle();
                questionnaireContextTitle.setId(Integer.parseInt(id.trim()));
                String i_title = titles[oldTitleIndex];
                questionnaireContextTitle.setQuestionnaireTitle(i_title);
                // 修改题目标题
                rest += questionnaireContextTitleMapper.updateByPrimaryKeySelective(questionnaireContextTitle);
                oldTitleIndex++;
                for (int j = 0; j < 4; j++) {
                    String context1 = contexts[oldContextIndex];
                    QuestionnaireContext questionnaireContext = new QuestionnaireContext();
                    questionnaireContext.setContext(context1);
                    rest += questionnaireContextMapper.updateByPrimaryKeySelective(questionnaireContext);
                    oldContextIndex++;
                }
            }

            for (int i = 0; i < titles.length-titleIds.length; i++) {
                QuestionnaireContextTitle questionnaireContextTitle = new QuestionnaireContextTitle();
                String i_title = titles[oldTitleIndex];
                questionnaireContextTitle.setQuestionnaireTitle(i_title);
                questionnaireContextTitle.setState(1);
                rest += questionnaireContextTitleMapper.insertRest(questionnaireContextTitle);
                oldTitleIndex++;
                int restId=questionnaireContextTitle.getId();
                for (int j = 0; j < 4; j++) {
                    String context1 = contexts[oldContextIndex];
                    QuestionnaireContext questionnaireContext = new QuestionnaireContext();
                    questionnaireContext.setQuestionnaireId(Integer.parseInt(questionnaireId));
                    questionnaireContext.setQuestionnaireContextTitleId(restId);
                    questionnaireContext.setContext(context1);
                    questionnaireContext.setState(1);
                    rest += questionnaireContextMapper.insert(questionnaireContext);
                    oldContextIndex++;
                }
            }
            if(rest>0){
                jsonObject.put("code", 1);
                jsonObject.put("msg", "修改成功");
            }else{
                jsonObject.put("code", 0);
                jsonObject.put("msg", "修改失败");
            }

        }


        return jsonObject;
    }

    @Transactional
    @Override
    public JSONObject releaseQuestionnaire(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String ids = allRequestParam.get("ids");
        String[] split = ids.split(",");
        Questionnaire questionnaire = new Questionnaire();
        int restId=0;
        try{
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                questionnaire.setId(Integer.parseInt(s));
                questionnaire.setState(2);
                restId+=questionnaireMapper.updateByPrimaryKeySelective(questionnaire);
            }
        }finally {
            if(restId>0){
                jsonObject.put("code",1);
                jsonObject.put("msg","发布成功");
            }else{
                jsonObject.put("code",0);
                jsonObject.put("msg","发布失败");
            }
        }


        return jsonObject;
    }
}

