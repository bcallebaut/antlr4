/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.antlr.v4.plugins;

import org.antlr.v4.tool.ast.GrammarRootAST;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author benoit
 */
public class TestPlugin implements ANTLRPlugin{

	boolean b = false;
	
	@Override
	public String getName() {
		return "test";
	}

	@Override
	public String getDescription() {
		return "test plugin";
	}

	@Override
	public Collection<Option> getOptions() {		
		return Collections.singleton(OptionBuilder.withDescription("dummy option").create("b"));
	}

	@Override
	public int configure(CommandLine cmdline) {
		b = cmdline.hasOption("b");
		return 1;
	}

	@Override
	public void run(Map<String, Object> context) {
		System.out.println("B option was " + (b ? "true" : "false"));
		List<GrammarRootAST> sortedGrammars = (List<GrammarRootAST>)context.get("grammars");
	}
	
}
