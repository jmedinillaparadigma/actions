package com.paradigma.repositories;

import java.util.List;

import com.paradigma.model.ActionModel;

public interface ActionsRepository {

	/**
	 * This method retrieves all the available actions stored in the persistence layer
	 * @return The list containing all the available actions
	 */
	public List<ActionModel> list();
}
