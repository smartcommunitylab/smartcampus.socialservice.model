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
import java.util.List;

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
}
