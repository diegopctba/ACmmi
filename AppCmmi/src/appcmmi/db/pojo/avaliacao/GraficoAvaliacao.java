/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.avaliacao;

/**
 *
 * @author diego
 */
public class GraficoAvaliacao {

    private String areaProcesso;
    private String definicao;
    private Integer qtde;
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAreaProcesso() {
        return areaProcesso;
    }

    public void setAreaProcesso(String areaProcesso) {
        this.areaProcesso = areaProcesso;
    }

    public String getDefinicao() {
        return definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    
}
