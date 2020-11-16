import java.util.Comparator;
import java.util.HashMap;

public class SimpleCipher {
	private HashMap<Character, Character> cipher;
	private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public SimpleCipher() {
		cipher = new HashMap<Character, Character>();
		for (int i = 0; i < 26; i++) {
			cipher.put(alphabet.charAt(i), alphabet.charAt(i));
		}
	}
	
	private HashMap<Character, Character> getCipher() {
		return this.cipher;
	}
	
	public boolean setCipher(String inputWord, String testWord) {
		char[] input = inputWord.toCharArray();
		char[] test = testWord.toCharArray();
		char[] valuesMapped = new char[26];
		HashMap<Character, Character> valuesMappedTo = new HashMap<Character, Character>();
		char[] keysMapped = new char[inputWord.length()];
		for (int i = 0; i < inputWord.length(); i++) {
			if (input[i] == ' ') {
				continue;
			}
			for (char c: valuesMapped) {
			    if (test[i] == c && input[i] != valuesMappedTo.get(c)) {
			        return false;
			    }
			}
			for (char d: keysMapped) {
				if (input[i] == d && test[i] != cipher.get(d)) {
					return false;
				}
			}
			cipher.put(input[i], test[i]);
			keysMapped[i] = input[i];
			valuesMapped[i] = test[i];
			valuesMappedTo.put(test[i], input[i]);
		}
		return true;
	}
}


