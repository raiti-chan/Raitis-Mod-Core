package com.raitichan.raitismodcore.block;

import com.raitichan.raitismodcore.RaitisModCore;

/**
 * Raiti's Modのブロックのインターフェース
 * <br>Created by Raiti-chan on 2017/11/01.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IRBlock {
	
	/**
	 * 設定されたブロック名を取得します。({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 * @return ブロック名
	 */
	String getBlockName();

}
