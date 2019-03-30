package com.questionnaire.teacher.service.impl;

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
import com.questionnaire.teacher.dao.TeacherMapper;
import com.questionnaire.teacher.entity.Teacher;
import com.questionnaire.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    SubmitQuestionnaireMapper submitQuestionnaireMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SubmitContextMapper submitContextMapper;

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
    @Transactional
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
        Integer teacherId = Integer.parseInt(allRequestParam.get("id"));
        Integer currentPage = Integer.parseInt(allRequestParam.get("currentPage"));
        Integer pageSize = Integer.parseInt(allRequestParam.get("pageSize"));


        if (null != pageSize && pageSize > 0) {
            PageHelper.startPage(currentPage, pageSize);
        } else {
            PageHelper.startPage(currentPage);
        }
        Page<Questionnaire> questionnaires = questionnaireMapper.selectQuestionnaireByPage(teacherId);
        int countNums = questionnaireMapper.count(teacherId);            //总记录数
        JSONObject jsonObject = new JSONObject();
        if (countNums <= 0) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "无相关问卷");
        } else {
            ArrayList<RestQuestionnaireObject> restQuestionnaireObjects = new ArrayList<>();
            for (Questionnaire questionnaire : questionnaires) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                try {
                    restQuestionnaireObject.setQuestionnaireCreateTime(DateUtil.dateFormat(questionnaire.getCreateTime(), DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());
                restQuestionnaireObjects.add(restQuestionnaireObject);

            }
            PageBean<RestQuestionnaireObject> pageData = new PageBean<>(currentPage, pageSize, countNums);
            pageData.setItems(restQuestionnaireObjects);
            jsonObject.put("code", 1);
            jsonObject.put("msg", "问卷返回成功");
            jsonObject.put("data", pageData);
        }

        return jsonObject;
//        return null;
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
        questionnaire.setCreateTime(new Date());
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
        if (null == questionnaireId || questionnaireId.isEmpty()) {
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
                if (!questionnaireContextTitles.isEmpty() && questionnaireContextTitles.size() > 0) {


                    for (QuestionnaireContextTitle questionnaireContextTitle : questionnaireContextTitles) {

                        List<QuestionnaireContext> questionnaireContexts = questionnaireContextMapper.selectQuestionnaireContexts(questionnaireContextTitle.getId());
                        if (!questionnaireContexts.isEmpty() && questionnaireContexts.size() > 0) {
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
                    try {
                        restQuestionnaireObject.setQuestionnaireCreateTime(DateUtil.dateFormat(questionnaire.getCreateTime(),DateUtil.HOUR_PATTERN));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    restQuestionnaireObjects.add(restQuestionnaireObject);

                    jsonObject.put("code", 1);
                    jsonObject.put("msg", "");
                    jsonObject.put("data", restQuestionnaireObject);
                } else {
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
        String s = null;
        String c = null;
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "添加失败");
        } else {
            int index = 0;
            // 遍历题目标题
            for (int i = 0; i < titles.length; i++) {
                s = titles[i];
                QuestionnaireContextTitle questionnaireContextTitle = new QuestionnaireContextTitle();
                // 遍历题目内容
                questionnaireContextTitle.setQuestionnaireTitle(s);
                questionnaireContextTitle.setQuestionnaireId(Integer.parseInt(questionnaireId));
                questionnaireContextTitle.setState(1);
                int count = questionnaireContextTitleMapper.insertRest(questionnaireContextTitle);
                int restId = questionnaireContextTitle.getId();
                if (count > 0) {
                    restId = questionnaireContextTitle.getId();
                    for (int j = 0; j < contexts.length / titles.length; j++) {
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
                } else {
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
        if (i > 0) {
            questionnaireContextMapper.updateByQuestionnaireContextTitleId(questionnaireContext);
            jsonObject.put("code", 1);
            jsonObject.put("msg", "删除成功");
        } else {
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
        String contextId = allRequestParam.get("contextId");
        String[] titles = title.split(",");
        String[] contexts = context.split(",");
        String[] titleIds = titleId.split(",");
        String[] contextIds = contextId.split(",");
        String s = null;
        String c = null;
        String id = null;
        if (questionnaireId.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
        } else {

            int oldTitleIndex = 0;
            int oldContextIndex = 0;
            int rest = 0;

            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setId(Integer.parseInt(questionnaireId));
            questionnaire.setTitle(questionnaireTitle);
            rest += questionnaireMapper.updateByPrimaryKeySelective(questionnaire);


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
                    String contextId2 = contextIds[oldContextIndex];
                    Integer contextId1 = Integer.parseInt(contextId2.trim());
                    QuestionnaireContext questionnaireContext = new QuestionnaireContext();
                    questionnaireContext.setId(contextId1);
                    questionnaireContext.setContext(context1);
                    rest += questionnaireContextMapper.updateByPrimaryKeySelective(questionnaireContext);
                    oldContextIndex++;
                }
            }

            for (int i = 0; i < titles.length - titleIds.length; i++) {
                QuestionnaireContextTitle questionnaireContextTitle = new QuestionnaireContextTitle();
                String i_title = titles[oldTitleIndex];
                questionnaireContextTitle.setQuestionnaireTitle(i_title);
                questionnaireContextTitle.setState(1);
                rest += questionnaireContextTitleMapper.insertRest(questionnaireContextTitle);
                oldTitleIndex++;
                int restId = questionnaireContextTitle.getId();
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
            if (rest > 0) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "修改成功");
            } else {
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
        int restId = 0;
        try {
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                questionnaire.setId(Integer.parseInt(s));
                questionnaire.setReleaseTime(new Date());
                questionnaire.setState(2);
                restId += questionnaireMapper.updateByPrimaryKeySelective(questionnaire);

            }
            System.out.println("restId"+restId);
            System.out.println("ids"+ids);
        } finally {
            if (restId > 0) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "发布成功");
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "发布失败");
            }
        }


        return jsonObject;
    }

    @Override
    public JSONObject selectQuestionnaireByState(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        Integer teacherId = Integer.parseInt(allRequestParam.get("id"));
        Integer currentPage = Integer.parseInt(allRequestParam.get("currentPage"));
        Integer pageSize = Integer.parseInt(allRequestParam.get("pageSize"));
        Integer state = Integer.parseInt(allRequestParam.get("state"));


        if (null != pageSize && pageSize > 0) {
            PageHelper.startPage(currentPage, pageSize);
        } else {
            PageHelper.startPage(currentPage);
        }

        if (null == teacherId || null == state) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "无相关问卷");
        } else {
            Page<Questionnaire> questionnaires = questionnaireMapper.selectQuestionnaireByState(teacherId, state);
            int countNums = questionnaireMapper.countByState(teacherId, state);            //总记录数
            if (countNums <= 0) {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "无相关问卷");
            } else {
                List<RestQuestionnaireObject> restQuestionnaireObjects = new ArrayList<>();
                for (Questionnaire questionnaire : questionnaires) {
                    RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                    restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                    restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                    try {
                        restQuestionnaireObject.setQuestionnaireCreateTime(DateUtil.dateFormat(questionnaire.getCreateTime(), DateUtil.HOUR_PATTERN));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());
                    restQuestionnaireObjects.add(restQuestionnaireObject);
                }

                PageBean<RestQuestionnaireObject> pageData = new PageBean<>(currentPage, pageSize, countNums);
                pageData.setItems(restQuestionnaireObjects);
                jsonObject.put("code", 1);
                jsonObject.put("msg", "问卷返回成功");
                jsonObject.put("data", pageData);
            }
        }

        return jsonObject;
    }

    @Override
    public JSONObject selectQuestionnaireBySearch(HttpServletRequest request) {

        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        Integer teacherId = Integer.parseInt(allRequestParam.get("id"));
        Integer currentPage = Integer.parseInt(allRequestParam.get("currentPage"));
        Integer pageSize = Integer.parseInt(allRequestParam.get("pageSize"));
        String search = allRequestParam.get("search");

        if (null == teacherId || search.isEmpty() || null == search) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "无相关问卷");
        } else {

            /*设置当前页和每页条数*/
            if (null != pageSize && pageSize > 0) {
                PageHelper.startPage(currentPage, pageSize);
            } else {
                PageHelper.startPage(currentPage);
            }

            Page<Questionnaire> questionnaires = questionnaireMapper.selectQuestionnaireBySearch(teacherId, search);
            int countNums = questionnaireMapper.countBySearch(teacherId, search);            //总记录数
            if (countNums <= 0) {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "无相关问卷");
            } else {
                List<RestQuestionnaireObject> restQuestionnaireObjects = new ArrayList<>();
                for (Questionnaire questionnaire : questionnaires) {
                    RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                    restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                    restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                    try {
                        restQuestionnaireObject.setQuestionnaireCreateTime(DateUtil.dateFormat(questionnaire.getCreateTime(), DateUtil.HOUR_PATTERN));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    restQuestionnaireObject.setQuestionnaireState(questionnaire.getState());
                    restQuestionnaireObjects.add(restQuestionnaireObject);
                }

                PageBean<RestQuestionnaireObject> pageData = new PageBean<>(currentPage, pageSize, countNums);
                pageData.setItems(restQuestionnaireObjects);
                jsonObject.put("code", 1);
                jsonObject.put("msg", "问卷返回成功");
                jsonObject.put("data", pageData);
            }


        }


        return jsonObject;
    }

    @Transactional
    @Override
    public JSONObject backQuestionnaireById(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        Integer id = Integer.parseInt(allRequestParam.get("questionnaireId"));
        if(null!=id&&id>0){
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setId(id);
            questionnaire.setState(4);
            int i = questionnaireMapper.updateByPrimaryKeySelective(questionnaire);
            if(i>0){
                jsonObject.put("code", 1);
                jsonObject.put("msg", "收回成功");
                jsonObject.put("data", "");
            }else{
                jsonObject.put("code", 0);
                jsonObject.put("msg", "收回失败");
                jsonObject.put("data", "");
            }
        }else{
            jsonObject.put("code", 0);
            jsonObject.put("msg", "收回失败");
            jsonObject.put("data", "");
        }
        return jsonObject;
    }

    @Override
    public JSONObject selectSubmitDataById(HttpServletRequest request) {
        TreeMap<String, String> allRequestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        Integer questionnaireId=Integer.parseInt(allRequestParam.get("id"));
        if(null!=questionnaireId&&questionnaireId>0){
            ArrayList<RestSubmitQuestionnaire> restSubmitQuestionnaires = new ArrayList<>();
            List<SubmitQuestionnaire> submitQuestionnaires = submitQuestionnaireMapper.selectSubmitDataById(questionnaireId);
            if(null!=submitQuestionnaires&&submitQuestionnaires.size()>0){
                for (SubmitQuestionnaire submitQuestionnaire : submitQuestionnaires) {
                    Student student = studentMapper.selectByPrimaryKey(submitQuestionnaire.getStudentId());
                    if(null!=student){
                        RestSubmitQuestionnaire restSubmitQuestionnaire = new RestSubmitQuestionnaire();
                        restSubmitQuestionnaire.setStudentName(student.getName());
                        restSubmitQuestionnaire.setStudentId(student.getId());
                        restSubmitQuestionnaire.setQuestionnaireId(submitQuestionnaire.getQuestionnaireId());
                        try {
                            restSubmitQuestionnaire.setSubmitTime(DateUtil.dateFormat(submitQuestionnaire.getSubmitTime(),DateUtil.HOUR_PATTERN));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        restSubmitQuestionnaires.add(restSubmitQuestionnaire);
                    }
                }
            }
            jsonObject.put("code", 1);
            jsonObject.put("msg", "ok");
            jsonObject.put("data", restSubmitQuestionnaires);
        }else{
            jsonObject.put("code", 0);
            jsonObject.put("msg", "err");
        }


        return jsonObject;
    }

    @Override
    public JSONObject loadSubmitData(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        int questionnaireId = Integer.parseInt(requestParam.get("questionnaireId"));
        int studentId = Integer.parseInt(requestParam.get("studentId"));
        if(questionnaireId>0
                &&studentId>0){
            Questionnaire questionnaire = questionnaireMapper.loadSubmitData(questionnaireId);
            SubmitQuestionnaire submitQuestionnaire = submitQuestionnaireMapper.selectSubmitDataByQuestionnaireId(questionnaireId,studentId);
            List<RestSubmitContext> restSubmitContexts = new ArrayList<>();
            if (null != questionnaire) {
                RestQuestionnaireObject restQuestionnaireObject = new RestQuestionnaireObject();
                restQuestionnaireObject.setQuestionnaireId(questionnaire.getId());
                restQuestionnaireObject.setQuestionnaireTitle(questionnaire.getTitle());
                try {
                    restQuestionnaireObject.setSubmitTime(DateUtil.dateFormat(submitQuestionnaire.getSubmitTime(),DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    restQuestionnaireObject.setQuestionnaireReleaseTime(DateUtil.dateFormat(questionnaire.getReleaseTime(), DateUtil.HOUR_PATTERN));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                List<QuestionnaireContextTitle> questionnaireContextTitles = questionnaireContextTitleMapper.selectQuestionnaireContextTitles(questionnaire.getId());
                // 根据测评id和学生id查询提交内容
                List<SubmitContext> submitContexts = submitContextMapper.selectByQuestionnaireIdAndStudentId(questionnaire.getId(),studentId);
                restQuestionnaireObject.setQuestionnaireContextTitles(questionnaireContextTitles);
                // 遍历选项标题
                for (QuestionnaireContextTitle questionnaireContextTitle : questionnaireContextTitles) {
                    // 根据选项标题id查询全部选项内容
                    List<QuestionnaireContext> questionnaireContexts = questionnaireContextMapper.selectQuestionnaireContexts(questionnaireContextTitle.getId());
                    // 便利全部选项内容
                    for (int i = 0; i < questionnaireContexts.size(); i++) {
                        // 创建返回提交内容对象
                        RestSubmitContext restSubmitContext = new RestSubmitContext();
                        // 设置基本的提交内容
                        restSubmitContext.setContextId(questionnaireContexts.get(i).getId());
                        restSubmitContext.setContext(questionnaireContexts.get(i).getContext());
                        restSubmitContext.setContextState(questionnaireContexts.get(i).getState());
                        restSubmitContext.setQuestionnaireContextTitleId(questionnaireContexts.get(i).getQuestionnaireContextTitleId());
                        restSubmitContext.setQuestionnaireId(questionnaireId);
                        // 便利提交的内容
                        for (int j = 0; j < submitContexts.size(); j++) {
                            // 判断选项内容id是否一致
                            if(questionnaireContexts.get(i).getId().equals(submitContexts.get(j).getQuestionnaireContextId())){
                                // 设置提交状态，前端通过这个装台控制是否勾选 内容选项
                                restSubmitContext.setSubmitState(submitContexts.get(j).getSubmitState());
                                // 设置提交的学生id
                                restSubmitContext.setStudentId(submitContexts.get(j).getStudentId());

                            }
                        }
                        // 将返回提交内容对象塞到List<RestSubmitContext>集合中
                        restSubmitContexts.add(restSubmitContext);
                    }

                }
                // 设置最后返回的对象   设置提交内容（是一个集合）
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
            Teacher teacher = teacherMapper.selectByUserName(userName);
            if (teacher != null) {
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

    @Transactional
    @Override
    public JSONObject forgot(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        String username = requestParam.get("username");
        String name = requestParam.get("name");
        String email = requestParam.get("email");
        String md5Pass = DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
        Teacher teacher = teacherMapper.selectByUserNameAndNameAndEmail(username,name,email);
        jsonObject.put("code", 0);
        jsonObject.put("msg", "修改失败");
        jsonObject.put("data", "");
        if(null!=teacher){
            Teacher teacher1 = new Teacher();
            teacher1.setId(teacher.getId());
            teacher1.setUsername(username);
            teacher1.setName(name);
            teacher1.setPassword(md5Pass);
            teacher1.setEmail(email);
            int i = teacherMapper.updateByPrimaryKeySelective(teacher);
            if(i>0){
                jsonObject.put("code", 1);
                jsonObject.put("msg", "修改成功");
                jsonObject.put("data", "");
            }
        }
        return jsonObject;
    }
}

