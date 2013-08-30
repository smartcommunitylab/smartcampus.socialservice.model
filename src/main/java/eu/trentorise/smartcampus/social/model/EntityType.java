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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityType other = (EntityType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
