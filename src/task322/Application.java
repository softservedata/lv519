package task322;

public class Application {
    public static void main(String[] args) {
        DataOperation operation = new DataOperation();
        Value value = Value.read();
        Value.print(operation.search(operation.checkValue(value)));
    }
}
