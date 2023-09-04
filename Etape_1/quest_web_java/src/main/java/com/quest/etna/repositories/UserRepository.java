package com.quest.etna.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quest.etna.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Object> {

	User findByUsername(String username);
	User findById(Integer id);
}
