package grafocidades;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private String name;
    private boolean visitado;
    private List<Adjacente> adjacentes;


    public Cidade(String name) {
        this.name = name;
        visitado = false;
        adjacentes = new ArrayList<Adjacente>();
    }

    public void addCidadeAdjacente(Adjacente cidade){

        adjacentes.add(cidade);
    }


    public String getName() {
        return name;
    }

    public void setName(String name1) {
        this.name = name1;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }


    public List<Adjacente> getAdjacentes() {
        return adjacentes;
    }
}
