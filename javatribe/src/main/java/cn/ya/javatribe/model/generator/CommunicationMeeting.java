package cn.ya.javatribe.model.generator;

import java.util.Date;

public class CommunicationMeeting {
    private Integer meetingId;

    private String meetingTitle;

    private String meetingDate;

    private String meetingAddress;

    private String meetingPicture;

    private String memberName;

    private Date edittime;

    private String meetingTheme;

    @Override
    public String toString() {
        return "CommunicationMeeting{" +
                "meetingId=" + meetingId +
                ", meetingTitle='" + meetingTitle + '\'' +
                ", meetingDate='" + meetingDate + '\'' +
                ", meetingAddress='" + meetingAddress + '\'' +
                ", meetingPicture='" + meetingPicture + '\'' +
                ", memberName='" + memberName + '\'' +
                ", edittime=" + edittime +
                ", meetingTheme='" + meetingTheme + '\'' +
                '}';
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle == null ? null : meetingTitle.trim();
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate == null ? null : meetingDate.trim();
    }

    public String getMeetingAddress() {
        return meetingAddress;
    }

    public void setMeetingAddress(String meetingAddress) {
        this.meetingAddress = meetingAddress == null ? null : meetingAddress.trim();
    }

    public String getMeetingPicture() {
        return meetingPicture;
    }

    public void setMeetingPicture(String meetingPicture) {
        this.meetingPicture = meetingPicture == null ? null : meetingPicture.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public String getMeetingTheme() {
        return meetingTheme;
    }

    public void setMeetingTheme(String meetingTheme) {
        this.meetingTheme = meetingTheme == null ? null : meetingTheme.trim();
    }
}