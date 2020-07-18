public class Main {
    public static void main(String[] args) {
        ConsoleIO in = new ConsoleIO();
        in.printValues(new PythagoreanTriple().
                            findAllOptions(
                                    in.intInput()));
    }

}
