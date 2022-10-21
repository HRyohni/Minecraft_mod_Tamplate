package net.yohn.tutorialmod.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JewFurnance  extends Block {
    public static  final BooleanProperty LIT = BooleanProperty.create("lit");



    public JewFurnance(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND)
        {
            level.setBlock(blockPos,blockState.cycle(LIT),3); // chnage blokc state
        }
        return super.use(blockState, level, blockPos, player, hand, hitResult);
    }


    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable BlockGetter blockGetter, List<Component> components, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown())
        {
            components.add(Component.literal("Home <3"));
        }
        else
        {
            components.add(Component.literal("press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(itemStack, blockGetter, components, tooltipFlag);
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
