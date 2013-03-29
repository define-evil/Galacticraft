package micdoodle8.mods.galacticraft.core.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GCCoreItemCanister extends Item
{
	public static final String[] names = {
		"tin", // 0
		"copper"}; // 1

	protected Icon[] icons = new Icon[256];

	public GCCoreItemCanister(int par1)
	{
		super(par1);
		this.setMaxStackSize(1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}

	@Override
    public CreativeTabs getCreativeTab()
    {
        return GalacticraftCore.galacticraftTab;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister iconRegister)
	{
		int i = 0;
		
		for (String name : this.names)
		{
			this.icons[i++] = iconRegister.registerIcon("galacticraftcore:canister_" + name + GalacticraftCore.TEXTURE_SUFFIX);
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return "item." + "canister." + GCCoreItemCanister.names[itemStack.getItemDamage()];
	}

	@Override
	public Icon getIconFromDamage(int damage)
	{
		if (this.icons.length > damage)
		{
			return this.icons[damage];
		}

		return super.getIconFromDamage(damage);
	}

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	for (int i = 0; i < 2; i++)
    	{
            par3List.add(new ItemStack(par1, 1, i));
    	}
    }

    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }
}
