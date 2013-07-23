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
import java.util.Date;
import java.util.List;

public class SharedContent implements Comparable<SharedContent>, Serializable {
	private static final long serialVersionUID = 63441460483742847L;

	private String entityId;
	private String entityType;
	private String title;
	private List<Concept> tags;
	// serie di keyword o concetti
	private String ownerId;

	private Date creationDate;

	private User user;
	
	private ShareVisibility visibility;

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Concept> getTags() {
		return tags;
	}

	public void setTags(List<Concept> tags) {
		this.tags = tags;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public ShareVisibility getVisibility() {
		return visibility;
	}

	public void setVisibility(ShareVisibility visibility) {
		this.visibility = visibility;
	}

	@Override
	public int compareTo(SharedContent o) {
		return (creationDate != null) ? creationDate.compareTo(o
				.getCreationDate()) : (o.getCreationDate() != null) ? -1 : 0;
	}
}
