package com.kloia.dojo.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PrintLoggerTest1.class,
        PrintLoggerTest2.class
})
public class JUnitTestSuite {
}
