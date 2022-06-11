package net.frozenblock.wilderwild.entity.render;

import net.frozenblock.wilderwild.WilderWild;
import net.frozenblock.wilderwild.entity.FireflyEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;

public class FireflyEntityRenderer extends EntityRenderer<FireflyEntity> {

    //CREDIT TO magistermaks ON GITHUB!!

    public FireflyEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    private static final Identifier TEXTURE = new Identifier(WilderWild.MOD_ID, "textures/entity/firefly/firefly_off.png");
    private static final Identifier OVERLAY_TEXTURE = new Identifier(WilderWild.MOD_ID, "textures/entity/firefly/firefly_on.png");
    private static final RenderLayer LAYER = RenderLayer.getEntityCutout(TEXTURE);
    private static final RenderLayer OVERLAY = RenderLayer.getEntityTranslucentEmissive(OVERLAY_TEXTURE);

    private final double yOffset = 0.155F;

    @Override
    public void render(FireflyEntity entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        float scale = entity.getScale()==1.5F ? 1.5F : entity.getScale() - (tickDelta * 0.001875F); //0.0375
        matrixStack.push();
        matrixStack.scale(scale, scale, scale);
        matrixStack.translate(0, yOffset, 0);
        matrixStack.multiply(this.dispatcher.getRotation());
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0F));

        MatrixStack.Entry entry = matrixStack.peek();
        Matrix4f matrix4f = entry.getPositionMatrix();
        Matrix3f matrix3f = entry.getNormalMatrix();
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(LAYER);

        int overlay = getOverlay(entity, 0);

        vertex(vertexConsumer, matrix4f, matrix3f, i, 0.0F, 0, 0, 1, overlay);
        vertex(vertexConsumer, matrix4f, matrix3f, i, 1.0F, 0, 1, 1, overlay);
        vertex(vertexConsumer, matrix4f, matrix3f, i, 1.0F, 1, 1, 0, overlay);
        vertex(vertexConsumer, matrix4f, matrix3f, i, 0.0F, 1, 0, 0, overlay);

        matrixStack.pop();

        //OVERLAY
        matrixStack.push();
        matrixStack.scale(scale, scale, scale);
        matrixStack.translate(0, yOffset, 0);
        matrixStack.multiply(this.dispatcher.getRotation());
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180.0F));

        entry = matrixStack.peek();
        matrix4f = entry.getPositionMatrix();
        matrix3f = entry.getNormalMatrix();
        vertexConsumer = vertexConsumerProvider.getBuffer(OVERLAY);

        vertexPulsate(vertexConsumer, matrix4f, matrix3f, i, 0.0F, 0, 0, 1, entity.getFlickerAge(), entity.flickers(), tickDelta, overlay);
        vertexPulsate(vertexConsumer, matrix4f, matrix3f, i, 1.0F, 0, 1, 1, entity.getFlickerAge(), entity.flickers(), tickDelta, overlay);
        vertexPulsate(vertexConsumer, matrix4f, matrix3f, i, 1.0F, 1, 1, 0, entity.getFlickerAge(), entity.flickers(), tickDelta, overlay);
        vertexPulsate(vertexConsumer, matrix4f, matrix3f, i, 0.0F, 1, 0, 0, entity.getFlickerAge(), entity.flickers(), tickDelta, overlay);

        matrixStack.pop();
        super.render(entity, yaw, tickDelta, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(FireflyEntity entity) {
        return TEXTURE;
    }

    private static void vertex(VertexConsumer vertexConsumer, Matrix4f matrix4f, Matrix3f matrix3f, int i, float f, int j, int k, int l, int overlay) {
        vertexConsumer
                .vertex(matrix4f, f - 0.5F, j - 0.5F, 0.0F)
                .color(255, 255, 255, 255)
                .texture(k, l)
                .overlay(overlay)
                .light(i)
                .normal(matrix3f, 0.0F, 1.0F, 0.0F)
                .next();
    }

    private static void vertexPulsate(VertexConsumer vertexConsumer, Matrix4f matrix4f, Matrix3f matrix3f, int i, float f, int j, int k, int l, int age, boolean flickers, float tickDelta, int overlay) {
        int colors = !flickers ? (int) ((int) Math.max((255 * (Math.cos(((age + tickDelta) * Math.PI)/20))),0)) : (int) ((int) (255 * (Math.cos(((age + tickDelta) * Math.PI) / 40))) + 127.5);
        vertexConsumer
                .vertex(matrix4f, f - 0.5F, j - 0.5F, 0.0F)
                .color(colors, colors, colors, colors)
                .texture(k, l)
                .overlay(overlay)
                .light(i)
                .normal(matrix3f, 0.0F, 1.0F, 0.0F)
                .next();
    }

    public static int getOverlay(FireflyEntity entity, float whiteOverlayProgress) {
        return OverlayTexture.packUv(OverlayTexture.getU(whiteOverlayProgress), OverlayTexture.getV(entity.hurtTime > 0 || entity.deathTime > 0));
    }

}
