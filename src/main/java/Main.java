public class Main {
    public static void main(String[] args) {

        ConsoleIO inputOutout = new ConsoleIO();

        inputOutout.printCombinations(new CombinationsPicker().findCombinations(inputOutout.intInput(),false));


    }
}
