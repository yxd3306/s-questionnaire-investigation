package com.questionnaire.dao;

import com.questionnaire.entity.TeacherQuestionnaireStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherQuestionnaireStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherQuestionnaireStudent record);

    int insertSelective(TeacherQuestionnaireStudent record);

    TeacherQuestionnaireStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherQuestionnaireStudent record);

    int updateByPrimaryKey(TeacherQuestionnaireStudent record);

    List<TeacherQuestionnaireStudent> selectQuestionnaireByStudentId(@Param("studentId") Integer studentId);
}