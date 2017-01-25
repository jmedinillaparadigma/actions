package com.paradigma.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paradigma.model.ActionModel;
import com.paradigma.repositories.ActionsRepository;
import com.paradigma.services.ActionsService;

/**
 * Default implementation for the Action operations
 * @author jmedinilla
 */
@Service
public class ActionsServiceDefault implements ActionsService {

	@Autowired
	private ActionsRepository repository;
	
	
	/**
	 * This method retrieves all the available actions stored in the persistence layer
	 * @return The list containing all the available actions
	 */
	@Override
	public List<ActionModel> list() {
		return repository.list();
	}

}
