package Utils;

//封装分页参数

import java.util.List;

public class PageBean<T> {
    //当前页
    private int currentPage;
    //每页显示行数
    private int pageCount=6;
    //总记录数
    private int totalCount;
    //总页数
    private int totalPage;
    //每页数据
    private List<T> pageDate;
    //封装
    private Condition condition;


    public int getTotalPage() {
        //总页数 = 总记录数/每页行数（+ 1）
        if(totalCount % pageCount==0){
            totalPage = totalCount / pageCount;
        }else {
            totalPage = totalCount / pageCount+1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getPageDate() {
        return pageDate;
    }

    public void setPageDate(List<T> pageDate) {
        this.pageDate = pageDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
