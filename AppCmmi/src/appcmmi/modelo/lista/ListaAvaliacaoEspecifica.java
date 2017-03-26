/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.lista;

import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import appcmmi.modelo.ListaModelo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa a utilização de uma lista de Avaliação, para utilização na interface
 * @author diego
 * @since 14/11/2009
 */
public class ListaAvaliacaoEspecifica extends ListaModelo {

    private List<AvaliacaoEspecifica> listaEspecifica;

    /**
     * Indica a Avaliação para a posição indicada.
     * @param objeto
     * @param posicao
     */
    @Override
    public void setElementAt(Object objeto, int posicao) {
        listaEspecifica.set(posicao, (AvaliacaoEspecifica) objeto);
    }

    /**
     * Adiciona a Avaliação na lista.
     * @param objeto
     */
    @Override
    public void addElement(Object objeto) {
        listaEspecifica.add((AvaliacaoEspecifica) objeto);
    }

    /**
     * Retorna a lista de Avaliações
     * @return List<Avaliacao>
     */
    @Override
    public List<AvaliacaoEspecifica> getList() {
        return (List<AvaliacaoEspecifica>) listaEspecifica;
    }

    /**
     * Adiciona uma nova lista de Avaliações
     * @param lista
     */
    @Override
    public void setList(List lista) {
        listaEspecifica = new ArrayList<AvaliacaoEspecifica>(lista);
    }

    /**
     * Remove a Avaliação da posição indicada
     * @param posicao
     */
    @Override
    public void removeElementAt(int posicao) {
        listaEspecifica.remove(posicao);
    }

    /**
     * Remove a Avaliação
     * @param objeto
     */
    @Override
    public void removeElement(Object objeto) {
        listaEspecifica.remove((AvaliacaoEspecifica) objeto);
    }

    /**
     * Retorna o tamanho da lista.
     * @return int
     */
    @Override
    public int getSize() {
        return listaEspecifica.size();
    }

    /**
     * Retorna a Avaliação da posição indicada.
     * @param arg0
     * @return AvaliacaoEspecifica
     */
    @Override
    public AvaliacaoEspecifica getElementAt(int arg0) {
        return (AvaliacaoEspecifica) listaEspecifica.get(arg0);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }

}
