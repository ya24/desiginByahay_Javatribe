package cn.ya.javatribe.model.admin;

import java.util.List;

/**
 * Created by 叶雅芳 on 2017/3/23.
 * 分页model
 */
public class Page<T> {

    private int index;  // 数据库中需要用到的索引
    private int currentPage;    //当前页
    private int totalRecord;    //总记录数
    private int pageSize;   // 每页记录数
    private String url;
    private int totalPage;  //总页数
    private List<T> datas;

    @Override
    public String toString() {
        return "Page{" +
                "index=" + index +
                ", currentPage=" + currentPage +
                ", totalRecord=" + totalRecord +
                ", pageSize=" + pageSize +
                ", url='" + url + '\'' +
                ", totalPage=" + totalPage +
                ", datas=" + datas +
                '}';
    }

    public int getIndex() {
        return ((getCurrentPage() - 1) * getPageSize());
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotalPage() {
        if (getTotalRecord() % getPageSize() != 0){
            return (getTotalRecord() / getPageSize()) + 1;
        }
        return getTotalRecord() / getPageSize();
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
