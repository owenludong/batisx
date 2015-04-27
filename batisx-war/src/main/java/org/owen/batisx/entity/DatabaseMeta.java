/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.entity;

import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author owenludong.lud
 * @version $Id: DataBaseMeta, v 0.1  2015/4/27 15:56  owenludong.lud Exp $$
 */
public class DatabaseMeta {

    private String driverClassName;

    private String dbUrl;

    private String username;

    private String password;

    private String catalog;

    private String schema;

    private Connection connection;

    public static DatabaseMeta create(String jdbcUrl, String username, String password)
            throws SQLException {
        DatabaseMeta meta = new DatabaseMeta();
        meta.setDbUrl(jdbcUrl);
        meta.setUsername(username);
        meta.setPassword(password);
        String driverClassName = JdbcUtils.getDriverClassName(jdbcUrl);
        meta.setDriverClassName(driverClassName);
        return meta;
    }

    public final Connection getConnection() {
        try {
            if ((this.connection == null) || (this.connection.isClosed())) {
                this.connection = connect();
            }
            return this.connection;
        } catch (Exception e) {
            if ((e instanceof RuntimeException)) {
                throw ((RuntimeException) e);
            }
            throw new RuntimeException(e);
        }
    }

    private final Connection connect()
            throws Exception {
        Class.forName(driverClassName);
        connection = DriverManager.getConnection(dbUrl, username, password);
        if (connection == null) {
            throw new RuntimeException("Connection Invalid, please verify URL.");
        }
        return connection;
    }

    public List<String> getTableNames(String[] types) {
        try {
            if ((this.connection == null) || (this.connection.isClosed())) {
                this.connection = connect();
            }
            DatabaseMetaData dbmd = this.connection.getMetaData();

            ResultSet rsTables = dbmd.getTables(getCatalog(), getSchema(), null, types);
            List tables = new ArrayList();
            while (rsTables.next()) {
                String table = rsTables.getString("TABLE_NAME");
                tables.add(table);
            }

            rsTables.close();
            return tables;
        } catch (Exception e) {
            if ((e instanceof RuntimeException)) {
                throw ((RuntimeException) e);
            }
            throw new RuntimeException(e);
        }
    }

    public List<String> getTableTypes() {
        try {
            if ((this.connection == null) || (this.connection.isClosed())) {
                this.connection = connect();
            }
            DatabaseMetaData dbmd = this.connection.getMetaData();

            ResultSet rsTables = dbmd.getTableTypes();
            List types = new ArrayList();
            while (rsTables.next()) {
                String type = rsTables.getString("TABLE_TYPE");
                types.add(type);
            }

            rsTables.close();
            return types;
        } catch (Exception e) {
            if ((e instanceof RuntimeException)) {
                throw ((RuntimeException) e);
            }
            throw new RuntimeException(e);
        }
    }

    public final boolean isConnected() {
        try {
            return (this.connection != null) && (!this.connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getSchema() {
        return schema;
    }

    @Override
    public String toString() {
        return "DataBaseMeta{" +
               "dbUrl='" + dbUrl + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               '}';
    }

    public static String toMetaKey(String dbUrl, String username, String password) {
        return "DataBaseMeta{" +
               "dbUrl='" + dbUrl + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
