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
}
