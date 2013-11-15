package com.mira.jasper;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "compile", defaultPhase = LifecyclePhase.PACKAGE)
public class CompileMojo extends AbstractMojo {

    @Parameter(alias = "directory", required = true)
    protected String directory;

    public void execute() throws MojoExecutionException, MojoFailureException {
        for (File jrxml : FileUtils.listFiles(new File(directory), new String[]{"jrxml"}, true)) {
            try {
                compile(jrxml);
            } catch (JRException e) {
                throw new MojoFailureException(String.format("Failed to compile %s", jrxml.getAbsoluteFile()));
            }
        }
    }

    public void compile(File jrxml) throws JRException {
        String source = jrxml.getAbsolutePath();
        String dest = source.replace(".jrxml", ".jasper");
        getLog().info(String.format("Compiling report %s", source));
        JasperCompileManager.compileReportToFile(source, dest);
    }
}
