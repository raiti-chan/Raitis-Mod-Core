package com.raitichan.raitismodcore.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.raitichan.raitismodcore.RaitisModCore;
import com.raitichan.raitismodcore.util.IRegisteredObject;
import com.raitichan.raitismodcore.util.ToolClass;

/**
 * <br>Created by Raiti-chan on 2017/11/01.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class RBlock extends Block implements IRBlock, IRegisteredObject {
	
	/**
	 * ブロック名
	 */
	protected String blockName;
	
	/**
	 * ブロック名とマテリアルを指定してブロックを作成します。
	 * @param name ブロック名
	 * @param material ブロックのマテリアル
	 */
	public RBlock (String name,Material material) {
		super(material);
		setBlockName(name);
		setBlockTextureName(name.toLowerCase().replace(' ', '_'));
	}
	
	/**
	 * ブロック名とマテリアルと硬さを指定してブロックを作成します。
	 * @param name ブロック名
	 * @param material ブロックのマテリアル
	 * @param hardness 硬さ
	 */
	@SuppressWarnings("unused")
	public RBlock (String name, Material material, float hardness) {
		this(name,material);
		setHardness(hardness);
	}
	
	/**
	 * ブロック名とマテリアルとハーベストレベルを指定してブロックを作成します。
	 * @param name ブロック名
	 * @param material ブロックのマテリアル
	 * @param toolClass ブロックの適正ツールクラス
	 * @param harvestLevel ブロックのハーベストレベル
	 */
	public RBlock (String name, Material material, ToolClass toolClass, int harvestLevel) {
		this(name, material);
		setHarvestLevel(toolClass.className, harvestLevel);
	}
	
	/**
	 * ブロックの名前を設定します。
	 * @param blockName ブロック名
	 * @return 自身
	 */
	@Override
	public Block setBlockName (String blockName) {
		this.blockName = blockName;
		return super.setBlockName(RaitisModCore.MOD_ID + "." + blockName);
	}
	
	/**
	 * ブロックのテクスチャ名を指定します。
	 * @param textureName テクスチャ名
	 * @return 自身
	 */
	@Override
	public Block setBlockTextureName (String textureName) {
		return super.setBlockTextureName(RaitisModCore.MOD_ID + ":" + textureName);
	}
	
	/**
	 * オブジェクトのタイプを取得します。
	 *
	 * @return オブジェクトのタイプ
	 */
	@Override
	public RegisteredObjectType getType () {
		return RegisteredObjectType.BLOCK;
	}
	
	
	/**
	 * 設定されたブロック名を取得します。({@link RaitisModCore#MOD_ID raitismodcore}.は含まれません)
	 *
	 * @return ブロック名
	 */
	@Override
	public String getBlockName () {
		return this.blockName;
	}
}
