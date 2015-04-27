/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.service;

import org.owen.batisx.entity.DataBaseVo;

/**
 * @author owenludong.lud
 * @version $Id: BatisXService, v 0.1  2015/4/27 14:13  owenludong.lud Exp $$
 */
public interface BatisXService {

    DataBaseVo connectDB(String jdbcUrl,String username,String password) throws Exception;
}
