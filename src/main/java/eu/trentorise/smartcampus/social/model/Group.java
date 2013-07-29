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
 * User group descriptor. Uniquely identified with {@link #socialId} of the group. Contains the name and list
 * of the {@link User} in {@link #users}.
 * @author raman
 *
 */
public class Group implements Serializable {

	private static final long serialVersionUID = -8346644455435095887L;

	private String socialId;
	private String name;
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String id) {
		this.socialId = id;
	}

	/**
	 * Convert to JSON format
	 * @param group
	 * @return JSON string
	 */
	public static String toJson(Group group) {
		if (group == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("socialId") + ":"
					+ JsonUtils.toJson(group.getSocialId()) + ",");
			writer.write(JSONObject.quote("name") + ":"
					+ JsonUtils.toJson(group.getName()) + ",");
			writer.write(JSONObject.quote("users") + ":"
					+ User.toJson(group.getUsers()));
			writer.write("}");
			return writer.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert JSON array string to the list of {@link Group} objects
	 * @param string
	 * @return
	 */
	public static List<Group> toList(String json) {
		try {
			JSONArray array = new JSONArray(json);
			List<Group> listElements = new ArrayList<Group>();
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
	 * Convert JSON string to {@link Group} object
	 * @param json
	 * @return
	 */
	public static Group toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			Group e = new Group();
			e.setName(object.getString("name"));
			e.setSocialId(object.getString("socialId"));
			if (object.has("users"))
				e.setUsers(User.toList(object.getString("users")));
			return e;
		} catch (JSONException e) {
			return null;
		}
	}
}
