package com.compilation.tp_1;

public class PremierLangage {
    private final Langage langage;

    PremierLangage(String source){
        this.langage = new Langage(source);
    }
    /*
      Notre Grammaire: (**On veut arrêter quand on trouve pair_impair
      pair_pair => '0' impair_pair | '1' pair_impair;
      impair_pair => '0' pair_pair | '1' impair_impair;
      pair_impair => '0' impair_impair | '1' pair_pair | epsilon;
      impair_impair => '0' pair_impair | '1' impair_pair;
     */
    void start(){
        try {
            boolean result = pair_pair();
            if (result) {
                System.out.println("Ce mot appartient au langage");
                return;
            }
            throw langage.error("Le mot n'appartient pas au langage");

        } catch (LangageError error){
        }
    }
    private boolean pair_pair() {
        if (langage.match('0'))
            return impair_pair();
        if (langage.match('1'))
            return pair_impair();
        return false;
    }
    private boolean impair_pair(){
        if (langage.match('0'))
            return pair_pair();
        if (langage.match('1'))
            return impair_impair();
        return false;
    }
    private boolean pair_impair(){
        if (langage.match('0'))
            return impair_impair();
        if (langage.match('1'))
            return pair_pair();
        return true;
    }
    private boolean impair_impair(){
        if (langage.match('0'))
            return pair_impair();
        if (langage.match('1'))
            return impair_pair();
        return false;
    }


}
