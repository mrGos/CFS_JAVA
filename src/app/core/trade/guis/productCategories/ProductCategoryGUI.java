/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.trade.guis.productCategories;

import app.core.modules.constants.PageConstants;
import app.core.modules.constants.StoreConstants;
import app.core.trade.dtos.productCategories.ProductCategoryDisplayDto;
import app.core.trade.dtos.productCategories.ProductCategoryEntity;
import base.applications.imps.BaseService;
import base.guis.controls.BaseEditPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Khang
 */
public class ProductCategoryGUI extends BaseEditPanel {

    /**
     * Creates new form ProductCategoryCategoryGUI
     */
    public ProductCategoryGUI() {
        //current obj, search obj, display obj
        super(new ProductCategoryEntity(), new ProductCategoryEntity(), new ProductCategoryDisplayDto());
        initComponents();
        try {
            init();
        } catch (InstantiationException ex) {
            Logger.getLogger(ProductCategoryGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProductCategoryGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() throws InstantiationException, IllegalAccessException {
        this.appService = new BaseService(ProductCategoryEntity.class, ProductCategoryDisplayDto.class);
        dataTable.setEditPanel(this);

        this.setIdControl(txtCode);
        this.tableModel = (DefaultTableModel) dataTable.getTable().getModel();
        this.appCrudToolBar.setEditPanelUI(this);
        this.setGroupInformation(this.groupInformation, PageConstants.PRODUCTCATEGORY);
        setTableColumns();

        // set store procedure names
        this.setStoreProcedureNames(
                StoreConstants.PRODUCTCATEGORY_SEARCH,
                StoreConstants.PRODUCTCATEGORY_INSORUPD,
                StoreConstants.PRODUCTCATEGORY_BYID);

        this.dataTable.onResetSearch();
    }

    @Override
    public void setTableColumns() {

        String[] headers = new String[]{"STT", "Id", "Tên loại", "Mô tả"};
        tableModel.setColumnIdentifiers(headers);
        TableColumnModel colModel = dataTable.getTable().getColumnModel();

    }

    @Override
    public void bindingModelToView() {
        //System.out.println(txtPrice.getValue());
        ProductCategoryEntity entity = (ProductCategoryEntity) this.getCurrentObj();
        txtCode.setText(entity.getCode());
        txtName.setText(entity.getName());
        txtDescription.setText(entity.getDescription());
    }

    @Override
    public void bindingViewToModel() {
        ProductCategoryEntity entity = (ProductCategoryEntity) this.getCurrentObj();
        entity.setCode(txtCode.getText());
        entity.setName(txtName.getText());
        entity.setDescription(txtDescription.getText());      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataTable = new app.common.controls.DataTable();
        groupInformation = new app.common.controls.GroupBox();
        txtCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        appCrudToolBar = new app.common.controls.AppCrudToolBar();

        jLabel1.setText("Mã loại:");

        jLabel2.setText("Tên loại:");

        jLabel3.setText("Mô tả:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout groupInformationLayout = new javax.swing.GroupLayout(groupInformation);
        groupInformation.setLayout(groupInformationLayout);
        groupInformationLayout.setHorizontalGroup(
            groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupInformationLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(groupInformationLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(groupInformationLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCode)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        groupInformationLayout.setVerticalGroup(
            groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupInformationLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupInformationLayout.createSequentialGroup()
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(groupInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(groupInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(64, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appCrudToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataTable, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.common.controls.AppCrudToolBar appCrudToolBar;
    private app.common.controls.DataTable dataTable;
    private app.common.controls.GroupBox groupInformation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
