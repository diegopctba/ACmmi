/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.lista;

import appcmmi.db.pojo.avaliacao.StatusInstitucionalizacao;
import appcmmi.modelo.ListaModelo;
import java.util.List;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa uma lista modelo para utilização de objetos Status na interface.
 * @author diego
 * @since 14/11/2009
 */
public class ListaStatusInstitucionalizacao extends ListaModelo {

    private List<StatusInstitucionalizacao> listaStatus;

    /**
     * Indica o Status para a posição indicada.
     * @param objeto
     * @param posicao
     */
    @Override
    public void setElementAt(Object objeto, int posicao) {
        listaStatus.set(posicao, (StatusInstitucionalizacao)objeto);
    }

    /**
     * Adiciona Status na lista.
     * @param objeto
     */
    @Override
    public void addElement(Object objeto) {
        listaStatus.add((StatusInstitucionalizacao) objeto);
    }

    /**
     * Retorna a lista de Status.
     * @return List
     */
    @Override
    public List getList() {
        return listaStatus;
    }

    /**
     * Insere uma lista de Status
     * @param lista
     */
    @Override
    public void setList(List lista) {
        listaStatus = lista;
    }

    /**
     * Remove o Status da posição indicada.
     * @param posicao
     */
    @Override
    public void removeElementAt(int posicao) {
        listaStatus.remove(posicao);
    }

    /**
     * Remove o Status da lista.
     * @param objeto
     */
    @Override
    public void removeElement(Object objeto) {
        listaStatus.remove((StatusInstitucionalizacao) objeto);
    }

    /**
     * Retorna o tamanho da lista.
     * @return int
     */
    @Override
    public int getSize() {
        return listaStatus.size();
    }

    /**
     * Retorna o Status da posição indicada.
     * @param arg0
     * @return Object
     */
    @Override
    public Object getElementAt(int arg0) {
        return (StatusInstitucionalizacao) listaStatus.get(arg0);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }
}
