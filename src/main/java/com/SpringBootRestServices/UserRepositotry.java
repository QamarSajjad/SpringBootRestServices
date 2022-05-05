package com.SpringBootRestServices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootRestServices.Entities.User;

@Repository
public interface UserRepositotry extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {

	User findByFirstName(String name);

	User findByFirstNameAndLastName(String firstName, String lastName);

	List<User> findByFirstNameOrLastName(String firstName, String lastName);

//	User findByFirstNameAndLastName(String firstName, int id);

	User findByFirstNameAndId(String firstName, int id);

	User findByAge(int age);

	List<User> findByAgeLessThan(int age);

//	User findByFirstNameAndId(String name, Integer id);

//	User findByFirstnameAndId(String name, int id);

//	User findByFirstNameAndId(String name, int id);

}
