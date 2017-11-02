package com.raitichan.raitismodcore.util;

/**
 * 自動登録処理を行うオブジェクトのインターフェース
 * <br>Created by Raiti-chan on 2017/10/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IRegisteredObject {
	
	/**
	 * オブジェクトのタイプを取得します。
	 * @return オブジェクトのタイプ
	 */
	RegisteredObjectType getType() ;
	
	/**
	 * オブジェクトのタイプを表すEnum
	 */
	enum RegisteredObjectType {
		ITEM,
		BLOCK
	}
	
}
