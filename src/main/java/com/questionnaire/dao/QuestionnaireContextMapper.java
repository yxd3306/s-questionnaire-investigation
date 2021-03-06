package com.questionnaire.dao;

import com.questionnaire.entity.QuestionnaireContext;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionnaireContextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionnaireContext record);

    int insertSelective(QuestionnaireContext record);

    QuestionnaireContext selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionnaireContext record);

    int updateByPrimaryKey(QuestionnaireContext record);

    List<QuestionnaireContext> selectQuestionnaireContexts(@Param("questionnaireContextTitleId") Integer questionnaireContextTitleId);

    int selectCount(@Param("questionnaireId") int questionnaireId);

    int updateByQuestionnaireId(@Param("questionnaireId") int questionnaireId);

    int insertRest(QuestionnaireContext questionnaireContext);

    int updateByQuestionnaireContextTitleId(QuestionnaireContext questionnaireContext);
}