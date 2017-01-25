package com.paradigma.services;

import java.util.List;

import com.paradigma.model.ActionModel;

/**
 * Interface for the action operations
 * @author jmedinilla
 */
public interface ActionsService {

	/**
	 * This method retrieves all the available actions stored in the persistence layer
	 * @return The list containing all the available actions
	 */
	public List<ActionModel> list();
}
