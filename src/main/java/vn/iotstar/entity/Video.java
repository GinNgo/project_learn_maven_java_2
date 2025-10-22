package vn.iotstar.entity;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;



@AllArgsConstructor

@NoArgsConstructor

@Data

@Entity

@Table(name="Videos")

@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")

public class Video implements Serializable {

private static final long serialVersionUID = 1L;



@Id

@Column(name="VideoId")

private String videoId;



public String getVideoId() {
	return videoId;
}



public void setVideoId(String videoId) {
	this.videoId = videoId;
}



public boolean isActive() {
	return active;
}



public void setActive(boolean active) {
	this.active = active;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}



public String getPoster() {
	return poster;
}



public void setPoster(String poster) {
	this.poster = poster;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public int getViews() {
	return views;
}



public void setViews(int views) {
	this.views = views;
}



public static long getSerialversionuid() {
	return serialVersionUID;
}



@Column(name="Active")

private boolean active;



@Column(name="Description", columnDefinition = "NVARCHAR(1000)")

private String description;



@Column(name="Poster")

private String poster;



@Column(name="Title", columnDefinition = "NVARCHAR(1000)")

private String title;



@Column(name="Views")

private int views;






//bi-directional many-to-one association to Category

@ManyToOne

@JoinColumn(name="CategoryId")

private Category category;




public Category getCategory() {

return this.category;

}



public void setCategory(Category category) {

this.category = category;

}

}
