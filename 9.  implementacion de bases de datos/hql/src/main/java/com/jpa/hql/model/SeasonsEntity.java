package com.jpa.hql.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "seasons", schema = "movies_db", catalog = "")
public class SeasonsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @Basic
    @Column(name = "title", nullable = true, length = 500)
    private String title;
    @Basic
    @Column(name = "number", nullable = true)
    private Object number;
    @Basic
    @Column(name = "release_date", nullable = false)
    private Timestamp releaseDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;
    @Basic
    @Column(name = "serie_id", nullable = true)
    private Object serieId;
    @OneToMany(mappedBy = "seasonsBySeasonId")
    private Collection<EpisodesEntity> episodesById;
    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private SeriesEntity seriesBySerieId;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getNumber() {
        return number;
    }

    public void setNumber(Object number) {
        this.number = number;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Object getSerieId() {
        return serieId;
    }

    public void setSerieId(Object serieId) {
        this.serieId = serieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeasonsEntity that = (SeasonsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (serieId != null ? !serieId.equals(that.serieId) : that.serieId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (serieId != null ? serieId.hashCode() : 0);
        return result;
    }

    public Collection<EpisodesEntity> getEpisodesById() {
        return episodesById;
    }

    public void setEpisodesById(Collection<EpisodesEntity> episodesById) {
        this.episodesById = episodesById;
    }

    public SeriesEntity getSeriesBySerieId() {
        return seriesBySerieId;
    }

    public void setSeriesBySerieId(SeriesEntity seriesBySerieId) {
        this.seriesBySerieId = seriesBySerieId;
    }
}
