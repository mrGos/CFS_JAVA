/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.common.controls;

import base.data.entities.FullAuditEntity;
import base.guis.controls.BaseComponent;
import base.guis.controls.BaseEditPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Khang
 */
public class AppCrudToolBar extends BaseComponent  implements ActionListener{

    /**
     * Creates new form AppCrudToolBar
     */
    BaseEditPanel editPanelFunctions;
    public AppCrudToolBar() {
        initComponents();
    }
    public void setEditPanelUI(BaseEditPanel editPanelFunctions){
        this.editPanelFunctions = editPanelFunctions;
        btnRefresh.addActionListener(this);
        btnSave.addActionListener(this);
        btnDelete.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        btnDelete.setText("Xóa");

        btnSave.setText("Lưu");

        btnRefresh.setText("Làm mới");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnDelete)
                .addComponent(btnSave)
                .addComponent(btnRefresh))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            btnSave.setEnabled(false);
             if(e.getSource()==btnRefresh){
                this.editPanelFunctions.refreshEditForm();
             }else if (e.getSource()==btnSave){
                this.editPanelFunctions.bindingViewToModel();
                this.editPanelFunctions.save();
                this.editPanelFunctions.search();
              }else if (e.getSource()==btnDelete){
                this.editPanelFunctions.bindingViewToModel();
                ((FullAuditEntity)this.editPanelFunctions.getCurrentObj()).setDeleted(true);
                this.editPanelFunctions.save();
                this.editPanelFunctions.search();
              }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
              btnSave.setEnabled(true);
        }
      
    }
}