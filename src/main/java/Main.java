public class Main {
    public static void main(String[] args) {
        ConsoleInput in = new ConsoleInput();
        Pyth calc = new Pyth();
        in.printValues(calc.iSNaturalNum(in.intInput()));
    }
}
