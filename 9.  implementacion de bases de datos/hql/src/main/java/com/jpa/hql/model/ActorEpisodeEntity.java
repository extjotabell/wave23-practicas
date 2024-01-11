package com.jpa.hql.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "actor_episode", schema = "movies_db", catalog = "")
public class ActorEpisodeEntity {
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
    @Column(name = "actor_id", nullable = false)
    private Object actorId;
    @Basic
    @Column(name = "episode_id", nullable = false)
    private Object episodeId;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    private ActorsEntity actorsByActorId;
    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private EpisodesEntity episodesByEpisodeId;

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

    public Object getActorId() {
        return actorId;
    }

    public void setActorId(Object actorId) {
        this.actorId = actorId;
    }

    public Object getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Object episodeId) {
        this.episodeId = episodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorEpisodeEntity that = (ActorEpisodeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (actorId != null ? !actorId.equals(that.actorId) : that.actorId != null) return false;
        if (episodeId != null ? !episodeId.equals(that.episodeId) : that.episodeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (actorId != null ? actorId.hashCode() : 0);
        result = 31 * result + (episodeId != null ? episodeId.hashCode() : 0);
        return result;
    }

    public ActorsEntity getActorsByActorId() {
        return actorsByActorId;
    }

    public void setActorsByActorId(ActorsEntity actorsByActorId) {
        this.actorsByActorId = actorsByActorId;
    }

    public EpisodesEntity getEpisodesByEpisodeId() {
        return episodesByEpisodeId;
    }

    public void setEpisodesByEpisodeId(EpisodesEntity episodesByEpisodeId) {
        this.episodesByEpisodeId = episodesByEpisodeId;
    }
}
