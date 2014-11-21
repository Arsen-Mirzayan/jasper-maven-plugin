package com.mira.jasper;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Arsen
 * Date: 20.11.14
 * Time: 18:58
 * To change this template use File | Settings | File Templates.
 */
public class CompileMojoTest {
    @org.junit.Test
    public void testCompile() throws Exception {
         new CompileMojo().compile(new File("D:\\temp\\vseveda\\target\\development\\modules\\report 038.jrxml"));
    }
}
