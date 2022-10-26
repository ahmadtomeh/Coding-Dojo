import java.util.HashMap;
import java.util.Set;
public class HashMapSong {
    public static void main(String[] args) {
        HashMap<String, String> songMap = new HashMap<String, String>();
        songMap.put("a", "aa");
        songMap.put("b", "bb");
        songMap.put("c", "cc");
        songMap.put("d", "dd");

        Set<String> keys = songMap.keySet();
        String SongOne = songMap.get("c");
        System.out.println(SongOne);
        for(String key : keys) {
            System.out.print(key);
            System.out.println(" : "+songMap.get(key));    
        }
    }
}