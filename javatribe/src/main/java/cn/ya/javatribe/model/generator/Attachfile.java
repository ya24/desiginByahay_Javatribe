package cn.ya.javatribe.model.generator;

public class Attachfile {
    private String attachfileId;

    private String attachfileName;

    private String attachfilePath;

    public String getAttachfileId() {
        return attachfileId;
    }

    public void setAttachfileId(String attachfileId) {
        this.attachfileId = attachfileId == null ? null : attachfileId.trim();
    }

    public String getAttachfileName() {
        return attachfileName;
    }

    public void setAttachfileName(String attachfileName) {
        this.attachfileName = attachfileName == null ? null : attachfileName.trim();
    }

    public String getAttachfilePath() {
        return attachfilePath;
    }

    public void setAttachfilePath(String attachfilePath) {
        this.attachfilePath = attachfilePath == null ? null : attachfilePath.trim();
    }
}