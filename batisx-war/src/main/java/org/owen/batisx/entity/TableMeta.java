/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.entity;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author owenludong.lud
 * @version $Id: TableMeta, v 0.1  2015/4/27 17:31  owenludong.lud Exp $$
 */
public class TableMeta {

    private DatabaseMeta databaseMeta;
    private String       tableName;

    public TableMeta(String tableName, DatabaseMeta databaseMeta) {
        this.tableName = tableName;
        this.databaseMeta = databaseMeta;
    }

    public List<ColumnMeta> getColumns()
            throws Exception {
        Connection conn = this.databaseMeta.getConnection();

        DatabaseMetaData dbmd = conn.getMetaData();

        String catalog = this.databaseMeta.getCatalog();
        String schema = this.databaseMeta.getSchema();
        ResultSet resultSet = dbmd.getColumns(catalog, schema, this.tableName, null);

        List columnMetas = new ArrayList();
        while (resultSet.next()) {
            ColumnMeta columnMeta = new ColumnMeta(this, resultSet);

            columnMetas.add(columnMeta);
        }
        resultSet.close();
        return columnMetas;
    }
}
