/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.common.database;

import org.owen.batisx.entity.DatabaseMeta;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author owenludong.lud
 * @version $Id: DataBaseMetaReposity, v 0.1  2015/4/27 16:11  owenludong.lud Exp $$
 */
public class DataBaseMetaReposity {

    /**
     * 数据源数据
     */
    private static final Map<String, DatabaseMeta> METAS = new ConcurrentHashMap<String, DatabaseMeta>();

    /**
     * 注册一个数据源对象.
     * <p/>
     * 同模块同组件的配置, 后注册的覆盖先注册的.
     *
     * @param key  配置所属模块, 如果为<tt>null</tt>不予注册
     * @param meta 注册的源数据, 如果为<tt>null</tt>不予注册
     */
    public static void registerMeta(String key, DatabaseMeta meta) {
        if (null == key || null == meta) {
            return;
        }

        METAS.put(key, meta);
    }

    public static void registerMeta(String jdbcUrl, String username, String password,
                                    DatabaseMeta meta) {
        if (null == jdbcUrl || null == username || null == password) {
            return;
        }

        String metaKey = DatabaseMeta.toMetaKey(jdbcUrl, username, password);
        METAS.put(metaKey, meta);
    }

    public static DatabaseMeta registerMeta(String jdbcUrl, String username, String password)
            throws SQLException {
        if (null == jdbcUrl || null == username || null == password) {
            return null;
        }

        String metaKey = DatabaseMeta.toMetaKey(jdbcUrl, username, password);
        DatabaseMeta metaValue = DatabaseMeta.create(jdbcUrl, username, password);
        METAS.put(metaKey, metaValue);
        return metaValue;
    }

    /**
     * 查找配置.
     *
     * @param key 配置所属模块, 如果为<tt>null</tt>返回<tt>null</tt>
     *            如果该模块的默认配置未注册过, 返回<tt>null</tt>
     * @return 配置
     */
    public static DatabaseMeta findMeta(String key) {
        if (null == key) {
            return null;
        }

        return METAS.get(key);
    }

    public static DatabaseMeta findMeta(String jdbcUrl, String username, String password) {
        if (null == jdbcUrl || null == username || null == password) {
            return null;
        }

        String metaKey = DatabaseMeta.toMetaKey(jdbcUrl, username, password);
        return METAS.get(metaKey);
    }

    /**
     * 删除配置.
     *
     * @param key 配置所属模块, 如果为<tt>null</tt>返回<tt>null</tt>
     *            如果该模块的默认配置未注册过, 返回<tt>null</tt>
     * @return 配置
     */
    public static void removeMeta(String key) {
        if (null == key) {
            return;
        }

        METAS.remove(key);
    }

    public static void removeMeta(String jdbcUrl, String username, String password) {
        if (null == jdbcUrl || null == username || null == password) {
            return;
        }

        String metaKey = DatabaseMeta.toMetaKey(jdbcUrl, username, password);
        METAS.remove(metaKey);
    }
}
