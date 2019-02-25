package com.questionnaire.dao;

import com.github.pagehelper.Page;
import com.questionnaire.entity.Questionnaire;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    Page<Questionnaire> selectQuestionnaireByState(@Param("teacherId")Integer teacherId, @Param("state")Integer state);

    @Select("select count(id) from t_questionnaire where teacher_id=#{teacherId} and state!=-1")
    int count(@Param("teacherId")Integer teacherId);

    Page<Questionnaire> selectQuestionnaireByPage(Integer teacherId);

    @Select("select count(id) from t_questionnaire where teacher_id=#{teacherId} and state=#{state}")
    int countByState(@Param("teacherId")Integer teacherId, @Param("state")Integer state);

    Page<Questionnaire> selectQuestionnaireBySearch(@Param("teacherId")Integer teacherId, @Param("title")String title);

//    @Select("select count(id) from t_questionnaire where teacher_id=#{teacherId} and state!=-1 and title like "+"'%"+",#{title},"+"%'")
    int countBySearch(@Param("teacherId")Integer teacherId, @Param("title")String title);


    List<Questionnaire> selectQuestionnairesByState();

    List<Questionnaire> selectQuestionnairesOk(@Param("id")Integer id);


    Page<Questionnaire> selectByPrimaryKeys(List<Integer> ids);
    int countByKey(List<Integer> ids);

    Page<Questionnaire> selectByPrimaryKeysForStatte(@Param("list")List<Integer> ids,  @Param("state") Integer state);

    int countByKeyByForStatte(@Param("list") List<Integer> ids, @Param("state")Integer state);


    Questionnaire selectByPrimaryKeyAndState(@Param("id") Integer id, @Param("state") Integer state);
}