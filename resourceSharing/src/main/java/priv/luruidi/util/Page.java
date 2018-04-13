package priv.luruidi.util;

/**
 * @author luruidi
 * @description
 * @time 2018/03/24 09:36:32
 */
public class Page {
    private Integer totalCount;   //总记录数
    private Integer currentPage=1;  //当前页码,默认为1
    private Integer pageSize=5;     //每页显示的记录数，默认为5
    private Integer totalPage;    //总页数
    private Integer begin;        //mysql分页语法 limit（begin,pageSize）

    public Page() {
    }

    public Page(Integer totalCount, Integer currentPage, Integer pageSize) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage=totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        this.begin=(currentPage-1)*pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }
}
