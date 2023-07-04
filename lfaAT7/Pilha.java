package lfaAT7;
import java.util.Stack;

public class Pilha {
    private Stack<String> pilha;

    public Pilha() {
        pilha = new Stack<>();
    }

    public void empilha(String elemento) {
        pilha.push(elemento);
    }

    public void desempilha() {
        if (!estaVazia()) {
            pilha.pop();
        }
    }

    public String getTopo() {
        if (!estaVazia()) {
            return pilha.peek();
        }
        return null;
    }

    public boolean estaVazia() {
        return pilha.empty();
    }

    @Override
    public String toString() {
        return String.join(" ", pilha);
    }
}