/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.service.impl;

import org.apache.commons.lang.StringUtils;
import org.owen.batisx.common.database.DataBaseMetaReposity;
import org.owen.batisx.entity.*;
import org.owen.batisx.service.BatisXService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author owenludong.lud
 * @version $Id: BatisXServiceImpl, v 0.1  2015/4/27 14:15  owenludong.lud Exp $$
 */
public class BatisXServiceImpl implements BatisXService {

    @Override
    public DataBaseVo connectDB(String jdbcUrl, String username, String password) throws Exception {
        if(StringUtils.isBlank(jdbcUrl) || StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            throw new RuntimeException("parameter is not complete");
        }

        DatabaseMeta meta = DataBaseMetaReposity.findMeta(jdbcUrl,username,password);
        if(meta == null){
            meta = DataBaseMetaReposity.registerMeta(jdbcUrl,username,password);
        }
        List<String> tableNames = meta.getTableNames(null);
        if(tableNames == null){
            return null;
        }
        DataBaseVo result = new DataBaseVo();
        List<TableVo> tableVos = new ArrayList<TableVo>();
        for(String tableName : tableNames){
            TableVo tableVo = new TableVo();
            tableVo.setTableName(tableName);
            List<ColumnMeta> columnMetas = new TableMeta(tableName,meta).getColumns();
            List<ColumnVo> columnVos = new ArrayList<ColumnVo>();
            if(columnMetas != null && columnMetas.isEmpty()){
                for(ColumnMeta columnMeta : columnMetas){
                    ColumnVo columnVo = new ColumnVo();
                    columnVo.setColumnName(columnMeta.getColumnName());
                    columnVos.add(columnVo);
                }
                tableVo.setColumns(columnVos);
            }
            tableVos.add(tableVo);
        }
        result.setTables(tableVos);
        return result;
    }
}
