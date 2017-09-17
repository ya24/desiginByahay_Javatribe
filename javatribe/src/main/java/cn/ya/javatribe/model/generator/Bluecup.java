package cn.ya.javatribe.model.generator;

import java.util.Date;

public class Bluecup {
    private Integer bluecupId;

    private String bluecupType;

    private Date bluecupTime;

    private String bluecupResults;

    private String bluecupResultsPath;

    private Integer memberId;

    public Integer getBluecupId() {
        return bluecupId;
    }

    public void setBluecupId(Integer bluecupId) {
        this.bluecupId = bluecupId;
    }

    public String getBluecupType() {
        return bluecupType;
    }

    public void setBluecupType(String bluecupType) {
        this.bluecupType = bluecupType == null ? null : bluecupType.trim();
    }

    public Date getBluecupTime() {
        return bluecupTime;
    }

    public void setBluecupTime(Date bluecupTime) {
        this.bluecupTime = bluecupTime;
    }

    public String getBluecupResults() {
        return bluecupResults;
    }

    public void setBluecupResults(String bluecupResults) {
        this.bluecupResults = bluecupResults == null ? null : bluecupResults.trim();
    }

    public String getBluecupResultsPath() {
        return bluecupResultsPath;
    }

    public void setBluecupResultsPath(String bluecupResultsPath) {
        this.bluecupResultsPath = bluecupResultsPath == null ? null : bluecupResultsPath.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}