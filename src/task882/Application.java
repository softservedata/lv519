package task882;

public class Application {
	
    public static void main(String[] args) {
    	
        Operation operation = new Operation();
        Number number = Number.read();
        Number.write(operation.result(number));
        
    }
    
}
