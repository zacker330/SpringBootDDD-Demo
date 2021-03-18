package codes.showme.tech;

/**
 * 分页请求
 */
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageIndex;
    /**
     * 每页数量
     */
    private int pageSize;


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}