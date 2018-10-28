package io.falcon.assignment.repository;

import io.falcon.assignment.entity.*;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends CrudRepository<Test, Long>{
	List<Test> findAll();

}