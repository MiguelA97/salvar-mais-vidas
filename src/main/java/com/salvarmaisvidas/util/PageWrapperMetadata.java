package com.salvarmaisvidas.util;

import org.springframework.data.domain.Page;

class PageWrapperMetadata<T> {

    private final Page<T> page;

    public PageWrapperMetadata(Page<T> page) {
        this.page = page;
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public long getTotalElements() {
        return page.getTotalElements();
    }

    public int getNumber() {
        return page.getNumber();
    }

    public int getSize() {
        return page.getSize();
    }

    public int getNumberOfElements() {
        return page.getNumberOfElements();
    }

    public boolean hasContent() {
        return page.hasContent();
    }

    public boolean isFirst() {
        return page.isFirst();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean hasNext() {
        return page.hasNext();
    }

    public boolean hasPrevious() {
        return page.hasPrevious();
    }

}
