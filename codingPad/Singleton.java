package codingPad;

public class Singleton {

	private static Singleton _instance;
	
	private Singleton() { }
	
	public static Singleton getInstance() {
		if (_instance == null) {
			_instance = new Singleton();
		}
		return _instance;
	}
	
}
