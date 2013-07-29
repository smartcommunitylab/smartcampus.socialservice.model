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
 * Container for {@link EntityType} list.
 * @author raman
 *
 */
public class EntityTypes implements Serializable {
	private static final long serialVersionUID = -2836039695780554750L;
	
	private List<EntityType> content;

	public EntityTypes() {
		super();
	}

	public EntityTypes(List<EntityType> content) {
		super();
		this.content = content;
	}

	public List<EntityType> getContent() {
		return content;
	}

	public void setContent(List<EntityType> content) {
		this.content = content;
	}
	
	/**
	 * Convert to JSON format
	 * @param entityTypes
	 * @return JSON string
	 */
	public static String toJson(EntityTypes entityTypes) {
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("content") + ": [");
			if (entityTypes.getContent() != null) {
				for (int i = 0; i < entityTypes.getContent().size(); i++) {
					writer.write(EntityType.toJson(entityTypes.getContent().get(i)));
					if (i < entityTypes.getContent().size() -1) {
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
	 * Convert JSON string to {@link EntityTypes} object
	 * @param json
	 * @return
	 */
	public static EntityTypes toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			EntityTypes obj = new EntityTypes();
			obj.setContent(EntityType.toList(object.getString("content")));
			return obj;
		} catch (JSONException e) {
			return new EntityTypes();
		}
	}

}
