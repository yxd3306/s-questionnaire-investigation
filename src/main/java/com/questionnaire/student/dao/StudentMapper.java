package com.questionnaire.student.dao;

import com.questionnaire.student.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student login(@Param("username") String username, @Param("password") String password);
}