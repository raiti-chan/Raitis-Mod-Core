package com.raitichan.raitismodcore.item.blockItem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.raitichan.raitismodcore.RaitisModCore;
import com.raitichan.raitismodcore.block.IRBlock;
import com.raitichan.raitismodcore.item.IRItem;
import com.raitichan.raitismodcore.util.IRegisteredObject;

/**
 * ブロックの基本的なアイテムクラス
 * <br>Created by Raiti-chan on 2017/11/03.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RItemBlock extends ItemBlock implements IRItem , IRegisteredObject{
	
	/**
	 * ブロックのアイテムを作成します。
	 * @param block 作成元ブロック
	 */
	@SuppressWarnings("WeakerAccess")
	public RItemBlock (Block block) {
		super(block);
	}
	
	/**
	 * 設定されたアイテム名を取得します。({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 *
	 * @return アイテム名
	 */
	@Override
	public String getItemName () {
		return ((IRBlock) this.field_150939_a).getBlockName();
	}
	
	/**
	 * 設定されたアイテム名を取得します。({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 *
	 * @param itemStack 取得するアイテムのスタック
	 * @return アイテム名(メタ値ごとに分けられた)
	 */
	@Override
	public String getItemName (ItemStack itemStack) {
		return this.getItemName();
	}
	
	/**
	 * オブジェクトのタイプを取得します。
	 *
	 * @return オブジェクトのタイプ
	 */
	@Override
	public RegisteredObjectType getType () {
		return RegisteredObjectType.ITEM;
	}
}
