package Repository;
public class PagingInfo {
    private int page, pageSize, totalCount;

    public PagingInfo(int page, int pageSize, int totalCount) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public int getPage() {
        return this.page;
    }
    public void setPage(int page) {
       this.page = page;
    }
    public int getPageSize() {
        return this.pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalCount() {
        return this.totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
