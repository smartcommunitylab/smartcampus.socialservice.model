/**
 *    Copyright 2012-2013 Trento RISE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.trentorise.smartcampus.social.model;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Generic representation of the tag. May define textual tag or semantic tag. In the latter case 
 * the {@link #id} field will correspond to the semantic concept id, while {@link #name}, {@link #description}, and {@link #setSummary(String)}
 * will represent the label, description and summary of the concept respectively. 
 * @author raman
 *
 */
public class Concept {

	private String id;
	private String name;
	private String description;
	private String summary;

	public Concept(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Concept() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Convert JSON to {@link Concept}
	 * @param string
	 * @return
	 */
	public static Concept toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			Concept concept = new Concept();
			concept.setId(object.getString("id"));
			concept.setDescription(object.getString("description"));
			concept.setName(object.getString("name"));
			concept.setSummary(object.getString("summary"));
			return concept;
		} catch (JSONException e) {
			return null;
		}
	}

	/**
	 * Convert to JSON format
	 * @param tags
	 * @return JSON string
	 */
	public static String toJson(List<Concept> tags) {
		StringWriter writer = new StringWriter();
		writer.write("[");
		if (tags != null) {
			for (int i = 0; i < tags.size(); i++) {
				writer.write(Concept.toJson(tags.get(i)));
				if (i < tags.size() -1) {
					writer.write(',');
				}
			} 
		}
		writer.write("]");
		return writer.toString();
	}

	/**
	 * Convert to JSON format
	 * @param c
	 * @return JSON string
	 */
	public static String toJson(Concept c) {
		if (c == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("id") + ":"
					+ JsonUtils.toJson(c.getId()) + ",");
			writer.write(JSONObject.quote("name") + ":"
					+ JsonUtils.toJson(c.getName()) + ",");
			writer.write(JSONObject.quote("description") + ":"
					+ JsonUtils.toJson(c.getDescription()) + ",");
			writer.write(JSONObject.quote("summary") + ":"
					+ JsonUtils.toJson(c.getSummary()));
			writer.write("}");
			return writer.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert JSON string to array of {@link Concept}
	 * @param json
	 * @return
	 */
	public static List<Concept> toList(String json) {
		try {
			JSONArray array = new JSONArray(json);
			List<Concept> listElements = new ArrayList<Concept>();
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
		Concept other = (Concept) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
