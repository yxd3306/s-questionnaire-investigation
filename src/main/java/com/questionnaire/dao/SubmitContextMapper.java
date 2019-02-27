package com.questionnaire.dao;

import com.questionnaire.entity.SubmitContext;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubmitContextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubmitContext record);

    int insertSelective(SubmitContext record);

    SubmitContext selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubmitContext record);

    int updateByPrimaryKey(SubmitContext record);

    List<SubmitContext> selectByQuestionnaireIdAndStudentId(@Param("questionnaireId") Integer questionnaireId, @Param("studentId") int studentId);

    List<SubmitContext> selectQuestionnaireByStudentId(@Param("studentId")Integer studentId);
}