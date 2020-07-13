public class Main {
    public static void main(String[] args) {

        ConsoleInputOutput inputOutout = new ConsoleInputOutput();
        CombinationsPicker valuePicker = new CombinationsPicker();
        inputOutout.printCombinations(valuePicker.findCombinations(inputOutout.intInput(),false));
    }
}
