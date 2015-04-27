/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author owenludong.lud
 * @version $Id: ColumnMeta, v 0.1  2015/4/27 17:32  owenludong.lud Exp $$
 */
public class ColumnMeta {

    private final TableMeta tableMeta;
    private String columnName;
    private int sqlType;
    private int columnSize;
    private boolean isNullable;

    public ColumnMeta(TableMeta tableMeta)
    {
        this.tableMeta = tableMeta;
    }

    public ColumnMeta(TableMeta tableMeta, ResultSet column)
    {
        this(tableMeta);
        try {
            setColumnName(column.getString("COLUMN_NAME"));
            setSqlType(column.getInt("DATA_TYPE"));
            setColumnSize(column.getInt("COLUMN_SIZE"));
            setNullable(column.getString("IS_NULLABLE"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getSqlType() {
        return this.sqlType;
    }

    public void setSqlType(int sqlType) {
        this.sqlType = sqlType;
    }


    public int getColumnSize() {
        return this.columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public boolean isNullable() {
        return this.isNullable;
    }

    public void setNullable(boolean isNullable) {
        this.isNullable = isNullable;
    }

    public void setNullable(String isNullable) {
        this.isNullable = (!"NO".equalsIgnoreCase(isNullable));
    }

    public TableMeta getTableMeta() {
        return this.tableMeta;
    }

}
