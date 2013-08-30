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
}
