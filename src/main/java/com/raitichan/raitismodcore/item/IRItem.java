package com.raitichan.raitismodcore.item;

import net.minecraft.item.ItemStack;

import com.raitichan.raitismodcore.RaitisModCore;

/**
 * Raiti's Mod で追加されるアイテムのインターフェース。
 * <br>Created by Raiti-chan on 2017/10/29.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public interface IRItem {
	
	/**
	 * 設定されたアイテム名を取得します。({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 *
	 * @return アイテム名
	 */
	@SuppressWarnings("unused")
	String getItemName ();
	
	/**
	 * 設定されたアイテム名を取得します。({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 *
	 * @param itemStack 取得するアイテムのスタック
	 * @return アイテム名(メタ値ごとに分けられた)
	 */
	@SuppressWarnings("unused")
	default String getItemName (ItemStack itemStack) {
		return getItemName();
	}
	
}
