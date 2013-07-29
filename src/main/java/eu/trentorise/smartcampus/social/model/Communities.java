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
 * Container for {@link Community} list
 * @author raman
 *
 */
public class Communities implements Serializable {

	private static final long serialVersionUID = -5305685911253031710L;

	private List<Community> content;

	public Communities() {
		super();
	}

	public Communities(List<Community> content) {
		super();
		this.content = content;
	}

	public List<Community> getContent() {
		return content;
	}

	public void setContent(List<Community> content) {
		this.content = content;
	}
	
	/**
	 * Convert to JSON format
	 * @param communities
	 * @return JSON string
	 */
	public static String toJson(Communities communities) {
		if (communities == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("content") + ": [");
			if (communities.getContent() != null) {
				for (int i = 0; i < communities.getContent().size(); i++) {
					writer.write(Community.toJson(communities.getContent().get(i)));
					if (i < communities.getContent().size() -1) {
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
	 * Convert JSON string to {@link Communities} object
	 * @param json
	 * @return
	 */
	public static Communities toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			Communities obj = new Communities();
			obj.setContent(Community.toList(object.getString("content")));
			return obj;
		} catch (JSONException e) {
			return new Communities();
		}
	}

}
