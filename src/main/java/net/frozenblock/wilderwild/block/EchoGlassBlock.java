package net.frozenblock.wilderwild.block;

import net.frozenblock.wilderwild.registry.RegisterProperties;
import net.frozenblock.wilderwild.registry.RegisterSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.AbstractRandom;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class EchoGlassBlock extends TintedGlassBlock {
    public static final IntProperty DAMAGE = RegisterProperties.DAMAGE;

    public EchoGlassBlock(Settings settings) {
        super(settings);
        this.setDefaultState( this.getDefaultState().with(DAMAGE, 0));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DAMAGE);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, AbstractRandom random) {
        int light = getLightLevel(world, pos);
        if (light<=7) {
            if (random.nextBoolean()) {
                heal(world, pos);
            }
        } else {
            damage(world, pos);
        }
    }

    public static void damage(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.get(DAMAGE)<3) {
            world.setBlockState(pos, state.with(DAMAGE, state.get(DAMAGE) + 1));
            world.playSound(null, pos, RegisterSounds.BLOCK_ECHO_GLASS_CRACK, SoundCategory.BLOCKS, 1.0F, 1.0F);
        } else {
            world.breakBlock(pos, false);
        }
    }
    public static void heal(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.get(DAMAGE)>0) {
            world.setBlockState(pos, state.with(DAMAGE, state.get(DAMAGE) - 1));
            world.playSound(
                    null,
                    pos,
                    RegisterSounds.BLOCK_ECHO_GLASS_REPAIR,
                    SoundCategory.BLOCKS,
                    1.0F,
                    world.random.nextFloat() * 0.1F + 0.9F
            );
        }
    }

    public static int getLightLevel(World world, BlockPos blockPos) {
        int finalLight=0;
        for (Direction direction : DIRECTIONS) {
            BlockPos pos = blockPos.offset(direction);
            int skyLight = 0;
            int blockLight = world.getLightLevel(LightType.BLOCK, pos);
            if (world.isDay() && !world.isRaining()) {
                skyLight = world.getLightLevel(LightType.SKY, pos);
            }
            finalLight = Math.max(finalLight, Math.max(skyLight, blockLight));
        }
        return finalLight;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) { return true; }
}