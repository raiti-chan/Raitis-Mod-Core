package com.raitichan.raitismodcore.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.raitichan.raitismodcore.util.ToolClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * メタデータで区別されるブロック
 * <br>Created by Raiti-chan on 2017/11/02.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class SimpleMetaBlock extends RBlock {
	
	/**
	 * ブロックのアイコン
	 */
	private IIcon[] icons;
	
	/**
	 * ブロック名とマテリアルを指定してメタ値で区別されたブロックを作成します。
	 *
	 * @param name     ブロック名
	 * @param material ブロックのマテリアル
	 * @param maxMeta ブロックの最大のメタ値(最大15)
	 */
	public SimpleMetaBlock (String name, Material material, int maxMeta) {
		super(name, material);
		this.icons = new IIcon[maxMeta];
	}
	
	/**
	 * ブロック名とマテリアルと硬さを指定してメタ値で区別されたブロックを作成します。
	 *
	 * @param name     ブロック名
	 * @param material ブロックのマテリアル
	 * @param hardness 硬さ
	 * @param maxMeta ブロックの最大のメタ値(最大15)
	 */
	public SimpleMetaBlock (String name, Material material, float hardness, int maxMeta) {
		super(name, material, hardness);
		this.icons = new IIcon[maxMeta];
	}
	
	/**
	 * ブロック名とマテリアルとハーベストレベルを指定してメタ値で区別されたブロックを作成します。
	 *
	 * @param name         ブロック名
	 * @param material     ブロックのマテリアル
	 * @param toolClass    ブロックの適正ツールクラス
	 * @param harvestLevel ブロックのハーベストレベル
	 * @param maxMeta ブロックの最大のメタ値(最大15)
	 */
	public SimpleMetaBlock (String name, Material material, ToolClass toolClass, int harvestLevel,int maxMeta) {
		super(name, material, toolClass, harvestLevel);
		this.icons = new IIcon[maxMeta];
	}
	
	/**
	 * テクスチャの取得処理
	 * @param iconRegister テクスチャのレジスター
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons (IIconRegister iconRegister) {
		for (int i = 0; i < this.icons.length; i++) {
			this.icons[i] = iconRegister.registerIcon(this.getTextureName() + "_" + i);
		}
	}
	
	/**
	 * ブロックのテクスチャを取得します。
	 * @param side 面
	 * @param meta ブロックのメタデータ
	 * @return テクスチャ
	 */
	@Override
	public IIcon getIcon (int side, int meta) {
		return this.icons[meta];
	}
	
	/**
	 * アイテムをクリエタブに登録します。
	 * @param item アイテム
	 * @param creativeTabs タブ
	 * @param list リスト
	 */
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks (Item item, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < this.icons.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	/**
	 * ドロップするアイテムのメタ値を取得します。
	 * @param meta ブロックのメタ値
	 * @return ドロップするアイテムのメタ値
	 */
	@Override
	public int damageDropped (int meta) {
		return meta;
	}
	
}
