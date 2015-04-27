/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.common;

/**
 * @author owenludong.lud
 * @version $Id: BatisXException, v 0.1  2015/4/27 15:30  owenludong.lud Exp $$
 */
public class BatisXException extends RuntimeException {

    public BatisXException() {
        super();
    }

    public BatisXException(String message) {
        super(message);
    }

    public BatisXException(String message, Throwable cause) {
        super(message, cause);
    }

    public BatisXException(Throwable cause) {
        super(cause);
    }

    protected BatisXException(String message, Throwable cause, boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
