// ============================================================================
//  File          : AbstractDbTest
//  Created       : 22.04.2010   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injecton, Ukraine
// ============================================================================
package com.xpinjection.tdd.db;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.DatabaseUnitils;
import org.unitils.database.SQLUnitils;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext({"database-context.xml", "database-test-context.xml"})
public abstract class AbstractDbTest extends Assert {
    protected long getNumberOfRecords(String tableName) {
        return SQLUnitils.getItemAsLong("select count(*) from " + tableName, DatabaseUnitils.getDataSource());
    }
}
