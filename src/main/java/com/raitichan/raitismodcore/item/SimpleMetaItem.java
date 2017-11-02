package com.raitichan.raitismodcore.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.raitichan.raitismodcore.RaitisModCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * メタ値で分けられたアイテム
 * <br>Created by Raiti-chan on 2017/10/29.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class SimpleMetaItem extends RItem {
	
	/**
	 * アイテムのテクスチャ―
	 */
	private IIcon[] icons;
	
	/**
	 * 指定されたメタの最大値までを使うアイテム
	 * @param maxMeta メタの最大値
	 */
	public  SimpleMetaItem(String name, int maxMeta) {
		super(name);
		icons = new IIcon[maxMeta];
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	/**
	 * テクスチャの取得処理
	 * @param iconRegister テクスチャのレジスター
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons (IIconRegister iconRegister) {
		for (int i = 0; i < this.icons.length; i++) {
			this.icons[i] = iconRegister.registerIcon(this.getIconString() + "_" + i);
		}
	}
	
	/**
	 * メタ値ごとのアイコンの取得
	 * @param meta メタ値
	 * @return アイコン
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage (int meta) {
		return this.icons[meta];
	}
	
	/**
	 * アイテムをクリエタブに登録します。
	 * @param item アイテム
	 * @param tab タブ
	 * @param list リスト
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void getSubItems (Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < this.icons.length; i++) {
			list.add(new ItemStack(this, 1, i));
		}
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
	
	/**
	 * アイテムスタックから名前の取得
	 * @param itemStack アイテムスタック
	 * @return 名前
	 */
	@Override
	public String getUnlocalizedName (ItemStack itemStack) {
		return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
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
