package cipher;

public class Vigenere {

	private Utilities u;

	Vigenere() {
		u = new Utilities();
	}

	/**
	 * Encrypts the given text using the key.
	 * 
	 * @param text
	 *            The text to be encrypted.
	 * @param key
	 *            The key used to encrypt the given text.
	 * @return The encrypted text.
	 */
	public String encrypt(String text, String key) {
		String output = "";
		text = text.toLowerCase();
		key = key.toLowerCase();
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c < 'a' || c > 'z')
				continue;
			output += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}
		return output;
	}

	/**
	 * Decrypts the given text using the key.
	 * 
	 * @param text
	 *            The text to be decrypted.
	 * @param key
	 *            The key used to decrypt the text.
	 * @return The decrypted text.
	 */
	public String decrypt(String text, String key) {
		String output = "";
		text = u.cleanText(text);
		key = u.cleanText(key);
		for (int i = 0, j = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c < 'a' || c > 'z')
				continue;
			System.out.println(key);
			output += (char) ((c - key.charAt(j) + 26) % 26 + 'a');
			j = ++j % key.length();
		}
		return output;
	}
}
