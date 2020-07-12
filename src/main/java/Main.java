public class Main {
    public static void main(String[] args) {

        ConsoleInput input = new ConsoleInput();
        CombinationsPicker valuePicker = new CombinationsPicker();
        valuePicker.iSNaturalNum(input.intInput());
        valuePicker.displayOptions(true);
    }
}
