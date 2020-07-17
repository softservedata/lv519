public class Main {
    public static void main(String[] args) {

        ConsoleInputOutput inputOutout = new ConsoleInputOutput();

        inputOutout.printCombinations(new CombinationsPicker().findCombinations(inputOutout.intInput(),false));


    }
}
