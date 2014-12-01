/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.antlr.v4.plugins;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.CommandLine;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author benoit
 */
public interface ANTLRPlugin {

	/**
	 *
	 * @return THe name of the plug-in.
	 */
	String getName();
	
	/**
	 *
	 * @return THe description of the plug-in
	 */
	String getDescription();
	
	/**
	 * Return the list of command line options supported by this plug-in.
	 * 
	 * @note The same option can be supported by multiple plug-ins.
	 * 
	 * @return the list of command line options supported
	 */
	Collection<Option> getOptions();

	/**
	 * Configure the plug-in using the options parsed at the command line. 
	 * 
	 * @param cmdline Command line object resulting from the command line parsing.
	 * @return number of options consumed by this plug-in. Plug-ins that does not find the required options should return -1
	 */
	int configure(CommandLine cmdline);
	
	/**
	 * Executes the plug in.
	 * 
	 * @param context Map of name-object pairs that allows plug-ins to share information.
	 */
	void run(Map<String,Object> context);
}
