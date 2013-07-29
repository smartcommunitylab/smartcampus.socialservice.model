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

import java.io.StringWriter;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

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

	/**
	 * Convert to JSON format
	 * @param visibility
	 * @return JSON string
	 */
	public static String toJson(ShareVisibility visibility) {
		if (visibility == null) return null;
		try {
			StringWriter writer = new StringWriter();
			writer.write("{");
			writer.write(JSONObject.quote("allUsers") + ":"
					+ JsonUtils.toJson(visibility.isAllUsers()) + ",");
			writer.write(JSONObject.quote("allCommunities") + ":"
					+ JsonUtils.toJson(visibility.isAllCommunities()) + ",");
			writer.write(JSONObject.quote("allKnownUsers") + ":"
					+ JsonUtils.toJson(visibility.isAllKnownUsers()) + ",");
			writer.write(JSONObject.quote("allKnownCommunities") + ":"
					+ JsonUtils.toJson(visibility.isAllKnownCommunities()) + ",");
			writer.write(JSONObject.quote("userIds") + ":"
					+ JsonUtils.toJson(visibility.getUserIds()) + ",");
			writer.write(JSONObject.quote("communityIds") + ":"
					+ JsonUtils.toJson(visibility.getCommunityIds()) + ",");
			writer.write(JSONObject.quote("groupIds") + ":"
					+ JsonUtils.toJson(visibility.getGroupIds()));
			writer.write("}");
			return writer.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert JSON string to {@link ShareVisibility} object
	 * @param json
	 * @return
	 */
	public static ShareVisibility toObject(String json) {
		try {
			JSONObject object = new JSONObject(json);
			ShareVisibility e = new ShareVisibility();
			e.setAllCommunities(object.getBoolean("allCommunities"));
			e.setAllUsers(object.getBoolean("allUsers"));
			e.setAllKnownCommunities(object.getBoolean("allKnownCommunities"));
			e.setAllKnownUsers(object.getBoolean("allKnownUsers"));
			if (object.has("userIds")) {
				e.setUserIds(JsonUtils.convertJSONArray(object.getJSONArray("userIds"), String.class));
			}
			if (object.has("groupIds")) {
				e.setGroupIds(JsonUtils.convertJSONArray(object.getJSONArray("groupIds"), String.class));
			}
			if (object.has("communityIds")) {
				e.setUserIds(JsonUtils.convertJSONArray(object.getJSONArray("communityIds"), String.class));
			}
			return e;
		} catch (JSONException e) {
			return null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allCommunities ? 1231 : 1237);
		result = prime * result + (allKnownCommunities ? 1231 : 1237);
		result = prime * result + (allKnownUsers ? 1231 : 1237);
		result = prime * result + (allUsers ? 1231 : 1237);
		result = prime * result
				+ ((communityIds == null) ? 0 : communityIds.hashCode());
		result = prime * result
				+ ((groupIds == null) ? 0 : groupIds.hashCode());
		result = prime * result + ((userIds == null) ? 0 : userIds.hashCode());
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
		ShareVisibility other = (ShareVisibility) obj;
		if (allCommunities != other.allCommunities)
			return false;
		if (allKnownCommunities != other.allKnownCommunities)
			return false;
		if (allKnownUsers != other.allKnownUsers)
			return false;
		if (allUsers != other.allUsers)
			return false;
		if (communityIds == null) {
			if (other.communityIds != null)
				return false;
		} else if (!communityIds.equals(other.communityIds))
			return false;
		if (groupIds == null) {
			if (other.groupIds != null)
				return false;
		} else if (!groupIds.equals(other.groupIds))
			return false;
		if (userIds == null) {
			if (other.userIds != null)
				return false;
		} else if (!userIds.equals(other.userIds))
			return false;
		return true;
	}
}
