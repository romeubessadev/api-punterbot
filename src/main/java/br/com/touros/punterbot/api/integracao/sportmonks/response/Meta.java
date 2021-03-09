package br.com.touros.punterbot.api.integracao.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Meta {

    @JsonProperty(value = "subscription")
    private Subscription subscription;

    @JsonProperty(value = "plan")
    private Plan plan;

    @JsonProperty(value = "sports")
    private List<Sport> sports;

    @JsonProperty(value = "pagination")
    private Pagination pagination;

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public static class Plan {

        @JsonProperty(value = "name")
        private String name;
        @JsonProperty(value = "price")
        private String price;
        @JsonProperty(value = "request_limit")
        private String requestLimit;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getRequestLimit() {
            return requestLimit;
        }

        public void setRequestLimit(String requestLimit) {
            this.requestLimit = requestLimit;
        }
    }

    public static class Subscription {

        @JsonProperty(value =  "started_at")
        private DetailDate startedAt;

        @JsonProperty(value = "trial_ends_at")
        private DetailDate trialEndsAt;

        @JsonProperty(value = "ends_at")
        private DetailDate endsAt;

        public DetailDate getStartedAt() {
            return startedAt;
        }

        public void setStartedAt(DetailDate startedAt) {
            this.startedAt = startedAt;
        }

        public DetailDate getTrialEndsAt() {
            return trialEndsAt;
        }

        public void setTrialEndsAt(DetailDate trialEndsAt) {
            this.trialEndsAt = trialEndsAt;
        }

        public DetailDate getEndsAt() {
            return endsAt;
        }

        public void setEndsAt(DetailDate endsAt) {
            this.endsAt = endsAt;
        }
    }

    public static class Sport {

        @JsonProperty(value = "id")
        private Long id;
        @JsonProperty(value = "name")
        private String name;
        @JsonProperty(value = "current")
        private Boolean current;

        public Sport() {
        }

        public Sport(Long id, String name, Boolean current) {
            this.id = id;
            this.name = name;
            this.current = current;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getCurrent() {
            return current;
        }

        public void setCurrent(Boolean current) {
            this.current = current;
        }
    }

    public static class Pagination {

        @JsonProperty(value = "total")
        private Integer total;

        @JsonProperty(value = "count")
        private Integer count;

        @JsonProperty(value = "per_page")
        private Integer perPage;

        @JsonProperty(value = "current_page")
        private Integer currentPage;

        @JsonProperty(value = "total_pages")
        private Integer totalPages;

        @JsonProperty(value = "links")
        private Object links;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public Object getLinks() {
            return links;
        }

        public void setLinks(Object links) {
            this.links = links;
        }
    }

}
