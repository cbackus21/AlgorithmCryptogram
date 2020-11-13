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
	
	public void setCipher(String inputWord, String testWord) throws ValueAlreadyMappedException, KeyAlreadyMappedException {
		char[] input = inputWord.toCharArray();
		char[] test = testWord.toCharArray();
		char[] valuesMapped = new char[26]; 
		char[] keysMapped = new char[inputWord.length()];
		for (int i = 0; i < inputWord.length(); i++) {
			/*
			for (char c: valuesMapped) {
				if (test[i] == c && input[i) {
					throw new ValueAlreadyMappedException();
				}
			}
			*/
			for (char d: keysMapped) {
				if (input[i] == d && test[i] != cipher.get(d)) {
					throw new KeyAlreadyMappedException();
				}
			}
			cipher.put(input[i], test[i]);
			keysMapped[i] = input[i];
			valuesMapped[i] = test[i];
		}
	}
	
	public String decode(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			chars[i] = cipher.get(chars[i]);
		}
		s = String.valueOf(chars);
		return s;
	}
}

class ValueAlreadyMappedException extends RuntimeException {
	public ValueAlreadyMappedException() {
		super();
	}
}

class KeyAlreadyMappedException extends RuntimeException {
	public KeyAlreadyMappedException() {
		super();
	}
}
