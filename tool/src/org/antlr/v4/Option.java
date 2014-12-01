/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.antlr.v4;

/**
 *
 * @author benoit
 */
public class Option {
	String fieldName;
	String name;
	OptionArgType argType;
	String description;

	public Option(String fieldName, String name, String description) {
		this(fieldName, name, OptionArgType.NONE, description);
	}

	public Option(String fieldName, String name, OptionArgType argType, String description) {
		this.fieldName = fieldName;
		this.name = name;
		this.argType = argType;
		this.description = description;
	}
    
}
