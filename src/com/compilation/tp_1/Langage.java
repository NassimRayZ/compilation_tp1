package com.compilation.tp_1;

public class Langage {
    private final String source;
    private int current = 0;

    Langage(String source){
        this.source = source;
    }
    boolean match(char expected) throws LangageError{
        if (!is_allowed()) throw error("le caractère '"+peek()+"' n'est pas autorisé");
        if (is_at_end()) return false;
        if (source.charAt(current) != expected) return false;
        current++;
        return true;
    }
    boolean is_allowed(){
        return (is_at_end() || (peek() == '1') || (peek() == '0'));
    }
    boolean is_at_end() {
        return current >= source.length();
    }
    char peek(){
        return source.charAt(current);
    }
    LangageError error(String message){
        TpCompilation.erreur(message);
        throw new LangageError();
    }

}
