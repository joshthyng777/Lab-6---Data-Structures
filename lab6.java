/*
 * Lab 6 
 * Josh Thyng - Main Method
 * Searches for "All we hear is" in the searchEngine
 */

public class lab6 {

    public static void main(String[] args) {
        LyricsReader lyricReader = new LyricsReader();
        TermFrequencyCalculator tfCalc = new TermFrequencyCalculator();
        InverseDocumentFrequencyCalculator idfCalc = new InverseDocumentFrequencyCalculator();
        
        SearchEngine searchEngine = new SearchEngine(lyricReader, tfCalc, idfCalc);
        String results = searchEngine.search("All we hear is");
        System.out.println(results);
    }
}