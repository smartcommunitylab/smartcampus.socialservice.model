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
 * Container for {@link Concept} list.
 * @author raman
 *
 */
public class Concepts implements Serializable {
	private static final long serialVersionUID = -3368601804764169323L;

	private List<Concept> content;

	public Concepts() {
		super();
	}

	public Concepts(List<Concept> content) {
		super();
		this.content = content;
	}

	public List<Concept> getContent() {
		return content;
	}

	public void setContent(List<Concept> content) {
		this.content = content;
	}
	
	/**
	 * Convert to JSON format
	 * @param concepts
	 * @return JSON string
	 */
	public static String toJson(Concepts concepts) {
		if (concepts == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("content") + ": [");
			if (concepts.getContent() != null) {
				for (int i = 0; i < concepts.getContent().size(); i++) {
					writer.write(Concept.toJson(concepts.getContent().get(i)));
					if (i < concepts.getContent().size() -1) {
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
	 * Convert JSON string to {@link Concepts} object
	 * @param json
	 * @return
	 */
	public static Concepts toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			Concepts obj = new Concepts();
			obj.setContent(Concept.toList(object.getString("content")));
			return obj;
		} catch (JSONException e) {
			return new Concepts();
		}
	}

}
