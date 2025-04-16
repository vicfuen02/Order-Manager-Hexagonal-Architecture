package com.springbootessentials.springbootessentials.service.common.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageBDTO<T> {

    private List<T> content;
    private long totalElements;
    private int totalPages;

    public PageBDTO() {
    }

    public PageBDTO(Page<T> pageable) {
        this.content = pageable.getContent();
        this.totalElements = pageable.getTotalElements();
        this.totalPages = pageable.getTotalPages();
    }

    public PageBDTO(List<T> content, long totalElements, int totalPages) {
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
