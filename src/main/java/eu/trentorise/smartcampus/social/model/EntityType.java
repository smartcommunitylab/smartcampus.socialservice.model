package eu.trentorise.smartcampus.social.model;

import java.io.Serializable;

/**
 * Entity type descriptor. Characterized by unique {@link #id}, {@link #name} of the type, and
 * the corresponding semantic {@link #concept}.
 * @author raman
 *
 */
public class EntityType implements Serializable {
	private static final long serialVersionUID = 6673762066376341027L;

	private String id;
	private String name;
	private Concept concept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
