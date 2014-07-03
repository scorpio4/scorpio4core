package com.scorpio4.tools

import com.scorpio4.fact.FactSpace
import com.scorpio4.iq.exec.Executor
import org.openrdf.repository.http.HTTPRepository

/**
 * Scorpio4 (c) 2014
 * Module: com.scorpio4.tools
 * User  : lee
 * Date  : 18/06/2014
 * Time  : 4:47 PM
 *
 *
 */
class ExecutorTest extends GroovyTestCase {

    void testDoRun() {
        HTTPRepository repository = new HTTPRepository("http://127.0.0.1:8080/openrdf-sesame/","FactTools");
        def connection = repository.getConnection();

        def toolChain = new Executor(new FactSpace(connection, "urn:BlankProject:"));
        def executed = toolChain.run("urn:BlankProject:", [:])
	    assert executed!=null;
	    println "Executed: "+executed;
        connection.close();
        repository.shutDown();
    }
}
