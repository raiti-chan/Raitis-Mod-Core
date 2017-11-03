package com.raitichan.raitismodcore.register;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.raitichan.raitismodcore.block.IRBlock;
import com.raitichan.raitismodcore.block.SimpleMetaBlock;
import com.raitichan.raitismodcore.item.IRItem;
import com.raitichan.raitismodcore.item.RItem;
import com.raitichan.raitismodcore.item.SimpleMetaItem;
import com.raitichan.raitismodcore.item.blockItem.RItemBlockWithMetadata;
import com.raitichan.raitismodcore.util.IRegisteredObject;
import com.raitichan.raitismodcore.util.annotations.NonRegister;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * レジスタークラス。
 * <br>Created by Raiti-chan on 2017/10/30.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@SuppressWarnings("WeakerAccess")
public class Register implements IRegister {
	
	//==================================================================================================================
	
	/**
	 * Raiti's Mod のデフォルトのタブ
	 */
	public static final CreativeTabs RAITIS_MOD_CORE_TAB = new CreativeTabs("raitismodcore") {
		@Override
		public Item getTabIconItem () {
			return Items.apple;
		}
	};
	public static final RItem COMPRESSED_STONE = new SimpleMetaItem("compressed_stone", 3);
	public static final RItem EMC_ITEM = new SimpleMetaItem("emc_item", 21);
	//==================================================================================================================
	public static final SimpleMetaBlock EMC_BLOCK = new SimpleMetaBlock("emc_block", Material.rock, 16);
	
	//=Item=============================================================================================================
	/**
	 * クラスのインスタンス
	 */
	private static final Register INSTANCE = new Register();
	/**
	 * 外からインスタンス化できないように。
	 */
	private Register () {
	}
	
	//=Block============================================================================================================
	
	/**
	 * インスタンスを取得します。
	 *
	 * @return インスタンス
	 */
	public static Register getInstance () {
		return INSTANCE;
	}
	
	//==================================================================================================================
	
	/**
	 * レジスタを初期化します。
	 */
	public static void register (IRegister register) {
		Class<? extends IRegister> registerClass = register.getClass();
		Field[] fields = registerClass.getFields();
		for (Field field : fields) {
			if (field.getAnnotation(NonRegister.class) != null) continue;
			try {
				Object o = field.get(null);
				if (o instanceof IRegisteredObject) {
					switch (((IRegisteredObject) o).getType()) {
						case ITEM: {
							registerItem((Item) o);
							break;
						}
						case BLOCK: {
							registerBlock((Block) o);
							break;
						}
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		register.recipeRegister();
	}
	
	/**
	 * アイテムをレジストリに登録します。
	 * @param item 登録するアイテム
	 */
	private static void registerItem (Item item) {
		item.setCreativeTab(RAITIS_MOD_CORE_TAB);
		GameRegistry.registerItem(item, ((IRItem) item).getItemName());
	}
	
	/**
	 * ブロックをレジストリに登録します。
	 * @param block 登録するブロック
	 */
	private static void registerBlock (Block block) {
		block.setCreativeTab(RAITIS_MOD_CORE_TAB);
		if (block instanceof SimpleMetaBlock) {
			GameRegistry.registerBlock(block, RItemBlockWithMetadata.class, ((IRBlock) block).getBlockName());
			return;
		}
		
		GameRegistry.registerBlock(block, ((IRBlock) block).getBlockName());
		
	}
	
}
