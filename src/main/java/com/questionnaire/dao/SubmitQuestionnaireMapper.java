package com.questionnaire.dao;

import com.questionnaire.entity.SubmitQuestionnaire;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubmitQuestionnaireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubmitQuestionnaire record);

    int insertSelective(SubmitQuestionnaire record);

    SubmitQuestionnaire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubmitQuestionnaire record);

    int updateByPrimaryKey(SubmitQuestionnaire record);

    List<SubmitQuestionnaire> selectByQuestionnaireIdAndStudentId(@Param("questionnaireId") Integer questionnaireId, @Param("studentId") int studentId);
}