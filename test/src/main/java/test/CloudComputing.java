package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class CloudComputing {
	public boolean isSubset(String SuperSet, String subSet){
		if(SuperSet.length()<subSet.length()){
			return false;
		}
		for(int i = 0 ; i  < subSet.length() ; i ++){
			String c = String.valueOf(subSet.charAt(i));
			if(SuperSet.contains(c)){
				SuperSet=SuperSet.replaceFirst(c, "");
			}else {
				return false;
			}
		}
		return true;
	}
	
	public Map<Integer,Set<String>> getCubedTriplets(int n){
		Map<Integer,Set<String>> pairs = new HashMap<Integer,Set<String>>();
		if(n<4){
			return pairs;
		}
		for(int i=1 ; i <= n-2 ; i ++){
			for(int j = i+1; j <=n-1 ; j ++){
				for(int k = j+1 ; k <= n ;k ++){
					int key = i*i*i + j*j*j + k*k*k;
					Set<String> list = pairs.get(key);
					if(list==null){
						list = new HashSet<String>();
						pairs.put(key, list);
					}
					list.add(i +","+j+","+k);
				}
			}
		}
		
		return pairs;
	}
	
	public List<Integer> sumOfNumbers(int[] array, int sum){
		List<Integer> integer = new ArrayList<Integer>();
		if(sum==0 || array.length <3){
			return integer;
		}
		Arrays.sort(array);
		
		for(int i = 0 ,  j = array.length-1 ; i < array.length && j >= 0 ; ){
			if((array[i]+array[j])<sum){
				i++;
			}else if((array[i]+array[j])>sum){
				j--;
			}else{
				integer.add(array[i]);
				integer.add(array[j]);
				break;
			}
		}
		return integer;
	}
	

	public static void main(String args[]){
		CloudComputing cc = new CloudComputing();
		int[] integers = {2,4,6,5,7,8};
		System.out.println(cc.sumOfNumbers(integers, 13));
		StringBuilder sb = new StringBuilder();
		int max = cc.longestCommonSequence( "ABCDEFGHIPRLT".split(""), "ACDFHKBPL".split(""), "ABCDEFGHIPRLT".length()+1, "ACDFHKBPL".length()+1);
		System.out.println(max + "," + sb.toString());
		
		System.out.println(cc.isSubset("aabcdefg", "aabcde"));
		Map<Integer,Set<String>> map = cc.getCubedTriplets(10);
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			Set<String> values = map.get(key);
			if(values.size()>1){
				System.out.println(key+""+values);
			}
		}
	}
	//ABCDEFGHIPRLT
	//ACDFHKBPL
	//ACDFH
	
	public int longestCommonSequence(String[] array1, String[] array2, int i1, int i2){
		if(prechecks(i1,i2)){
			return 0;
		}
		if(array1[i1-1].equals(array2[i2-1])){
			return 1 + longestCommonSequence(array1,array2,i1-1,i2-1);
		}else{
			return Math.max(longestCommonSequence(array1,array2,i1-1,i2),longestCommonSequence(array1,array2,i1,i2-1));
		}
		
	}

	private boolean prechecks(int i1, int i2) {
		if(i1==1||i2==1){
			return true;
		}
		return false;
	}
	
	
}
