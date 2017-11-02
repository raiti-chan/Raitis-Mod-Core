package com.raitichan.raitismodcore.util;

/**
 * ツールのクラス
 * <br>Created by Raiti-chan on 2017/11/01.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public enum ToolClass {
	PICKAXE,
	AXE,
	SHOVEL,
	;
	
	public final String className;
	
	ToolClass() {
		this.className = this.name().toLowerCase();
	}
	
	ToolClass(String className) {
		this.className = className;
	}
	
}
