/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.antlr.v4.plugins;

import org.apache.commons.cli.CommandLine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ServiceLoader;

import org.apache.commons.cli.Option;

import java.util.Iterator;

/**
 * Loads plug-ins at startup and allows to configure them
 * @author benoit
 */
public final class PluginsLoader {
	private ArrayList<ANTLRPlugin> plugins = new ArrayList<ANTLRPlugin>();

	/**
	 * Detects which plug-ins are  present in the class path and loads them.
	 */
	public PluginsLoader() {
		ServiceLoader<ANTLRPlugin> loader = ServiceLoader.load(org.antlr.v4.plugins.ANTLRPlugin.class);
		Iterator<ANTLRPlugin> it = loader.iterator();
		
		for (ANTLRPlugin plugin : loader)
			plugins.add(plugin);
	}
		
	/**
	 * Return the list of options supported by the plug-ins
	 * @return the list of options supported
	 */
	public Collection<Option> getOptions(){
		ArrayList<Option> options = new ArrayList<Option>();
		for (ANTLRPlugin plugin : getPlugins()){
			options.addAll(plugin.getOptions());
		}
		return options;
	}
	
	/**
	 * Returns the list of plug-ins found in the class path
	 * @return the list of plug-ins found in the class path
	 */
	public Collection<ANTLRPlugin> getPlugins(){
		return plugins;
	}
	
	/**
	 * Configures the plug-ins and returns the list of plug ins activated and configured 
	 * @param cmdline Command line object containing the list of parameters
	 * @return the list of plug-ins.
	 */
	public Collection<ANTLRPlugin> getActivePlugins(CommandLine cmdline){
		ArrayList<ANTLRPlugin> activePlugins = new ArrayList<ANTLRPlugin>();
		for (ANTLRPlugin plugin : getPlugins()){
			if (-1 <= plugin.configure(cmdline))
				activePlugins.add(plugin);
		}
		return activePlugins;
	}
}
