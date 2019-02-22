package com.questionnaire.dao;

import com.questionnaire.entity.QuestionnaireContextTitle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionnaireContextTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionnaireContextTitle record);

    int insertSelective(QuestionnaireContextTitle record);

    QuestionnaireContextTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionnaireContextTitle record);

    int updateByPrimaryKey(QuestionnaireContextTitle record);

    QuestionnaireContextTitle selectByQuestionnaireContextKey(@Param("questionnaireContextId") Integer questionnaireContextId);

    int insertRest(QuestionnaireContextTitle questionnaireContextTitle);

    List<QuestionnaireContextTitle> selectQuestionnaireContextTitles(@Param("questionnaireId") int questionnaireId);

    int updateByQuestionnaireId(@Param("questionnaireId") int questionnaireId);
}