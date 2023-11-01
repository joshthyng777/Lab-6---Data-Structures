package Lab6;

import java.util.TreeMap;

public class TermFrequencyCalculator implements ITermFrequency {

	@Override
    public TreeMap<String, TreeMap<String, Double>> getTermFrequency(TreeMap<String, String> songLyrics) {
        TreeMap<String, TreeMap<String, Double>> result = new TreeMap<String, TreeMap<String, Double>> ();
        
        // Finding the avgS
        double totalWords = 0;
        double numSongs = songLyrics.keySet().size();
        for(String songTitle: songLyrics.keySet()) {
        	String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            totalWords += words.length;
        }
        double avgS = totalWords/numSongs;
        for(String songTitle: songLyrics.keySet())
        {
            // For each song you have to create TF values
            TreeMap<String, Double> tempMap = new TreeMap<String, Double>();

            // current lyrics
            String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            
            // Calculate the Term Frequency (TF) Values here and save them in tempMap
            
            // You might need to introduce other methods and additional variables
            
            // TF for Term (word) X in Song S is calculated as 
            // f(X,S) . (2.2) / (f(X,S) + 1.2 . (0.25+0.75 .|S|/AvgS)
            // where f(X,S) is the frequency of term X in song S
            // |S| is the length of song in terms of number of words
            // AvgS is the average length of songs based on number of words
            
            ////////////////////////////
            //WRITE HERE
            for(String word: words) {
            	if(tempMap.containsKey(word)) {
            		tempMap.put(word, tempMap.get(word)+1);
            	}else {
            		tempMap.put(word, 1.0);
            	}
            }
            for(String key:tempMap.keySet()) {
            	double TF = (tempMap.get(key)*2.2)/
            			(tempMap.get(key)+(0.25+0.75*(words.length/avgS)));
            	tempMap.put(key, TF);
            }
            //////////////////////////
            
            
            // After Calculaion
            result.put(songTitle, tempMap);
        }
        
        return result;
    }

}
