package com.raitichan.raitismodcore.item.blockItem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.raitichan.raitismodcore.RaitisModCore;
import com.raitichan.raitismodcore.block.SimpleMetaBlock;

/**
 * メタデータで区別された基本的なアイテム
 * <br>Created by Raiti-chan on 2017/11/03.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RItemBlockWithMetadata extends RItemBlock {
	
	/**
	 * ブロックのアイテムを作成します。
	 *
	 * @param block 作成元ブロック
	 */
	public RItemBlockWithMetadata (Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
		
}
	
	/**
	 * メタ値の取得
	 * @param meta メタ値
	 * @return メタ値
	 */
	@Override
	public int getMetadata (int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName (ItemStack stack) {
		return getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	/**
	 * アイテムスタックから名前の取得({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 * @param itemStack 取得するアイテムのスタック
	 * @return 名前
	 */
	@Override
	public String getItemName (ItemStack itemStack) {
		return getItemName() + "." + itemStack.getItemDamage();
	}
}
