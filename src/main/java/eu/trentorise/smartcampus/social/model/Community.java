/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
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
 ******************************************************************************/
package eu.trentorise.smartcampus.social.model;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Bean represents Community of users. Community is uniquely identified
 * with id and is defined by the social id, name, description, and tags.
 * @author raman
 *
 */
public class Community implements Serializable {
	private static final long serialVersionUID = -3806935282922229177L;

	private String id;
	private String socialId;
	private String name;
	private List<Concept> tags;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public List<Concept> getTags() {
		return tags;
	}

	public void setTags(List<Concept> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((socialId == null) ? 0 : socialId.hashCode());
		return result;
	}

	/**
	 * Convert JSON string to {@link Community}
	 * @param json
	 * @return JSON string
	 */
	public static Community toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			Community comm = new Community();
			comm.setId(object.getString("id"));
			comm.setName(object.getString("name"));
			comm.setSocialId(object.getString("socialId"));

			boolean isNull = object.isNull("tags");
			if (!isNull) {
				List<Concept> elements = new ArrayList<Concept>();
				for (int i = 0; object.getJSONArray("tags").optString(i)
						.length() > 0; i++) {
					elements.add(Concept.toObject(object.getJSONArray("tags").getString(i)));
				}
				comm.setTags(elements);
			}
			return comm;
		} catch (JSONException e) {
			return null;
		}
	}

	/**
	 * Convert JSON string to array of {@link Community}
	 * @param json
	 * @return
	 */
	public static List<Community> toList(String json) {
		try {
			JSONArray array = new JSONArray(json);
			List<Community> listElements = new ArrayList<Community>();
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
	 * Convert to JSON format
	 * @param c
	 * @return JSON string
	 */
	public static String toJson(Community c) {
		if (c == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("id") + ":"
					+ JsonUtils.toJson(c.getId()) + ",");
			writer.write(JSONObject.quote("name") + ":"
					+ JsonUtils.toJson(c.getName()) + ",");
			writer.write(JSONObject.quote("tags") + ":"
					+ Concept.toJson(c.getTags()) + ",");
			writer.write(JSONObject.quote("socialId") + ":"
					+ JsonUtils.toJson(c.getSocialId()));
			writer.write("}");
			return writer.toString();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Community other = (Community) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (socialId == null) {
			if (other.socialId != null)
				return false;
		} else if (!socialId.equals(other.socialId))
			return false;
		return true;
	}
	
	
}
