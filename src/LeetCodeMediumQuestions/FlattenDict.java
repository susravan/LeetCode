package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.Map;

public class FlattenDict {
	public Map<String, String> flattenDict(Map<String, Object> dict) {
		Map<String, String> res = new HashMap<String, String>();
		for(String key : dict.keySet()) {
			if(dict.get(key) instanceof Map)
				res.putAll(flattenDictHelper(dict, key));
			else
				res.put(key, dict.get(key)+"");
		}
		return res;
	}
	
	private Map<String, String> flattenDictHelper(Map<String, Object> dict, String key) {
		Map<String, Object> currDict = (Map<String, Object>) dict.get(key);
		Map<String, String> res = new HashMap<>();
		
		for(String innerKey : currDict.keySet()) {
			if(currDict.get(innerKey) instanceof Map) {
				Map<String, String> map = flattenDictHelper(currDict, innerKey);
				for(String flatKey : map.keySet()) {
					res.put(key + "." + flatKey, map.get(flatKey));
				}
			}
			else
				res.put(key + "." + innerKey, currDict.get(innerKey)+"");
		}
		return res;
	}
}
