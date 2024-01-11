package com.jpa.hql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "migrations", schema = "movies_db", catalog = "")
public class MigrationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Object id;
    @Basic
    @Column(name = "migration", nullable = false, length = 255)
    private String migration;
    @Basic
    @Column(name = "batch", nullable = false)
    private int batch;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getMigration() {
        return migration;
    }

    public void setMigration(String migration) {
        this.migration = migration;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MigrationsEntity that = (MigrationsEntity) o;

        if (batch != that.batch) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (migration != null ? !migration.equals(that.migration) : that.migration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (migration != null ? migration.hashCode() : 0);
        result = 31 * result + batch;
        return result;
    }
}
