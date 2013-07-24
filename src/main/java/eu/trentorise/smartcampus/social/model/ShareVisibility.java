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

import java.util.List;

/**
 * Descriptor of {@link Entity} visibility. Definied with 
 * <ul>
 * <li>{@link #allCommunities} - visible to all communities.</li>
 * <li>{@link #allUsers} - visible to all users (public).</li>
 * <li>{@link #allKnownCommunities} - visible to all the communities of which the user is the member.</li>
 * <li>{@link #allKnownUsers} - visible to all the members of the user's groups</li>
 * <li>{@link #userIds} - explicit list of users that can 'see' the entity</li>
 * <li>{@link #groupIds} - explicit list of groups which members can 'see' the entity</li>
 * <li>{@link #communityIds} - explicit list of communities which members can 'see' the entity</li>
</ul>
 * 
 * @author raman
 *
 */
public class ShareVisibility {

	private List<String> userIds;
	private List<String> groupIds;
	private List<String> communityIds;

	private boolean allKnownUsers;
	private boolean allKnownCommunities;
	private boolean allUsers;
	private boolean allCommunities;

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public List<String> getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(List<String> groupIds) {
		this.groupIds = groupIds;
	}

	public List<String> getCommunityIds() {
		return communityIds;
	}

	public void setCommunityIds(List<String> communityIds) {
		this.communityIds = communityIds;
	}

	public boolean isAllKnownUsers() {
		return allKnownUsers;
	}

	public void setAllKnownUsers(boolean allKnownUsers) {
		this.allKnownUsers = allKnownUsers;
	}

	public boolean isAllCommunities() {
		return allCommunities;
	}

	public boolean isAllKnownCommunities() {
		return allKnownCommunities;
	}

	public void setAllKnownCommunities(boolean allKnownCommunities) {
		this.allKnownCommunities = allKnownCommunities;
	}

	public boolean isAllUsers() {
		return allUsers;
	}

	public void setAllUsers(boolean allUsers) {
		this.allUsers = allUsers;
	}

	public void setAllCommunities(boolean allCommunities) {
		this.allCommunities = allCommunities;
	}

}
