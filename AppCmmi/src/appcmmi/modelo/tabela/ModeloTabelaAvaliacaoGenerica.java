/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.tabela;

import appcmmi.db.pojo.avaliacao.StatusDefinicao;
import appcmmi.db.pojo.avaliacao.StatusComentario;
import appcmmi.db.pojo.avaliacao.StatusInstitucionalizacao;
import appcmmi.modelo.lista.ListaAvaliacaoGenerica;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Implementação de lista de Avaliação de práticas genéricas para utilização em tabelas
 * @author diego
 * @since 14/11/2009
 */
public class ModeloTabelaAvaliacaoGenerica extends ListaAvaliacaoGenerica implements TableModel {

    private boolean institucionalizacao;
    private boolean definicao;
    private String[] colunas = {"Prática", "Definição", "Institucionalização", "Comentários", "Tipo", "Artefatos"};

    public ModeloTabelaAvaliacaoGenerica(boolean definicao, boolean institucionalizacao) {
        this.institucionalizacao = institucionalizacao;
        this.definicao = definicao;
        if (definicao && institucionalizacao) {
            colunas = new String[6];
            colunas[0] = "Prática";
            colunas[1] = "Definição";
            colunas[2] = "Institucionalização";
            colunas[3] = "Comentários";
            colunas[4] = "Tipo";
            colunas[5] = "Artefatos";
        } else if (definicao || institucionalizacao) {
            colunas = new String[5];
            colunas[0] = "Prática";
            colunas[2] = "Comentários";
            colunas[3] = "Tipo";
            colunas[4] = "Artefatos";
            if (definicao) {
                colunas[1] = "Definição";
            } else {
                colunas[1] = "Institucionalização";
            }
        }
    }

    /**
     * Retorna o tamanho da lista
     * @return int
     */
    @Override
    public int getRowCount() {
        return getSize();
    }

    /**
     * Retorna a quantidade de colunas
     * @return int
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Retorna o nome da coluna
     * @param arg0
     * @return String
     */
    @Override
    public String getColumnName(int arg0) {
        return colunas[arg0];
    }

    /**
     * Retorna o tipo de classe da coluna
     * @param arg0
     * @return Class
     */
    @Override
    public Class<?> getColumnClass(int arg0) {
        if (definicao && institucionalizacao) {
            if (arg0 == 1) {
                //se arg0 é igual à coluna de Status
                return StatusDefinicao.class;
            } else if (arg0 == 2) {
                return StatusInstitucionalizacao.class;
            } else if (arg0 == 3) {
                return StatusComentario.class;
            } else {
                return String.class;
            }
        } else {
            if (arg0 == 1) {
                //se arg0 é igual à coluna de Status
                if (definicao) {
                    return StatusDefinicao.class;
                } else if (institucionalizacao) {
                    return StatusInstitucionalizacao.class;
                } else {
                    return String.class;
                }
            } else if (arg0 == 3) {
                return StatusComentario.class;
            } else {
                return String.class;
            }
        }
    }

    /**
     * Retorna se os valores de uma determinada coluna podem sofrer alterações.
     * @param arg0
     * @param arg1
     * @return boolean
     */
    @Override
    public boolean isCellEditable(int arg0, int arg1) {
        boolean editavel = false;
        if (definicao && institucionalizacao) {
            if (arg1 == 1 || arg1 == 2 || arg1 == 3 || arg1 == 4 || arg1 == 5) {
                editavel = true;
            }
        } else {
            if (arg1 == 1 || arg1 == 2 || arg1 == 3 || arg1 == 4) {
                editavel = true;
            }
        }
        return editavel;
    }

    /**
     * Retorna o valor de determinada célula
     * @param arg0
     * @param arg1
     * @return Object
     */
    @Override
    public Object getValueAt(int arg0, int arg1) {
        Object retorno = null;
        if (definicao && institucionalizacao) {
            switch (arg1) {
                case 0:
                    retorno = getElementAt(arg0).getIdpraticagenerica();
                    break;
                case 1:
                    retorno = getElementAt(arg0).getIdStatusDefinicao();
                    break;
                case 2:
                    retorno = getElementAt(arg0).getIdStatusInstitucionalizacao();
                    break;
                case 3:
                    retorno = getElementAt(arg0).getComentario();
                    break;
                case 4:
                    retorno = getElementAt(arg0).getIdStatusComentario();
                    break;
            }
        } else {
            switch (arg1) {
                case 0:
                    retorno = getElementAt(arg0).getIdpraticagenerica();
                    break;
                case 1:
                    if (definicao) {
                        retorno = getElementAt(arg0).getIdStatusDefinicao();
                    } else if (institucionalizacao) {
                        retorno = getElementAt(arg0).getIdStatusInstitucionalizacao();
                    }
                    break;
                case 2:
                    retorno = getElementAt(arg0).getComentario();
                    break;
                case 3:
                    retorno = getElementAt(arg0).getIdStatusComentario();
                    break;
            }
        }
        return retorno;
    }

    /**
     * Informa o valor que determinada célula deve receber
     * @param arg0
     * @param arg1
     * @param arg2
     */
    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {
        if (definicao && institucionalizacao) {
            if (arg2 == 1) {
                getElementAt(arg1).setIdStatusDefinicao((StatusDefinicao) arg0);
            } else if (arg2 == 2) {
                getElementAt(arg1).setIdStatusInstitucionalizacao((StatusInstitucionalizacao) arg0);
            } else if (arg2 == 3) {
                getElementAt(arg1).setComentario((String) arg0);
            } else if (arg2 == 4) {
                getElementAt(arg1).setIdStatusComentario((StatusComentario) arg0);
            }
        } else {
            if (arg2 == 1) {
                if (definicao) {
                    getElementAt(arg1).setIdStatusDefinicao((StatusDefinicao) arg0);
                } else if (institucionalizacao) {
                    getElementAt(arg1).setIdStatusInstitucionalizacao((StatusInstitucionalizacao) arg0);
                }
            } else if (arg2 == 2) {
                getElementAt(arg1).setComentario((String) arg0);
            } else if (arg2 == 3) {
                getElementAt(arg1).setIdStatusComentario((StatusComentario) arg0);
            }
        }
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
    }
}
