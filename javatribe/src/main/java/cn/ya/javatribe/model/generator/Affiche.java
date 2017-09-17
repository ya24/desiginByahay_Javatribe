package cn.ya.javatribe.model.generator;

import java.util.Date;

public class Affiche {
    private Integer afficheId;

    private String afficheTitle;

    private Date publicTime;

    private String memberName;

    private String attachfileId;

    private Integer status;

    private String afficheContent;

    @Override
    public String toString() {
        return "Affiche{" +
                "afficheId=" + afficheId +
                ", afficheTitle='" + afficheTitle + '\'' +
                ", publicTime=" + publicTime +
                ", memberName='" + memberName + '\'' +
                ", attachfileId='" + attachfileId + '\'' +
                ", status=" + status +
                ", afficheContent='" + afficheContent + '\'' +
                '}';
    }

    public Integer getAfficheId() {
        return afficheId;
    }

    public void setAfficheId(Integer afficheId) {
        this.afficheId = afficheId;
    }

    public String getAfficheTitle() {
        return afficheTitle;
    }

    public void setAfficheTitle(String afficheTitle) {
        this.afficheTitle = afficheTitle == null ? null : afficheTitle.trim();
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getAttachfileId() {
        return attachfileId;
    }

    public void setAttachfileId(String attachfileId) {
        this.attachfileId = attachfileId == null ? null : attachfileId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAfficheContent() {
        return afficheContent;
    }

    public void setAfficheContent(String afficheContent) {
        this.afficheContent = afficheContent == null ? null : afficheContent.trim();
    }
}