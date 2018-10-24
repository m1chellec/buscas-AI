package estruturas;

import grafocidades.Cidade;
import grafocidades.Mapa;

public class Pilha {

    private int tamanho;
    private Cidade[] cidades;
    private int topo;


    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        cidades = new Cidade[this.tamanho];
        topo = -1;
    }

    public void empilhar(Cidade cidade) {
        if (!pilhaCheia()) {
            this.cidades[++topo] = cidade;

        } else {
            System.out.println("A pilha ja esta cheia!");
        }
    }

    public Cidade desempilhar() {
        if (!pilhaVazia()) {
            return cidades[topo--];
        } else {
            System.out.println("A pilha esta vazia!");
            return null;
        }

    }

    public Cidade getTopo() {
        return cidades[topo];
    }


    private boolean pilhaVazia() {
        return (topo == -1);

    }

    private boolean pilhaCheia() {
        return (topo == tamanho - 1);
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        Mapa mapa = new Mapa();

        pilha.empilhar(mapa.getPortoUniao());
        pilha.empilhar(mapa.getCampoLargo());
        pilha.empilhar(mapa.getCanoinhas());

        System.out.println(pilha.getTopo().getName());

        pilha.desempilhar();

        System.out.println(pilha.getTopo().getName());
    }
}
