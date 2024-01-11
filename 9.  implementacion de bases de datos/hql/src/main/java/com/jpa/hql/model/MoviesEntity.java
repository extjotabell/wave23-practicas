package com.jpa.hql.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "movies", schema = "movies_db", catalog = "")
public class MoviesEntity {
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
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Basic
    @Column(name = "rating", nullable = false, precision = 1)
    private BigDecimal rating;
    @Basic
    @Column(name = "awards", nullable = false)
    private Object awards;
    @Basic
    @Column(name = "release_date", nullable = false)
    private Timestamp releaseDate;
    @Basic
    @Column(name = "length", nullable = true)
    private Object length;
    @Basic
    @Column(name = "genre_id", nullable = true)
    private Object genreId;
    @OneToMany(mappedBy = "moviesByMovieId")
    private Collection<ActorMovieEntity> actorMoviesById;
    @OneToMany(mappedBy = "moviesByFavoriteMovieId")
    private Collection<ActorsEntity> actorsById;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private GenresEntity genresByGenreId;

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

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Object getAwards() {
        return awards;
    }

    public void setAwards(Object awards) {
        this.awards = awards;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

    public Object getGenreId() {
        return genreId;
    }

    public void setGenreId(Object genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviesEntity that = (MoviesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (awards != null ? !awards.equals(that.awards) : that.awards != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (genreId != null ? !genreId.equals(that.genreId) : that.genreId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (awards != null ? awards.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (genreId != null ? genreId.hashCode() : 0);
        return result;
    }

    public Collection<ActorMovieEntity> getActorMoviesById() {
        return actorMoviesById;
    }

    public void setActorMoviesById(Collection<ActorMovieEntity> actorMoviesById) {
        this.actorMoviesById = actorMoviesById;
    }

    public Collection<ActorsEntity> getActorsById() {
        return actorsById;
    }

    public void setActorsById(Collection<ActorsEntity> actorsById) {
        this.actorsById = actorsById;
    }

    public GenresEntity getGenresByGenreId() {
        return genresByGenreId;
    }

    public void setGenresByGenreId(GenresEntity genresByGenreId) {
        this.genresByGenreId = genresByGenreId;
    }
}
