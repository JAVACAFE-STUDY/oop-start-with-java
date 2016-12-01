package net.chandol.study.oop.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class SimplePage<T> extends PageImpl<T> {
    private int number;
    private int size;
    private int totalPages;
    private int numberOfElements;
    private long totalElements;
    private boolean previousPage;
    private boolean first;
    private boolean nextPage;
    private boolean last;
    private List<T> content = new ArrayList<>();
    @JsonIgnore
    private Sort sort;

    public SimplePage() {
        super(new ArrayList<>());
    }

    public SimplePage(Page<T> rawPage) {
        super(new ArrayList<>());
        this.number = rawPage.getNumber();
        this.size = rawPage.getSize();
        this.totalPages = rawPage.getTotalPages();
        this.numberOfElements = rawPage.getNumberOfElements();
        this.totalElements = rawPage.getTotalElements();
        this.previousPage = rawPage.hasPrevious();
        this.first = rawPage.isFirst();
        this.nextPage = rawPage.hasNext();
        this.last = rawPage.isLast();
        this.content = rawPage.getContent();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(boolean previousPage) {
        this.previousPage = previousPage;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isNextPage() {
        return nextPage;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public PageImpl<T> pageImpl() {
        return new PageImpl<>(getContent(), new PageRequest(getNumber(),
                getSize(), getSort()), getTotalElements());
    }

    public static <P> SimplePage<P> convert(Page<P> pageable){
        return new SimplePage<>(pageable);
    }

}