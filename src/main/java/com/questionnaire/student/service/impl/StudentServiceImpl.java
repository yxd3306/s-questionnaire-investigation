package com.questionnaire.student.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.questionnaire.common.util.BaseUtil;
import com.questionnaire.student.dao.StudentMapper;
import com.questionnaire.student.entity.Student;
import com.questionnaire.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
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

    @Override
    public JSONObject login(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        if(requestParam.get("username").isEmpty()||requestParam.get("password").isEmpty()) {
            jsonObject.put("code",0);
            jsonObject.put("msg","账号或者密码不能为空");

        }else{
            String md5Pass= DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
            Student student = studentMapper.login(requestParam.get("username"), md5Pass);
            if(null!=student){
                jsonObject.put("code",1);
                jsonObject.put("msg","登陆成功");
                jsonObject.put("data",student);
            }else{
                jsonObject.put("code",0);
                jsonObject.put("msg","账号或者密码错误");
            }
        }
        return jsonObject;

    }

    @Override
    public JSONObject register(HttpServletRequest request) {
        TreeMap<String, String> requestParam = BaseUtil.getAllRequestParam(request);
        JSONObject jsonObject = new JSONObject();
        if(requestParam.get("username").isEmpty()||requestParam.get("password").isEmpty()) {
            jsonObject.put("code",0);
            jsonObject.put("msg","账号或者密码不能为空");

        }else{
            Student s = new Student();
            s.setUsername(requestParam.get("username"));
            String md5Pass= DigestUtils.md5DigestAsHex(requestParam.get("password").getBytes());
            s.setPassword(md5Pass);
            s.setEmail(requestParam.get("email"));
            s.setState(1);
            int count = studentMapper.insert(s);
            if(count>0){
                jsonObject.put("code",1);
                jsonObject.put("msg","注册成功");
            }else{
                jsonObject.put("code",0);
                jsonObject.put("msg","注册失败");
            }
        }
        return jsonObject;
    }
}
