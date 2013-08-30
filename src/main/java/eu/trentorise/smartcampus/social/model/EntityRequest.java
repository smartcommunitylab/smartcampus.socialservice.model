package eu.trentorise.smartcampus.social.model;

import java.io.Serializable;
import java.util.List;

/**
 * Object used as input for creating/updating an entity. Should contain
 * {@link #name}, {@link #id} for update), {@link #type} or {@link #typeId}, and optionaly
 * {@link #description}, {@link #tags}, or {@link #relations}.
 * @author raman
 *
 */
public class EntityRequest implements Serializable {
	private static final long serialVersionUID = -7873323184948249830L;

	private String id;

	// I can have type as name or as its id
	private String type;
	private String typeId;

	private String name;
	private String description;
	private List<Concept> tags;
	private List<String> relations;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Concept> getTags() {
		return tags;
	}

	public void setTags(List<Concept> tags) {
		this.tags = tags;
	}

	public List<String> getRelations() {
		return relations;
	}

	public void setRelations(List<String> relations) {
		this.relations = relations;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}
