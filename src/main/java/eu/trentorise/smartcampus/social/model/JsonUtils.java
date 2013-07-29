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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author mirko perillo
 * 
 */
public class JsonUtils {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static final Set<Class> WRAPPER_TYPES = new HashSet<Class>(
			Arrays.asList(Boolean.class, Character.class, Byte.class,
					Short.class, Integer.class, Long.class, Float.class,
					Double.class, Void.class));

	@SuppressWarnings("rawtypes")
	private static boolean isWrapperType(Class clazz) {
		return WRAPPER_TYPES.contains(clazz);
	}

	/**
	 * Convert {@link JSONArray} containing strings to
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> convertJSONArray(JSONArray arr, Class<T> t) {
		List<T> relations = new ArrayList<T>();
		try {
			for (int i = 0; i < arr.length(); i++) {
				relations.add((T)arr.get(i));
			}
		} catch(Exception e) {
			return Collections.emptyList();
		} 
		return relations;
	}
	
	/**
	 * Convert an (standard Java) object to JSON format
	 * @param o
	 * @return
	 */
	public static String toJson(Object o) {
		String result = "";
		if (o == null) {
			return null;
		}
		if (o instanceof Collection<?>) {
			Iterator<?> iter = ((Collection) o).iterator();
			boolean isFirst = true;
			result += "[";
			while (iter.hasNext()) {
				if (!isFirst) {
					result += ",";
				}
				result += toJson(iter.next());
				isFirst = false;
			}
			result += "]";
			return result;
		}
		if (o.getClass().isArray()) {
			boolean isFirst = true;
			result += "[";
			for (Object element : (Object[]) o) {
				if (!isFirst) {
					result += ",";
				}
				result += toJson(element);
				isFirst = false;
			}
			result += "]";
			return result;
		}
		if (o instanceof String) {
			return JSONObject.quote((String) o);
		} else if (o.getClass().isPrimitive() || isWrapperType(o.getClass())) {
			return o.toString();
		} else {
			try {
				return (String) o.getClass().getMethod("toJson", o.getClass())
						.invoke(null, o);
			} catch (Exception e) {
				throw new IllegalArgumentException(o.getClass().getName()
						+ " MUST declare toJson method");
			}
		}
	}
}
