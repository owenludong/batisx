/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx;

import org.junit.Test;
import org.owen.batisx.entity.DatabaseMeta;

import java.sql.SQLException;
import java.util.List;

/**
 * @author owenludong.lud
 * @version $Id: TestJdbc, v 0.1  2015/4/27 16:56  owenludong.lud Exp $$
 */
public class TestJdbc {

    @Test
    public void test_getTable() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/qunmh";
        String username = "root";
        String password = "owenludong";
        DatabaseMeta meta  = DatabaseMeta.create(jdbcUrl, username, password);
        List<String> tableNames =  meta.getTableNames(null);
        System.out.println(tableNames == null ? 0: tableNames.size());
    }

    @Test
    public void test_getTableTypes() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/qunmh";
        String username = "root";
        String password = "owenludong";
        DatabaseMeta meta  = DatabaseMeta.create(jdbcUrl, username, password);
        List<String> tableNames =  meta.getTableTypes();
        System.out.println(tableNames == null ? 0: tableNames.size());
    }
}
