// ============================================================================
//  File          : HibernateMappingTest
//  Created       : 22.04.2010   
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2013 XP Injection, Ukraine
// ============================================================================
package com.xpinjection.tdd.db.hibernate;

import com.xpinjection.tdd.db.AbstractDbTest;
import org.junit.Test;
import org.unitils.orm.hibernate.HibernateUnitils;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class HibernateMappingTest extends AbstractDbTest {
    @Test
    public void testHibernateMapping() {
        HibernateUnitils.assertMappingWithDatabaseConsistent();
    }
}
