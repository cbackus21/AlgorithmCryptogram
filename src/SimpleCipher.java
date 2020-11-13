import java.util.AbstractMap;

public class SimpleCipher {
	private AbstractMap<Character, Character> cipher;
	private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	public SimpleCipher() {
		for (Character c1: alphabet.toCharArray()) {
			cipher.put(c1, c1);
		}
	}
	
	public void editCipher(char , char d) {
		
	}
}
