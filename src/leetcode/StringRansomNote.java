package leetcode;
import java.util.HashMap;
import java.util.Map;

public class StringRansomNote {

	public boolean RansomNote(String ransomNote, String magazine) {
		Map<Character,Integer>map = new HashMap<Character,Integer>();
		for (int i=0;i<magazine.length();i++) {
            Character key = magazine.charAt(i);
			Integer value = map.get(key);
			if (value==null) {
				map.put(key,1);
			    continue;
            }
            map.put(key,++value);
		}
		for (int j=0;j<ransomNote.length();j++) {
            Character key = ransomNote.charAt(j);
			Integer value = map.get(key);
			if (value==null||value<=0){
				return false;
			}
			map.put(key,--value);
		}
		return true;
	}
//Given an arbitrary ransom note string and another string containing letters from all the magazines
//write a function that will return true if the ransom note can be constructed from the magazines	
//canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true
	
//note: key should be converted to Character from char, value should be Integer not int
//use map to store character and its occurrence in magazine and increase when traversing ransomnote
}
