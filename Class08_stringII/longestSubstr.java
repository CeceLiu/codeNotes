public class Solution {
  public int longest(String input) {
    // Use two point slow/fast and [s,f] as the sliding window
    // use a HashMap to store the information about the sliding window
    // Move f: when there is no duplicate letters in the sliding window, increment A[f]'s value
    // Move s: when there is duplicate letters keep moving s and decrement A[s]'s value

    if(input == null || input.length() <1)
      return 0;
    // Map<Character, Integer> map = new HashMap<Character, Integer>();
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int longest = 0;
    int s = 0;
    for(int f=0; f<input.length(); f++){
      char key = input.charAt(f);
      if(map.containsKey(key)){
        map.put(key, map.get(key)+1);
      }
      else{
        map.put(key, 1);
      }
      if (map.get(key) >1){
        while(map.get(key) >1){
          int currVal = map.get(input.charAt(s));
          map.put(input.charAt(s), currVal-1);
          s++;
        }
      }
      else
        longest = f-s+1 > longest ? f-s+1 : longest;
      }
    return longest;
  }
}
