package lfaAT7;

public class Main {
    public static void main(String[] args) {
        int[] F = { 4 };

        String[][] delta = {
            { "0", "E", "Z0", "1", "Z0" },
            { "1", "E", "Z0", "2", "Z0" },
            { "2", "E", "Z0", "3", "Z0" },
            { "3", "E", "Z0", "4", "E" },
            { "1", "E", "programa", "1", "id(<declaracao>) <comandos>" },
            { "1", "E", "<comandos>", "1", "<comando> <comandos>" },
            { "1", "E", "<comandos>", "1", "<comando>" },
            { "1", "E", "<comando>", "1", "<declaracoes>" },
            { "1", "E", "<comando>", "1", "if" },
            { "1", "E", "<comando>", "1", "return" },
            { "1", "E", "<comando>", "1", "<atribuicao>" },
            { "1", "E", "<declaracoes>", "1", "id : <tipo>" },
            { "1", "E", "<tipo>", "1", "char" },
            { "1", "E", "<tipo>", "1", "int" },
            { "1", "E", "<tipo>", "1", "vetor" },
            { "1", "E", "if", "1", "if (<expressao>) { <comandos> } else { <comandos> }" },
            { "1", "E", "<expressao>", "1", "id <op> <constante>" }
        };

        Pilha p = new Pilha();
        p.empilha("Z0");
        int estado = 0;
        String entrada = "programa id(id: int){ id: int; if (id > 0){ id = id / 2; } else{ id = 0; } return id;";
        int i = 0;

        while (i < entrada.length()) {
            System.out.println(p);
            String trans = null;
            for (String[] d : delta) {
                if (d[0].equals(Integer.toString(estado)) && d[1].equals(Character.toString(entrada.charAt(i))) && d[2].equals(p.getTopo())) {
                    trans = d[3];
                    break;
                }
            }
            if (trans == null) {
                break;
            }
            estado = Integer.parseInt(trans);
            p.desempilha();
            if (!trans.equals("E")) {
                String[] elementos = trans.split(" ");
                for (int j = elementos.length - 1; j >= 0; j--) {
                    p.empilha(elementos[j]);
                }
            }
            i++;
        }

        if (contains(F, estado) && p.estaVazia()) {
            System.out.println("\nLinguagem Negada");
        } else {
            System.out.println("\nLinguagem Aceita");
        }
    }

    public static boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
