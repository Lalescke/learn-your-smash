package com.quest.etna.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="video")
public class Video {
	@Column(name = "id", unique=true, nullable = false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "yt_channel is mandatory")
	@Column(name = "yt_channel", unique=true, length = 50, nullable = false)
	private String yt_channel;
	
	@NotEmpty(message = "url is mandatory")
	@Column(name = "url", unique=true, length = 50, nullable = false)
	private String url;
	
	@OneToOne
	@JoinColumn(name = "character_id", referencedColumnName="id", nullable = false)
	private Character character;
	
	public Video() {};

	public Video(@NotEmpty(message = "yt_channel is mandatory") String yt_channel,
			@NotEmpty(message = "url is mandatory") String url, Character character) {
		this.yt_channel = yt_channel;
		this.url = url;
		this.character = character;
	}

	public String getYt_channel() {
		return yt_channel;
	}

	public void setYt_channel(String yt_channel) {
		this.yt_channel = yt_channel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", yt_channel=" + yt_channel + ", url=" + url + ", character=" + character + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(character, id, url, yt_channel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		return Objects.equals(character, other.character) && Objects.equals(id, other.id)
				&& Objects.equals(url, other.url) && Objects.equals(yt_channel, other.yt_channel);
	};
}
