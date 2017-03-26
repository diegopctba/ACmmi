/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.lista;

import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.modelo.ListaModelo;
import java.util.List;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa um modelo de lista de {@link AreaProcesso}
 * @author diego
 */
public class ListaAreaProcesso extends ListaModelo {

    private List<AreaProcesso> areaProcesso;

    public ListaAreaProcesso() {
    }

    public ListaAreaProcesso(List<AreaProcesso> areaProcesso) {
        this.areaProcesso = areaProcesso;
    }

    @Override
    public void setElementAt(Object objeto, int posicao) {
        areaProcesso.set(posicao, (AreaProcesso)objeto);
    }

    @Override
    public void addElement(Object objeto) {
        areaProcesso.add((AreaProcesso)objeto);
    }

    @Override
    public List<AreaProcesso> getList() {
        return areaProcesso;
    }

    @Override
    public void setList(List lista) {
        areaProcesso = lista;
    }

    @Override
    public int getSize() {
        int size = 0;
        if (areaProcesso != null) {
            size = areaProcesso.size();
        }
        return size;
    }

    @Override
    public AreaProcesso getElementAt(int arg0) {
        return (AreaProcesso) areaProcesso.get(arg0);
    }

    @Override
    public void removeElementAt(int arg0) {
        areaProcesso.remove(arg0);
    }

    @Override
    public void removeElement(Object area) {
        areaProcesso.remove((AreaProcesso)area);
    }


    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }

    public Integer getNumAreaProcesso(Integer posicao) {
        return areaProcesso.get(posicao).getNumareaprocesso();
    }

    public Integer getIdAreaProcesso(Integer posicao) {
        return areaProcesso.get(posicao).getIdareaprocesso();
    }

    public String getMaturidade(Integer posicao) {
        return areaProcesso.get(posicao).getIdmaturidade().toString();
    }

    public String getDescricao(Integer posicao) {
        return areaProcesso.get(posicao).getDescricao();
    }

    public String getTitulo(Integer posicao) {
        return areaProcesso.get(posicao).getTitulo();
    }

    public String getSigla(Integer posicao) {
        return areaProcesso.get(posicao).getSigla();
    }
}
