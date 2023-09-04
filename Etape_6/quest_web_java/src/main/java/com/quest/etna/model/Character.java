package com.quest.etna.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="charac")
public class Character {
	@Column(name = "id", unique=true, nullable = false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "name is mandatory")
	@Column(name = "name", unique=true, length = 50, nullable = false)
	private String name;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "speed")
	private float speed;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "updated_date")
	private Date updated_date;
	
	
	public Character() {};
	
	public Character(@NotEmpty(message = "name is mandatory") String name, int weight, float speed, Date creation_date, Date updated_date) {
		this.name = name;
		this.weight = weight;
		this.speed = speed;
		this.creation_date = creation_date;
		this.updated_date = updated_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(creation_date, id, name, speed, updated_date, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return Objects.equals(creation_date, other.creation_date) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(speed, other.speed)
				&& Objects.equals(updated_date, other.updated_date) && weight == other.weight;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", weight=" + weight + ", speed=" + speed + ", creation_date="
				+ creation_date + ", updated_date=" + updated_date + "]";
	}

	@PrePersist
	protected void onCreate() {
	    this.creation_date = new Date();
	    this.updated_date = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
	    this.updated_date = new Date();
	}
}
