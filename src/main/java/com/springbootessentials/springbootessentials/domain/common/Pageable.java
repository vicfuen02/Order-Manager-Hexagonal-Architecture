package com.springbootessentials.springbootessentials.domain.common;

import org.springframework.data.domain.Page;

import java.util.List;

public class Pageable<T> {

    private List<T> content;
    private long totalElements;
    private int totalPages;

    public Pageable() {
    }

    public Pageable(Page<T> pageable) {
        this.content = pageable.getContent();
        this.totalElements = pageable.getTotalElements();
        this.totalPages = pageable.getTotalPages();
    }

    public Pageable(List<T> content, long totalElements, int totalPages) {
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
