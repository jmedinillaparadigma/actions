package com.paradigma.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.beans.response.Action;
import com.paradigma.model.ActionModel;
import com.paradigma.services.ActionsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller to handle the http request to this service
 * @author jmedinilla
 */
@Api(value = "Actions management service")
@RequestMapping("/actions")
@RestController
@Slf4j
public class ActionsController {

	@Autowired
	private ActionsService service;
	
	
	/**
	 * This method retrieves all the available actions stored in the persistence layer
	 * @return The list containing all the available actions
	 */
	@ApiOperation(value = "Retrieves all the available actions")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The actions has been retrieved successfully", response = Action.class, responseContainer="List"),
			@ApiResponse(code = 424, message = "Failed external dependecy"),
			@ApiResponse(code = 500, message = "Server error") })
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Action>> retrieveAvailableActions() {

		log.info("GET -> /actions");
		List<ActionModel> serviceResult = service.list();
		
		List<Action> result = new ArrayList<>();
		serviceResult.stream().forEach(c -> result.add(transform(c)));
		
		return ResponseEntity.ok(result);
	}

	//////////////////////////////
	// Private functions
	//////////////////////////////
	
	private Action transform(ActionModel actionModel) {
		Action action = new Action();
		BeanUtils.copyProperties(actionModel, action);
		return action;
	}

	
}
