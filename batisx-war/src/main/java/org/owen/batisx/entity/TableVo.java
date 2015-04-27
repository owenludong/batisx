/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.entity;

import java.util.List;

/**
 * @author owenludong.lud
 * @version $Id: TableVo, v 0.1  2015/4/27 16:36  owenludong.lud Exp $$
 */
public class TableVo {

    private String tableName;

    private List<ColumnVo> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnVo> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnVo> columns) {
        this.columns = columns;
    }
}
