import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
	private String sentence;
	private int sentenceLength;
	private ArrayList<String> words;
	private ArrayList<CrypticWord> undecodedWords;
	private ArrayList<String> results;
	private ArrayList<ArrayList<String>> dictionary;
	
	public Sentence(String s, ArrayList<ArrayList<String>> d) {
		this.sentence = s;
		this.words = new ArrayList<String>(Arrays.asList(s.split(" ")));
		this.sentenceLength = words.size();
		this.dictionary = d;
		this.undecodedWords = new ArrayList<CrypticWord>();
		this.results = new ArrayList<String>();
		for (String word : words) {
			this.undecodedWords.add(new CrypticWord(word, dictionary.get(word.length()-1)));
		}
	}
	
	public ArrayList<ArrayList<String>> makeSentenceCandidates() {
		ArrayList<ArrayList<String>> comboSentences = new ArrayList<ArrayList<String>>();
		for (CrypticWord cw : undecodedWords) {
			comboSentences.add(cw.getWordCandidates());
		}
		return comboSentences;	
	}
	
	public void processSentenceCandidates(ArrayList<ArrayList<String>> sentences, ArrayList<String> results, int level, String current) {
		if (level == sentences.size()) {
			results.add(current);
			return;
		}
		else {
			for (int i = 0; i < sentences.get(level).size(); i++) {
				processSentenceCandidates(sentences, results, level + 1, current + sentences.get(level).get(i) + " ");
			}
		}
	}
	
	public String getSentence() {
		return this.sentence;
	}
	
	public ArrayList<String> getResults() {
		return this.results;
	}
}
