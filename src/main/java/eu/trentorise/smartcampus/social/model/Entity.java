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
 * Data entity. Uniquely identified with the {@link #entityId} and characterized by
 * <ul>
 * <li>{@link #entityType} - type ID of the entity</li>
 * <li>{@link #title} and {@link #description} attributes</li>
 * <li>{@link #tags} - list of {@link Concept} tags</li>
 * <li>{@link #ownerId} - social ID of the owner (user or community)</li>
 * <li></li>
 * </ul>
 * In addition, the object may contain full information about the owner in {@link #user},
 * and the information about the entity visibility in {@link #visibility}.
 * @author raman
 *
 */
public class Entity implements Comparable<Entity>, Serializable {
	private static final long serialVersionUID = 63441460483742847L;

	private String entityId;
	private String entityType;
	private String title;
	private String description;
	// serie di keyword o concetti
	private List<Concept> tags;
	private String ownerId;

	private List<String> relations;
	
	private Long creationDate;

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

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
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
	public int compareTo(Entity o) {
		return (creationDate != null) ? creationDate.compareTo(o
				.getCreationDate()) : (o.getCreationDate() != null) ? -1 : 0;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getRelations() {
		return relations;
	}

	public void setRelations(List<String> relations) {
		this.relations = relations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (ownerId == null) {
			if (other.ownerId != null)
				return false;
		} else if (!ownerId.equals(other.ownerId))
			return false;
		return true;
	}
	
	
}
