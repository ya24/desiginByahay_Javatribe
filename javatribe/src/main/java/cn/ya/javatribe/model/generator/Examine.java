package cn.ya.javatribe.model.generator;

import java.util.Date;

public class Examine {
    private Integer examineId;

    private Integer gradeId;

    private Integer frequencyId;

    private String examineTheme;

    private Date examineTime;

    private String examineRequire;

    private String examineResult;

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Integer frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getExamineTheme() {
        return examineTheme;
    }

    public void setExamineTheme(String examineTheme) {
        this.examineTheme = examineTheme == null ? null : examineTheme.trim();
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public String getExamineRequire() {
        return examineRequire;
    }

    public void setExamineRequire(String examineRequire) {
        this.examineRequire = examineRequire == null ? null : examineRequire.trim();
    }

    public String getExamineResult() {
        return examineResult;
    }

    public void setExamineResult(String examineResult) {
        this.examineResult = examineResult == null ? null : examineResult.trim();
    }
}