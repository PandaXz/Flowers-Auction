package com.belykh.finalProj.entity;

import java.util.Date;

/**
 * Created by panda on 7.1.18.
 */
public class Auction {
    private Long id;
    private Date start;
    private Date end;
    private String description;

    public Auction(Long id, Date start, Date end, String description) {
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

        Auction auction = (Auction) o;

        if (!id.equals(auction.id)) return false;
        if (!start.equals(auction.start)) return false;
        if (!end.equals(auction.end)) return false;
        return description.equals(auction.description);
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
        return "Auction{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }
}
