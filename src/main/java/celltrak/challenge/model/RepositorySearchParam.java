package celltrak.challenge.model;

import java.io.Serializable;

/**
 * Created by nicolaslopez82.
 */

public class RepositorySearchParam implements Serializable {

    private String testCaseName;
    private String q;
    private String type;
    private String sort;
    private String order;
    private String page;
    private String per_page;

    public RepositorySearchParam() {}

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    @Override
    public String toString() {
        return "RepositorySearchParam{" +
                "testCaseName='" + testCaseName + '\'' +
                ", q='" + q + '\'' +
                ", type='" + type + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", page='" + page + '\'' +
                ", per_page='" + per_page + '\'' +
                '}';
    }
}
