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
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Container for {@link Group} list.
 * @author raman
 *
 */
public class Groups implements Serializable {

	private static final long serialVersionUID = 319602647339550114L;

	private List<Group> content;

	public Groups() {
		super();
	}

	public Groups(List<Group> content) {
		super();
		this.content = content;
	}

	public List<Group> getContent() {
		return content;
	}

	public void setContent(List<Group> content) {
		this.content = content;
	}
	
	public static String toJson(Groups groups) {
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("content") + ": [");
			if (groups.getContent() != null) {
				for (int i = 0; i < groups.getContent().size(); i++) {
					writer.write(Group.toJson(groups.getContent().get(i)));
					if (i < groups.getContent().size() -1) {
						writer.write(',');
					}
				} 
			}
			writer.write("]}");
			return writer.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert JSON string to {@link Groups} object
	 * @param json
	 * @return
	 */
	public static Groups toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			Groups groups = new Groups();
			groups.setContent(Group.toList(object.getString("content")));
			return groups;
		} catch (JSONException e) {
			return new Groups();
		}
	}

}
