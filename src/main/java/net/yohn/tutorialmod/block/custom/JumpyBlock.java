package net.yohn.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class JumpyBlock  extends Block {
    public JumpyBlock(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (level.isClientSide) // if is client side
        {
            player.sendSystemMessage(Component.literal(("right click")));
        }

        return super.use(state, level, pos, player, hand, hitResult);

    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if (entity instanceof LivingEntity livingEntity) // if is living etitiy
        {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP,200));// 10 seconds
        }
        super.stepOn(level, pos, state, entity);
    }
}