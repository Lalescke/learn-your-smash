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
@Table(name="up_tilt")
public class UpTilt {
	@Column(name = "id", unique=true, nullable = false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "name is mandatory")
	@Column(name = "name", unique=true, length = 50, nullable = false)
	private String name;
	
	@NotEmpty(message = "damage is mandatory")
	@Column(name = "damage", nullable = false)
	private int damage;
	
	@NotEmpty(message = "frame is mandatory")
	@Column(name = "frame", nullable = false)
	private int frame;
	
	@NotEmpty(message = "endlag is mandatory")
	@Column(name = "endlag", nullable = false)
	private int endlag;
	
	@OneToOne
	@JoinColumn(name = "character_id", referencedColumnName="id", nullable = false)
	private Character character;
	
	public UpTilt() {};

	public UpTilt(@NotEmpty(message = "name is mandatory") String name,
			@NotEmpty(message = "damage is mandatory") int damage, @NotEmpty(message = "frame is mandatory") int frame,
			@NotEmpty(message = "endlag is mandatory") int endlag, Character character) {
		this.name = name;
		this.damage = damage;
		this.frame = frame;
		this.endlag = endlag;
		this.character = character;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getEndlag() {
		return endlag;
	}

	public void setEndlag(int endlag) {
		this.endlag = endlag;
	}

	public Integer getId() {
		return id;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	@Override
	public int hashCode() {
		return Objects.hash(character, damage, endlag, frame, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpTilt other = (UpTilt) obj;
		return Objects.equals(character, other.character) && damage == other.damage && endlag == other.endlag
				&& frame == other.frame && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "UpTilt [id=" + id + ", name=" + name + ", damage=" + damage + ", frame=" + frame + ", endlag=" + endlag
				+ ", character=" + character + "]";
	}
}
