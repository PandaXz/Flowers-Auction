package com.belykh.finalProj.entity;

import java.util.Date;

/**
 * Created by panda on 7.1.18.
 */
public class AuctionDBO {
    private Long id;
    private Date start;
    private Date end;
    private String description;

    public AuctionDBO(Long id, Date start, Date end, String description) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuctionDBO auctionDBO = (AuctionDBO) o;

        if (!id.equals(auctionDBO.id)) return false;
        if (!start.equals(auctionDBO.start)) return false;
        if (!end.equals(auctionDBO.end)) return false;
        return description.equals(auctionDBO.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AuctionDBO{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }
}