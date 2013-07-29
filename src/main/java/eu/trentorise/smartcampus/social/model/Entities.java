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
 * Container for {@link Entity} list 
 * @author raman
 *
 */
public class Entities implements Serializable {

	private static final long serialVersionUID = 5744919364690321707L;

	private List<Entity> content;

	public Entities() {
		super();
	}

	public Entities(List<Entity> content) {
		super();
		this.content = content;
	}

	public List<Entity> getContent() {
		return content;
	}

	public void setContent(List<Entity> content) {
		this.content = content;
	}
	
	/**
	 * Convert to JSON format
	 * @param entities
	 * @return JSON string
	 */
	public static String toJson(Entities entities) {
		if (entities == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("content") + ": [");
			if (entities.getContent() != null) {
				for (int i = 0; i < entities.getContent().size(); i++) {
					writer.write(Entity.toJson(entities.getContent().get(i)));
					if (i < entities.getContent().size() -1) {
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
	 * Convert JSON string to {@link Entities} object
	 * @param json
	 * @return
	 */
	public static Entities toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			Entities obj = new Entities();
			obj.setContent(Entity.toList(object.getString("content")));
			return obj;
		} catch (JSONException e) {
			return new Entities();
		}
	}

}
