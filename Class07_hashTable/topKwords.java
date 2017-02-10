public class Solution {
    public static String[] topKFrequent(String[] combo, int k) {
        // Write your solution here.
        List<String> solu = new ArrayList<String>();
        if (combo == null || combo.length == 0){
            return solu.toArray(new String[0]);
        }
        // set value as Long type to handle large data
        HashMap<String, Long> map = new HashMap<String, Long>();
        for(String s: combo){
            Long count = map.get(s);
            // getValue then check
            if(count != null){
                map.put(s, count+1L);
            }
            else{
                map.put(s, 1L);
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<String>(k,
            new Comparator<String>(){
                public int compare(String one, String two){
                    // compare with frequency instead of string 
                    long count1 = map.get(one);
                    long count2 = map.get(two);
                    if (count1 == count2)
                        return 0;
                    return count1 > count2 ? 1:-1;
                }
            }
        );
        for(Map.Entry<String, Long> entry: map.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry.getKey());
            }
            else if (entry.getValue() > map.get(minHeap.peek())){
                minHeap.poll();
                minHeap.offer(entry.getKey());
            }
        }

        while(!minHeap.isEmpty()){
            solu.add(minHeap.poll());
        }
        // return array of words in ascending order
        Collections.reverse(solu);
        // convert list to Array
        return solu.toArray(new String[0]);
    }
}
