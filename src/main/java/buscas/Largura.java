package buscas;

import estruturas.Fila;
import grafocidades.Adjacente;
import grafocidades.Cidade;

public class Largura {


    private Fila fronteira;
    private Cidade inicio;
    private Cidade objetivo;

    public Largura(Cidade inicio, Cidade objetivo) {
        this.inicio = inicio;
        this.inicio.setVisitado(true);
        this.objetivo = objetivo;

        fronteira = new Fila(20);
        fronteira.enfileirar(inicio);
    }


    public void buscar() {
        Cidade primeiro = fronteira.getPrimeiro();
        System.out.println("Primeiro; " + primeiro.getName());

        System.out.println("Desenfileirou: " + fronteira.desenfileirar().getName());

        for (Adjacente a : primeiro.getAdjacentes()) {
            System.out.println("Verificando se já visitado: " + a.getCidade().getName());
            if (!a.getCidade().isVisitado()) {

                a.getCidade().setVisitado(true);
                fronteira.enfileirar(a.getCidade());

            }

        }

        if (fronteira.getNumeroElementos() > 0) {
            buscar();
        }
    }


    public static void main(String[] args) {
        
    }

}
