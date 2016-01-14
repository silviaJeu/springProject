package com.journaldev.spring.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.journaldev.spring.mongodb.model.Person;

public class PersonDAOImpl implements PersonDAO {

	private MongoOperations mongoOps;
	private static final String PERSON_COLLECTION = "Person";
	
	public PersonDAOImpl(MongoOperations mongoOps){
		this.mongoOps = mongoOps;
	}

	@Override
	public void create(Person p) {
		this.mongoOps.insert(p, PERSON_COLLECTION);
	}

	@Override
	public Person readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, Person.class, PERSON_COLLECTION);
	}

	@Override
	public void update(Person p) {
		this.mongoOps.save(p, PERSON_COLLECTION);
		
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Person> getList() {
		List<Person> list = mongoOps.findAll( Person.class, PERSON_COLLECTION);
		return list;
	}
	
}
