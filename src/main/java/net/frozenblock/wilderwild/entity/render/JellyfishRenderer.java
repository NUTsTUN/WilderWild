package net.frozenblock.wilderwild.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.frozenblock.wilderwild.WilderWild;
import net.frozenblock.wilderwild.WilderWildClient;
import net.frozenblock.wilderwild.entity.Jellyfish;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class JellyfishRenderer extends MobRenderer<Jellyfish, JellyfishModel<Jellyfish>> {

    private static final String BASE_TEXTURE = "textures/entity/jellyfish/";

    public JellyfishRenderer(Context context) {
        super(context, new JellyfishModel<>(context.bakeLayer(WilderWildClient.JELLYFISH)), 0.3F);
    }

    @Override
    public void setupRotations(@NotNull Jellyfish jelly, PoseStack poseStack, float f, float g, float h) {
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0f - g));
        poseStack.translate(0, -1, 0);
        poseStack.scale(0.8F, 0.8F, 0.8F);
        JellyfishModel<Jellyfish> model = this.getModel();
        if (jelly.hasCustomName() && "I_am_Merp".equals(jelly.getName().getString())) {
            float time = f / 20F;
            float twoThirdsPI = (2F / 3F) * Mth.PI;

            model.red = Math.max(Mth.cos(time), 0);
            model.green = Math.max(Mth.cos(time - twoThirdsPI), 0);
            model.blue = Math.max(Mth.cos(time - (twoThirdsPI * 2F)), 0);

        } else {
            model.red = 1;
            model.green = 1;
            model.blue = 1;
        }
    }

    @Override
    protected int getBlockLightLevel(@NotNull Jellyfish jellyfish, @NotNull BlockPos blockPos) {
        return 15;
    }

    @Override
    @Nullable
    protected RenderType getRenderType(@NotNull Jellyfish jellyfish, boolean bl, boolean bl2, boolean bl3) {
        if (jellyfish.hasCustomName() && "I_am_Merp".equals(jellyfish.getName().getString())) {
            return WilderWildClient.ENTITY_TRANSLUCENT_EMISSIVE_FIXED.apply(WilderWild.id(BASE_TEXTURE + "white" + ".png"), false);
        }
        return WilderWildClient.ENTITY_TRANSLUCENT_EMISSIVE_FIXED.apply(WilderWild.id(BASE_TEXTURE + jellyfish.getVariant() + ".png"), false);
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull Jellyfish jellyfish) {
        return WilderWild.id(BASE_TEXTURE + jellyfish.getVariant() + ".png");
    }

    @Override
    public void render(Jellyfish entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }
}
