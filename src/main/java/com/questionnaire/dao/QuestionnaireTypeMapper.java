package com.questionnaire.dao;

import com.questionnaire.entity.QuestionnaireType;
import org.apache.ibatis.annotations.Param;

public interface QuestionnaireTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionnaireType record);

    int insertSelective(QuestionnaireType record);

    QuestionnaireType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionnaireType record);

    int updateByPrimaryKey(QuestionnaireType record);

    QuestionnaireType selectQuestionnaires(@Param("questionnarieId") int questionnarieId);
}