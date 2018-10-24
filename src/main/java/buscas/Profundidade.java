package buscas;

import estruturas.Pilha;
import grafocidades.Adjacente;
import grafocidades.Cidade;
import grafocidades.Mapa;

public class Profundidade {

    private Pilha fronteira;
    private Cidade inicio;
    private Cidade objetivo;
    private boolean achou;

    public Profundidade(Cidade inicio, Cidade objetivo) {
        this.inicio = inicio;
        this.inicio.setVisitado(true);
        this.objetivo = objetivo;

        fronteira = new Pilha(20);
        fronteira.empilhar(inicio);

    }


    public void buscar() {
        Cidade topo = fronteira.getTopo();
        System.out.println("Topo: " + topo.getName());

        if (topo == objetivo) {
            achou = true;
        } else {
            for (Adjacente a : topo.getAdjacentes()) {
                if (!achou) {
                    System.out.println("Verificando se ja visitado: " + a.getCidade().getName());

                    if (!a.getCidade().isVisitado()) {

                        a.getCidade().setVisitado(true);
                        fronteira.empilhar(a.getCidade());
                        buscar();
                    }
                }

            }
        }
        System.out.println("Desempilhou " + fronteira.desempilhar().getName());

    }

    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        Profundidade profundidade = new Profundidade(mapa.getPortoUniao(), mapa.getCuritiba());
        profundidade.buscar();
    }
}
