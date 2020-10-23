package cypher;

public class Encrypter {
	public String encrypt(String message, int offset) {

		if(message.length() == 1) {
			return offset(message.charAt(0), offset);
		}

		if(message.length() == 2) {
			return offset(message.charAt(0), offset)
					+ offset(message.charAt(1), offset);
		}
		return "A";

	}

	private String offset(char character, int offset) {
		int i = (character + offset) % 26 + 52;
		return String.valueOf((char) (i));
	}

}
