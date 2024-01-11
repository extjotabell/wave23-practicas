package com.jpa.hql.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "episodes", schema = "movies_db", catalog = "")
public class EpisodesEntity {
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
    @Column(name = "rating", nullable = false, precision = 1)
    private BigDecimal rating;
    @Basic
    @Column(name = "season_id", nullable = true)
    private Object seasonId;
    @OneToMany(mappedBy = "episodesByEpisodeId")
    private Collection<ActorEpisodeEntity> actorEpisodesById;
    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private SeasonsEntity seasonsBySeasonId;

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

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Object getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Object seasonId) {
        this.seasonId = seasonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EpisodesEntity that = (EpisodesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (seasonId != null ? !seasonId.equals(that.seasonId) : that.seasonId != null) return false;

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
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (seasonId != null ? seasonId.hashCode() : 0);
        return result;
    }

    public Collection<ActorEpisodeEntity> getActorEpisodesById() {
        return actorEpisodesById;
    }

    public void setActorEpisodesById(Collection<ActorEpisodeEntity> actorEpisodesById) {
        this.actorEpisodesById = actorEpisodesById;
    }

    public SeasonsEntity getSeasonsBySeasonId() {
        return seasonsBySeasonId;
    }

    public void setSeasonsBySeasonId(SeasonsEntity seasonsBySeasonId) {
        this.seasonsBySeasonId = seasonsBySeasonId;
    }
}
