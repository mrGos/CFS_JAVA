/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.core.data.dtos.products;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Khang
 */
public class ProductDisplayTableDto {
    private String name;
    private BigDecimal price;
    private Date createdDate;
    private String createdBy;
}
