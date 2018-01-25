package com.belykh.finalProj.entity.dbo;

/**
 * Created by panda on 14.1.18.
 */
public class LotStoryDBO {
    private Long id;
    private Long userId;
    private Long lotId;

    public LotStoryDBO(Long id, Long userId, Long lotId) {
        this.id = id;
        this.userId = userId;
        this.lotId = lotId;
    }

    public LotStoryDBO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LotStoryDBO that = (LotStoryDBO) o;

        if (!id.equals(that.id)) return false;
        if (!userId.equals(that.userId)) return false;
        return lotId.equals(that.lotId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + lotId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LotStoryDBO{" +
                "id=" + id +
                ", userId=" + userId +
                ", lotId=" + lotId +
                '}';
    }
}
