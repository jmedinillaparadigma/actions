package com.paradigma.repositories.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class represents a Action stored in mongodb
 * @author jmedinilla
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection="actions")
public class ActionMongo {

	@Id
	private String id;
	private String name;
	private Boolean isOffensive;
	private Boolean isPunch;
	private Integer value;
}