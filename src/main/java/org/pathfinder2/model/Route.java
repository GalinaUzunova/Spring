package org.pathfinder2.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;


@Column(name = "gpx_coordinates",columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
@Enumerated(EnumType.STRING)
private Level level;

@Column(name = "video_url")

private String videoUrl;

@ManyToOne
private User author;
@ManyToMany
@JoinTable( joinColumns = @JoinColumn(name ="route_entity_id"),
inverseJoinColumns = @JoinColumn(name = "ctegories_id"))
private Set<Categories> categories;

@OneToMany( targetEntity = Comment.class,mappedBy = "route")
private Set<Comment>comments;
@OneToMany(targetEntity = Picture.class,mappedBy = "route")
private Set<Picture>pitures;

    public Route() {
        this.categories=new HashSet<>();
        this.comments=new HashSet<>();
        this.pitures= new HashSet<>();
    }



    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Picture> getPitures() {
        return pitures;
    }

    public void setPitures(Set<Picture> pitures) {
        this.pitures = pitures;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }



    public void setCategories(Set<Categories> categories) {
        this.categories = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }


}
