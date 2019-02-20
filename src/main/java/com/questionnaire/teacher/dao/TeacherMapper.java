package com.questionnaire.teacher.dao;

import com.questionnaire.teacher.entity.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher login(@Param("username") String username, @Param("password") String password);

}