package com.compilation.tp_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TpCompilation {
    public static void main(String[] args) throws IOException {
        try {
            run_prompt();
        }catch (IOException error){
            System.out.println(error.getMessage());
        }
    }

    private static void run_prompt() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Veuillez choisir votre langue (\"L1\" ou \"L2\")");
        String type_langage = input.nextLine().toLowerCase();
        if (type_langage.equals("l1")){
            run_prompt_langage1();
        } else if (type_langage.equals("l2")) {
            run_prompt_langage2();
        }else {
            erreur("langage inconnu");
            run_prompt();
        }
    }
    private static void run_prompt_langage1() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print(">> ");
            run_langage1(reader.readLine());
        }
    }
    private static void run_langage1(String source){
        PremierLangage langage = new PremierLangage(source);
        langage.start();
    }
    private static void run_prompt_langage2() throws IOException{
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print(">> ");
            run_langage2(reader.readLine());
        }
    }
    private static void run_langage2(String source){
        DeuxiemeLangage langage = new DeuxiemeLangage(source);
        langage.start();
    }

    static void erreur(String message){
        System.out.println("Erreur : "+ message);
    }

}
