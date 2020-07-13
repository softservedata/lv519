public class Main {
    public static void main(String[] args) {

        ConsoleInputOutput in = new ConsoleInputOutput();
        PythagoreanTriple calc = new PythagoreanTriple();
        in.printValues(calc.findAllOptions(in.intInput()));
    }

}
