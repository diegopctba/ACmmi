/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi;

import appcmmi.form.login.TelaLogin;
import javax.swing.UIManager;

/**
 * Classe principal, onde é atualizado os valores da classe {@link FileChooser},
 * e é chamado a tela responsável pela interaface com o usuário.
 * @author diego
 */
public class CmmiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        UIManager.put("FileChooser.lookInLabelMnemonic", "E");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em");

        UIManager.put("FileChooser.saveInLabelMnemonic", "S");
        UIManager.put("FileChooser.saveInLabelText", "Salvar em");

        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");

        UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Desktop");

        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");

        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");

        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");

        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");

        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "A");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo do arquivo");

        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.fileDateHeaderText", "Data");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");

        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");

        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonMnemonic", "A");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");

        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.saveButtonToolTipText", "S");
        UIManager.put("FileChooser.saveButtonToolTipText", "Salvar");

        UIManager.put("FileChooser.updateButtonText", "Alterar");
        UIManager.put("FileChooser.updateButtonToolTipText", "A");
        UIManager.put("FileChooser.updateButtonToolTipText", "Alterar");

        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.helpButtonToolTipText", "A");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");

        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os arquivos");


        new TelaLogin();
    }
}
