package supermarket;

public class Client {

	static String IP;

	public static void main(String[] args) {
		IP = args[0] + ":43";
		new CFront();
	}
}