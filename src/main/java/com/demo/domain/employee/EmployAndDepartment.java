package com.demo.domain.employee;

import com.demo.domain.evaluation.Evaluation;

import java.util.List;

/**
 * @author wwx
 * @date 2018/12/29 14:35
 **/
public class EmployAndDepartment {
    private String name;
    private List<Evaluation> evaluationList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }
}
