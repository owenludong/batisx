/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.entity;

import java.util.List;

/**
 * @author owenludong.lud
 * @version $Id: DataBaseVo, v 0.1  2015/4/27 16:35  owenludong.lud Exp $$
 */
public class DataBaseVo {

    private String dbName;

    private List<TableVo> tables;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public List<TableVo> getTables() {
        return tables;
    }

    public void setTables(List<TableVo> tables) {
        this.tables = tables;
    }
}
