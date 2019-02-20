package com.questionnaire.dao;

import com.questionnaire.entity.Questionnaire;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionnaireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Questionnaire record);

    int insertSelective(Questionnaire record);

    Questionnaire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Questionnaire record);

    int updateByPrimaryKey(Questionnaire record);

    List<Questionnaire> selectQuestionnaires(@Param("teacherId") int teacherId);

    int insertRest(Questionnaire record);

    int updateByQuestionnaireId(@Param("id")int id);
}