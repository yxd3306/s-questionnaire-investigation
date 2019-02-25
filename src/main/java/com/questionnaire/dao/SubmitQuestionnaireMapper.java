package com.questionnaire.dao;

import com.questionnaire.entity.SubmitQuestionnaire;

public interface SubmitQuestionnaireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubmitQuestionnaire record);

    int insertSelective(SubmitQuestionnaire record);

    SubmitQuestionnaire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubmitQuestionnaire record);

    int updateByPrimaryKey(SubmitQuestionnaire record);
}