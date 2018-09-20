package test;

public class Singleton {
	public static Singleton instance = new Singleton();
	private Singleton(){
		
	}
	public static  Singleton getInstanceMethod(){
		
		if(instance==null){
			synchronized (instance) {
				if(instance==null){
					instance = new Singleton();
				}
			}
			
		}
		return instance;
	}
	@Override
	public Singleton clone(){
		return getInstanceMethod();
		
	}
}
