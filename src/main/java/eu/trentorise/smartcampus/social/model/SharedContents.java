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

public class SharedContents implements Serializable {

	private static final long serialVersionUID = 5744919364690321707L;

	private List<SharedContent> content;

	public SharedContents() {
		super();
	}

	public SharedContents(List<SharedContent> content) {
		super();
		this.content = content;
	}

	public List<SharedContent> getContent() {
		return content;
	}

	public void setContent(List<SharedContent> content) {
		this.content = content;
	}
}