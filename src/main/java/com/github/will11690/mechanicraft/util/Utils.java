package com.github.will11690.mechanicraft.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.items.ItemStackHandler;

public class Utils {
	
    public static String withSuffix(int count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.1f%c",
                count / Math.pow(1000, exp),
                "kMGTPE".charAt(exp - 1));
    }

    private static final BigDecimal TWENTY = new BigDecimal(20);
    public static String ticksInSeconds(int ticks) {
        BigDecimal value = new BigDecimal(ticks);
        value = value.divide(TWENTY, 1, RoundingMode.HALF_UP);
        return value.toString();
    }

	public static int calculateRedstone(ItemStackHandler handler) {
		
		int i = 0;
		float f = 0.0F;
		for (int j = 0; j < handler.getSlots(); j++) {
			
			ItemStack stack = handler.getStackInSlot(j);
			
			if (!stack.isEmpty()) {
				
				f += (float) stack.getCount() / (float) Math.min(handler.getSlotLimit(j), stack.getMaxStackSize());
				i++;
				
			}
			
		}
		
		f = f / (float) handler.getSlots();
		return MathHelper.floor(f * 14.0F) + (i > 0 ? 1 : 0);
		
	}
}