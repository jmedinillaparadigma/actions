package com.paradigma.repositories.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.paradigma.model.ActionModel;
import com.paradigma.repositories.ActionsRepository;
import com.paradigma.repositories.mongodb.model.ActionMongo;

/**
 * Implementation of the Action Repository for MongoDB 
 * @author jmedinilla
 */
@Repository
public class ActionsRepositoryMongo implements ActionsRepository {

	@Autowired
	private MongoOperations mongoOperations;

	
	/**
	 * This method retrieves all the available actions stored in the persistence layer
	 * @return The list containing all the available actions
	 */
	@Override
	public List<ActionModel> list() {
		List<ActionMongo> mongoResult = mongoOperations.findAll(ActionMongo.class);

		List<ActionModel> result = new ArrayList<>();
		mongoResult.stream().forEach(c -> result.add(transformAction(c)));

		return result;
	}

	
	//////////////////////////////
	// Private functions
	//////////////////////////////

	private ActionModel transformAction(ActionMongo source) {
		ActionModel target = new ActionModel();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}
