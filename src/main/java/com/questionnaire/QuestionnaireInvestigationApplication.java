package com.questionnaire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.questionnaire.student.dao","com.questionnaire.teacher.dao","com.questionnaire.dao"})
public class QuestionnaireInvestigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionnaireInvestigationApplication.class, args);
    }

}
