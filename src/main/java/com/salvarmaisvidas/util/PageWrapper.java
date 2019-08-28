package com.salvarmaisvidas.util;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Page Wrapper by ASP to organize the metadata into an object
 *
 * <pr> { "content": [T] "metadata": { "size": number returned elements, "number": number of page,
 * "number_of_elements": number of elements in page, "first": boolean is first page,
 * "total_elements": number of total elements, "total_pages": number of total pages, "last": boolean
 * is last page }, } </pr>
 *
 */
public class PageWrapper<T> {
    private final Page<T> page;
    private final PageWrapperMetadata<T> metadata;

    public PageWrapper(Page<T> page) {
        this.page = page;
        this.metadata = new PageWrapperMetadata<>(page);
    }

    public List<T> getContent() {
        return page.getContent();
    }

    public PageWrapperMetadata<T> getMetadata() {
        return metadata;
    }

}