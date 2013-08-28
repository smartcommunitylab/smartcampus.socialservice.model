package eu.trentorise.smartcampus.social.model;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

	/**
	 * Convert to JSON format
	 * @param entityType
	 * @return JSON string
	 */
	public static String toJson(EntityType entityType) {
		if (entityType == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("id") + ":"
					+ JsonUtils.toJson(entityType.getId()) + ",");
			writer.write(JSONObject.quote("name") + ":"
					+ JsonUtils.toJson(entityType.getName()) + ",");
			writer.write(JSONObject.quote("concept") + ":"
					+ Concept.toJson(entityType.getConcept()));
			writer.write("}");
			return writer.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert JSON string to array of {@link EntityType}
	 * @param json
	 * @return
	 */
	public static List<EntityType> toList(String json) {
		try {
			JSONArray array = new JSONArray(json);
			List<EntityType> listElements = new ArrayList<EntityType>();
			for (int i = 0; array.optString(i).length() > 0; i++) {
				String subElement = array.getString(i);
				if (subElement != null) {
					listElements.add(toObject(subElement));
				}
			}
			return listElements;
		} catch (JSONException e) {
			return null;
		}
	}

	/**
	 * Convert JSON string to {@link EntityType} object
	 * @param json
	 * @return
	 */
	public static EntityType toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			EntityType e = new EntityType();
			e.setId(object.getString("id"));
			e.setName(object.getString("name"));
			e.setConcept(Concept.toObject(object.getString("concept")));
			return e;
		} catch (JSONException e) {
			return null;
		}
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
