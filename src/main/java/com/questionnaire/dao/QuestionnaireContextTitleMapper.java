package com.questionnaire.dao;

import com.questionnaire.entity.QuestionnaireContextTitle;
import org.apache.ibatis.annotations.Param;

public interface QuestionnaireContextTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionnaireContextTitle record);

    int insertSelective(QuestionnaireContextTitle record);

    QuestionnaireContextTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionnaireContextTitle record);

    int updateByPrimaryKey(QuestionnaireContextTitle record);

    QuestionnaireContextTitle selectByQuestionnaireContextKey(@Param("questionnaireContextId") Integer questionnaireContextId);
}