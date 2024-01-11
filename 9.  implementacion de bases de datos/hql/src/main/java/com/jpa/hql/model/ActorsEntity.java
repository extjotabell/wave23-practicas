package com.jpa.hql.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "actors", schema = "movies_db", catalog = "")
public class ActorsEntity {
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
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Basic
    @Column(name = "rating", nullable = true, precision = 1)
    private BigDecimal rating;
    @Basic
    @Column(name = "favorite_movie_id", nullable = true)
    private Object favoriteMovieId;
    @OneToMany(mappedBy = "actorsByActorId")
    private Collection<ActorEpisodeEntity> actorEpisodesById;
    @OneToMany(mappedBy = "actorsByActorId")
    private Collection<ActorMovieEntity> actorMoviesById;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private MoviesEntity moviesByFavoriteMovieId;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Object getFavoriteMovieId() {
        return favoriteMovieId;
    }

    public void setFavoriteMovieId(Object favoriteMovieId) {
        this.favoriteMovieId = favoriteMovieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorsEntity that = (ActorsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (favoriteMovieId != null ? !favoriteMovieId.equals(that.favoriteMovieId) : that.favoriteMovieId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (favoriteMovieId != null ? favoriteMovieId.hashCode() : 0);
        return result;
    }

    public Collection<ActorEpisodeEntity> getActorEpisodesById() {
        return actorEpisodesById;
    }

    public void setActorEpisodesById(Collection<ActorEpisodeEntity> actorEpisodesById) {
        this.actorEpisodesById = actorEpisodesById;
    }

    public Collection<ActorMovieEntity> getActorMoviesById() {
        return actorMoviesById;
    }

    public void setActorMoviesById(Collection<ActorMovieEntity> actorMoviesById) {
        this.actorMoviesById = actorMoviesById;
    }

    public MoviesEntity getMoviesByFavoriteMovieId() {
        return moviesByFavoriteMovieId;
    }

    public void setMoviesByFavoriteMovieId(MoviesEntity moviesByFavoriteMovieId) {
        this.moviesByFavoriteMovieId = moviesByFavoriteMovieId;
    }
}
