package app.mains;

import app.core.trade.guis.employees.EmployeeGUI;
import app.core.trade.guis.productCategories.ProductCategoryGUI;
import app.core.trade.guis.products.ProductGUI;
import base.configurations.constants.SystemConstants;
import base.guis.controls.BaseFrame;

import javax.swing.*;

public class MainWindow extends BaseFrame {

    ProductGUI productGUI;
    ProductCategoryGUI productCategoryGUI;
    EmployeeGUI employeeGUI;

    public MainWindow() throws InstantiationException, IllegalAccessException {

        productGUI = new ProductGUI();
        productGUI.setVisible(true);

        productCategoryGUI = new ProductCategoryGUI();
        productCategoryGUI.setVisible(true);

        employeeGUI = new EmployeeGUI();
        employeeGUI.setVisible(true);

        this.setTitle("MainWindow");
        this.setContentPane(employeeGUI);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(SystemConstants.CENTER_POSX, SystemConstants.CENTER_POSY,
                SystemConstants.DEFAULT_SCREEN_WIDTH, SystemConstants.DEFAULT_SCREEN_HEIGHT);
    }
}
