/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.lista;

import appcmmi.modelo.*;
import appcmmi.db.pojo.modelo.Maturidade;
import java.util.List;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa um modelo de lista de {@link Maturidade}
 * @author diego
 */
public class ListaMaturidade extends ListaModelo {

    private List<Maturidade> maturidade;


    public ListaMaturidade() {
    }

    public ListaMaturidade(List<Maturidade> maturidade) {
        this.maturidade = maturidade;
    }

    /**
     * Retorna o tamanho da lista
     * @return
     */
    @Override
    public int getSize() {
        int size = 0;
        if (maturidade != null) {
            size = maturidade.size();
        }
        return size;
    }

    /**
     * Retorna o objeto de uma determinada posição da lista
     * @param arg0
     * @return Maturidade
     */
    @Override
    public Maturidade getElementAt(int arg0) {
        return (Maturidade)maturidade.get(arg0);
    }

    /**
     * Insere um objeto numa determinada posição
     * @param objeto
     * @param posicao
     */
    @Override
    public void setElementAt(Object objeto, int posicao) {
        this.maturidade.add(posicao, (Maturidade) objeto);
    }

    /**
     * Insere um novo objeto ao final da lista
     * @param objeto
     */
    @Override
    public void addElement(Object objeto) {
        this.maturidade.add((Maturidade) objeto);
    }

    @Override
    public void removeElementAt(int posicao) {
        this.maturidade.remove(posicao);
    }

    @Override
    public void removeElement(Object objeto) {
        this.maturidade.remove((Maturidade)objeto);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }

    /**
     * Retorna a lista completa dos objetos.
     * @return List
     */
    @Override
    public List<Maturidade> getList() {
        return this.maturidade;
    }

    /**
     * Seta a lista com os valores passados no parâmetro
     * @param lista
     */
    @Override
    public void setList(List lista) {
        maturidade = lista;
    }
    
    /**
     * Retorna o ID da Maturidade de uma determinada posição
     * @param posicao
     * @return Integer
     */
    public Integer getNumMaturidade(int posicao) {
        return maturidade.get(posicao).getNummaturidade();
    }

    public String getTitulo(int posicao) {
        return maturidade.get(posicao).getTitulo();
    }

    /**
     * Retorna a Descrição da Maturidade de uma determinada posição
     * @param posicao
     * @return String
     */
    public String getDescricao(int posicao) {
        return maturidade.get(posicao).getDescricao();
    }
    
    public Integer getIdMaturidade(int posicao) {
        return maturidade.get(posicao).getIdmaturidade();
    }
}

