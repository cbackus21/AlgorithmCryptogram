import java.util.HashMap;

public class SimpleCipher {
	private HashMap<Character, Character> cipher;
	private final String Alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public SimpleCipher() {
	    char[] alphabet = Alphabet.toCharArray();
		for (int i = 0; i < 26; i++) {
			cipher.put(alphabet[i], alphabet[i]);
		}
	}
	
	public void setCipher(String inputWord, String testWord) throws ValueAlreadyMappedException {
		char[] input = inputWord.toCharArray();
		char[] test = testWord.toCharArray();
		char[] valuesMapped = {};
		for (int i = 0; i < inputWord.length(); i++) {
			for (char c: valuesMapped) {
				if (test[i] == c) {
					throw new ValueAlreadyMappedException();
				}
			}
			cipher.put(input[i], test[i]);
			valuesMapped[i] = test[i];
		}
	}
	
	public String decode(String s) {
		char[] chars = s.toCharArray();
		for (char c : chars) {
			c = cipher.get(c);
		}
		s = chars.toString();
		return s;
	}
}

class ValueAlreadyMappedException extends RuntimeException {
	
	public ValueAlreadyMappedException() {
		super();
	}
}
