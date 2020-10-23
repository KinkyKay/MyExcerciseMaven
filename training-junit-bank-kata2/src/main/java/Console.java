public interface Console {
	void print(String s);

	static Console standardConsole(){
		return message -> System.out.println(message);
	}
}
