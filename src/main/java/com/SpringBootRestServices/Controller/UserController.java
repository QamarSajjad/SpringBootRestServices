package com.SpringBootRestServices.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootRestServices.UserRepositotry;
import com.SpringBootRestServices.Entities.User;

@RestController()
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserRepositotry user_repo;

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	

	@PostMapping("/saveUser")
	public User save(@RequestBody User user) {
//		User userEntitiesObject= user_repo.save(user);
		System.out.println(user.toString());
		return user_repo.save(user); 
	}
	

	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		List<User> userEntitiesObject= user_repo.findAll();
		return userEntitiesObject ;
	}
	
	

	@GetMapping("/deleteUser/{id}")
	public List<User> deleteUser(@PathVariable int id) {
	     user_repo.deleteById(id);
		 return user_repo.findAll();
	}
	

	@GetMapping("/search/{id}")
	public Optional<User> search(@PathVariable int id) {
	   Optional<User> user =  user_repo.findById(id);
		 return user;
	}
	
	@GetMapping("/searchByName/{name}")
	public User searchByName(@PathVariable String name) {
		User user= user_repo.findByFirstName(name);
		return user;
	}


	@GetMapping("/searchByNameAndLastName/{firstName}/{lastName}")
	public User searchByName(@PathVariable String firstName ,@PathVariable String  lastName) {
		User user= user_repo.findByFirstNameAndLastName(firstName,lastName);
		return user;
	}
	

	@GetMapping("/searchByNameAndId/{firstName}/{id}")
	public User searchByNameAndId(@ModelAttribute String firstName ,@ModelAttribute int  id) {
		User user= user_repo.findByFirstNameAndId(firstName,id);
		return user;
	}


	@GetMapping("/searchByNameOrLastName/{firstName}/{lastName}")
	public List<User> searchByNameOrLastName(@PathVariable String firstName ,@PathVariable String  lastName) {
		List<User> userList= user_repo.findByFirstNameOrLastName(firstName,lastName);
		return userList;
	}


	@GetMapping("/searchByAge/{age}")
	public User searchByAge(@PathVariable int age) {
		User userAge= user_repo.findByAge(age);
		return userAge;
	}



	@GetMapping("/searchByLessThanAge/{age}")
	public  List<User>searchByAgeLessThan(@PathVariable int age) {
		List<User> userAge= user_repo.findByAgeLessThan(age);
		return userAge;
	}

	
	@GetMapping("/getAllUserWithPagination/{pageNo}/{pageSize}")
	public  Page<User> getAllUserByPagination(@PathVariable int pageNo,@PathVariable int pageSize) {
		Pageable pageable= PageRequest.of(pageNo-1,pageSize);
		return user_repo.findAll(pageable);
	}
	

	@GetMapping("/getAllUserWithSortingASC")
	public  List<User> getAllUserBySortingASC() {
		Sort sort= Sort.by(Sort.Direction.ASC,"firstName","lastName");
		return user_repo.findAll(sort);
	}
	

	@GetMapping("/getAllUserWithSortingDSC")
	public  List<User> getAllUserBySortingDSC() {
		Sort sort= Sort.by(Sort.Direction.DESC,"id","lastName");
		return user_repo.findAll(sort);
	}
}

