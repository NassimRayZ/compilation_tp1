package com.compilation.tp_1;

public class DeuxiemeLangage {
    private final Langage langage;
    DeuxiemeLangage(String source){
        this.langage = new Langage(source);
    }
    /*
      Notre Grammaire: (**On veut construire un langage qui ne contient pas la série '001'
                          c-à-d que zero_zero a une seule transition**)
      init => '0' zero | '1' un | epsilon;
      zero => '0' zero_zero | '1' un | epsilon;
      un => '0' zero | '1' un | epsilon;
      zero_zero => '0' zero_zero| epsilon;

     */
    void start(){
        try {
            boolean result = init();
            if (result) {
                System.out.println("Ce mot appartient au langage");
                return;
            }
            throw langage.error("Le mot n'appartient pas au langage");

        } catch (LangageError error){
        }
    }
    private boolean init(){
        if (langage.match('0'))
            return zero();
        if (langage.match('1'))
            return un();
        return true;
    }
    private boolean zero(){
        if (langage.match('0'))
            return zero_zero();
        if (langage.match('1'))
            return un();
        return true;
    }
    private boolean un(){
        if (langage.match('0'))
            return zero();
        if (langage.match('1'))
            return un();
        return true;
    }
    private boolean zero_zero(){
        if (langage.match('0'))
            return zero_zero();
        return !langage.match('1');
    }
}
