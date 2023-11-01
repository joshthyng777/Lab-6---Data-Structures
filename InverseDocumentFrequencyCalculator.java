package Lab6;

import java.util.TreeMap;
import java.lang.Math;

public class InverseDocumentFrequencyCalculator implements IInverseFreq {

    @Override
    public TreeMap<String, Double> getInverseDocumentFrequency(TreeMap<String, String> songLyrics) {
        
    	TreeMap<String, Double> result = new TreeMap<String, Double> ();
    	
    	int numContains = 0;
    	
    	int numSongs = numSongs(songLyrics);
    	
    	int i = 0;
    	
    	double equation = 0;
        
        for(String songTitle: songLyrics.keySet())
        {
            // current lyrics
            String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            
            // Calculate the Inverse Document Frequency (IDF) Values here
            // You might need to introduce other methods and additional variables
            
            // IDF for term X is calculated as ln of (N-n(X)+0.5)/(n(X)+0.5) plus 1
            // where N is total number of songs
            // and n(X) is the number of songs having term X
            
            numContains = containsLyric(songLyrics, words[i]);
            
            equation = Math.log((numSongs-numContains+0.5)/(numContains+0.5) + 1);
            
            
            result.put(words[i],equation);
            
            
            i++;
        }
        
        return result;
    }
    
    public int containsLyric(TreeMap<String, String> songLyrics, String word){
    	
    	int number = 0;
    	
    	for(String songTitle: songLyrics.keySet()) {
    		
    		String lyric = songLyrics.get(songTitle);
    		
    		if(lyric.contains(word)) {
    			number++;
    		}
    		
    		
    	}
    	
    	
    	return number;
    }
    
    public int numSongs(TreeMap<String, String> songLyrics){
    	
    	int number = 0;
    	
    		for(String songTitle: songLyrics.keySet()) {
    		
    			number++;
    			
    		}
    	
    		return number;
    }
    
    
}
