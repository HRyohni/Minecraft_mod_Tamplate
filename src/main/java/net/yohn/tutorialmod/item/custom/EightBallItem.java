package net.yohn.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallItem extends Item {
    public EightBallItem(Properties properties) {
        super(properties);
    } // must be yellow **EightBallItem**


    @Override // right click item
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) // not on server side
        {
            // output a random nummber
            outputRandomNummber(player);
            // set a cooldown
            player.getCooldowns().addCooldown(this,20);// adding cooldown 20 ticks

        }

        return super.use(level, player, hand);
    }

    @Override // for giving more discription
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown())
        {
            components.add(Component.literal("right click to go to auschwitch!"));
        }
        else
        {
            components.add(Component.literal("press SHIFT for more info").withStyle(ChatFormatting.BLACK));
        }

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    private  void   outputRandomNummber(Player player)
    {
        player.sendSystemMessage(Component.literal(GetJewtifyed()));
    }

    private int getRandomNummber()
    {
        return RandomSource.createNewThreadLocalInstance().nextInt(1); // random nummber
    }

    private  String GetJewtifyed()
    {
                    // disclamer ovo je grijeh i jako se lose osjecam oko ovoga...

        switch (getRandomNummber())
        {
            case 0:
                return "Straight to auschwitz!";
            case 1:
                return "Straight to prison!";
            default:
                return "safe";
        }
    }
}
