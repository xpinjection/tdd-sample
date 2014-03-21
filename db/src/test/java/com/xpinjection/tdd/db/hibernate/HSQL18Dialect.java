// ============================================================================
//  File          : HSQL18Dialect
//  Created       : 23.04.2010
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.db.hibernate;

import org.hibernate.dialect.HSQLDialect;

import java.sql.Types;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class HSQL18Dialect extends HSQLDialect {
    public HSQL18Dialect() {
        super();
        registerColumnType(Types.BIT, "boolean");
        registerColumnType(Types.BOOLEAN, "boolean");
        registerHibernateType(Types.BOOLEAN, "boolean");
    }
}