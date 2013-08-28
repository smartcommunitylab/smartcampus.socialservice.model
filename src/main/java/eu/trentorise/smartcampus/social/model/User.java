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
 * User descriptor object.
 * Characterized by unique #id and {@link #socialId} and contains user name/surname.
 * @author raman
 *
 */
public class User {

	private String id;
	private String socialId;

	private String name; 
	private String surname;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * Convert to JSON format
	 * @param user 
	 * @return JSON string
	 */
	public static String toJson(User user) {
		if (user == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("id") + ":"
					+ JsonUtils.toJson(user.getId()) + ",");
			writer.write(JSONObject.quote("socialId") + ":"
					+ JsonUtils.toJson(user.getSocialId()) + ",");
			writer.write(JSONObject.quote("name") + ":"
					+ JsonUtils.toJson(user.getName()) + ",");
			writer.write(JSONObject.quote("surname") + ":"
					+ JsonUtils.toJson(user.getSurname()));
			writer.write("}");
			return writer.toString();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * @param users
	 * @return
	 */
	public static String toJson(List<User> users) {
		StringWriter writer = new StringWriter();
		writer.write("[");
		if (users != null) {
			for (int i = 0; i < users.size(); i++) {
				writer.write(User.toJson(users.get(i)));
				if (i < users.size() -1) {
					writer.write(',');
				}
			} 
		}
		writer.write("]");
		return writer.toString();
	}
	/**
	 * Convert JSON to {@link User}
	 * @param json
	 * @return
	 */
	public static User toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			User user = new User();
			user.setId(object.getString("id"));
			user.setSocialId(object.getString("socialId"));
			user.setName(object.getString("name"));
			user.setSurname(object.getString("surname"));
			return user;
		} catch (JSONException e) {
			return null;
		}
	}
	/**
	 * Convert JSON string to array of {@link User}
	 * @param json
	 * @return
	 */
	public static List<User> toList(String json) {
		try {
			JSONArray array = new JSONArray(json);
			List<User> listElements = new ArrayList<User>();
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
		result = prime * result
				+ ((socialId == null) ? 0 : socialId.hashCode());
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
		User other = (User) obj;
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
