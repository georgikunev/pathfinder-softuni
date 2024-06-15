package bg.softuni.pathfinder.service.dto;

import bg.softuni.pathfinder.model.Picture;

import java.util.Set;

public class RouteInfoDTO {
    private long id;
    private String name;
    private String description;
    private String imgUrl;

    public RouteInfoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
