package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common.dto;



import java.util.List;

public class PageResDTO<T> {

    private List<T> content;
    private long totalElements;
    private int totalPages;


    public PageResDTO() {
    }


    public PageResDTO(List<T> content, long totalElements, int totalPages) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
