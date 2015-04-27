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
     * ����Դ����
     */
    private static final Map<String, DatabaseMeta> METAS = new ConcurrentHashMap<String, DatabaseMeta>();

    /**
     * ע��һ������Դ����.
     * <p/>
     * ͬģ��ͬ���������, ��ע��ĸ�����ע���.
     *
     * @param key  ��������ģ��, ���Ϊ<tt>null</tt>����ע��
     * @param meta ע���Դ����, ���Ϊ<tt>null</tt>����ע��
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
     * ��������.
     *
     * @param key ��������ģ��, ���Ϊ<tt>null</tt>����<tt>null</tt>
     *            �����ģ���Ĭ������δע���, ����<tt>null</tt>
     * @return ����
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
     * ɾ������.
     *
     * @param key ��������ģ��, ���Ϊ<tt>null</tt>����<tt>null</tt>
     *            �����ģ���Ĭ������δע���, ����<tt>null</tt>
     * @return ����
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
