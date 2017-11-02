package com.raitichan.raitismodcore.item;

import net.minecraft.item.Item;

import com.raitichan.raitismodcore.RaitisModCore;
import com.raitichan.raitismodcore.util.IRegisteredObject;

/**
 * Raiti's Mod の通常アイテムのベースクラス
 * <br>Created by Raiti-chan on 2017/10/29.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
public class RItem extends Item implements IRItem, IRegisteredObject {
	
	/**
	 * このアイテムの名前
	 */
	private String itemName;
	
	@SuppressWarnings("WeakerAccess")
	public RItem(String name) {
		setUnlocalizedName(name);
		setTextureName(name.toLowerCase().replace(' ', '_'));
		setMaxStackSize(64);
	}
	
	/**
	 * テクスチャ―の名前を指定します。(内部で{@link RaitisModCore#MOD_ID raitismodcore}:textureNameを引数として{@link Item#setTextureName(String)}を呼び出します。)
	 * @param textureName テクスチャ―名
	 * @return 自身
	 */
	@Override
	public Item setTextureName (String textureName) {
		return super.setTextureName(RaitisModCore.MOD_ID + ":" + textureName);
	}
	
	/**
	 * アイテム名を登録します。(内部で{@link RaitisModCore#MOD_ID raitismodcore}.nameを引数として{@link Item#setUnlocalizedName(String)}を呼び出します。)
	 * @param name アイテム名
	 * @return 自身
	 */
	@Override
	public Item setUnlocalizedName (String name) {
		this.itemName = name;
		return super.setUnlocalizedName(RaitisModCore.MOD_ID + "." +name);
	}
	
	/**
	 * 設定されたアイテム名を取得します。({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 * @return アイテム名
	 */
	@Override
	public String getItemName () {
		return this.itemName;
	}
	
	/**
	 * オブジェクトのタイプ
	 * @return {@link com.raitichan.raitismodcore.util.IRegisteredObject.RegisteredObjectType#ITEM Item}
	 */
	@Override
	public RegisteredObjectType getType () {
		return RegisteredObjectType.ITEM;
	}
}
