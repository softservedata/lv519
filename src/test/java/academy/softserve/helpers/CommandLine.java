package academy.softserve.helpers;

import io.qameta.allure.Step;

import java.io.IOException;

public class CommandLine {
    public static void main(String[] args) {
        run( "NotePad");
    }


    @Step("Run command from windows cmd, flexible")
    public static void run(String command){
        try {
            Process cmd = Runtime.getRuntime().exec("cmd /c "+ command);
        } catch (IOException e) {
            System.out.print(String.format("ups run ", command, "manually"));
            e.printStackTrace();
        }
    }
    }

