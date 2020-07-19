package task332;

public class Application {
    public static void main(String[] args) {
        DataOperation operation = new DataOperation();
        Number number = Number.read();
        Number.print(operation.search(operation.checkNumber(number)));
    }
}
