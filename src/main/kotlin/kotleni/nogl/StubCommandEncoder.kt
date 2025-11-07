package kotleni.nogl

import com.mojang.blaze3d.buffers.GpuBuffer
import com.mojang.blaze3d.buffers.GpuBufferSlice
import com.mojang.blaze3d.buffers.GpuFence
import com.mojang.blaze3d.pipeline.RenderPipeline
import com.mojang.blaze3d.systems.CommandEncoder
import com.mojang.blaze3d.systems.RenderPass
import com.mojang.blaze3d.systems.VertexSorter
import com.mojang.blaze3d.textures.GpuTexture
import com.mojang.blaze3d.textures.GpuTextureView
import com.mojang.blaze3d.vertex.VertexFormat
import net.minecraft.client.texture.NativeImage
import java.nio.ByteBuffer
import java.util.OptionalDouble
import java.util.OptionalInt
import java.util.function.Supplier

private object StubRenderPass : RenderPass {
    override fun pushDebugGroup(labelGetter: Supplier<String?>?) {

    }

    override fun popDebugGroup() {

    }

    override fun setPipeline(pipeline: RenderPipeline?) {

    }

    override fun bindSampler(name: String?, texture: GpuTextureView?) {

    }

    override fun setUniform(name: String?, buffer: GpuBuffer?) {

    }

    override fun setUniform(name: String?, slice: GpuBufferSlice?) {

    }

    override fun enableScissor(x: Int, y: Int, width: Int, height: Int) {

    }

    override fun disableScissor() {

    }

    override fun setVertexBuffer(index: Int, buffer: GpuBuffer?) {

    }

    override fun setIndexBuffer(
        indexBuffer: GpuBuffer?,
        indexType: VertexFormat.IndexType?
    ) {

    }

    override fun drawIndexed(
        baseVertex: Int,
        firstIndex: Int,
        count: Int,
        instanceCount: Int
    ) {

    }

    override fun <T : Any?> drawMultipleIndexed(
        objects: Collection<RenderPass.RenderObject<T?>?>?,
        buffer: GpuBuffer?,
        indexType: VertexFormat.IndexType?,
        validationSkippedUniforms: Collection<String?>?,
        `object`: T?
    ) {

    }

    override fun draw(offset: Int, count: Int) {

    }

    override fun close() {

    }
}

private object StubMappedView : GpuBuffer.MappedView {
    private val EMPTY_BUFFER: ByteBuffer = ByteBuffer.allocate(0)
    override fun data(): ByteBuffer? {
        return EMPTY_BUFFER
    }

    override fun close() {}
}


private object StubGpuFence : GpuFence {
    override fun close() {

    }

    override fun awaitCompletion(timeoutNanos: Long): Boolean {
        return true
    }
}

class StubCommandEncoder : CommandEncoder {
    override fun createRenderPass(
        labelGetter: Supplier<String?>?,
        colorAttachment: GpuTextureView?,
        clearColor: OptionalInt?
    ): RenderPass {
        // Return a singleton stub object instead of null
        return StubRenderPass
    }

    override fun createRenderPass(
        labelGetter: Supplier<String?>?,
        colorAttachment: GpuTextureView?,
        clearColor: OptionalInt?,
        depthAttachment: GpuTextureView?,
        clearDepth: OptionalDouble?
    ): RenderPass {
        // Return a singleton stub object instead of null
        return StubRenderPass
    }

    override fun clearColorTexture(texture: GpuTexture?, color: Int) {
        // No operation
    }

    override fun clearColorAndDepthTextures(
        colorAttachment: GpuTexture?,
        color: Int,
        depthAttachment: GpuTexture?,
        depth: Double
    ) {
        // No operation
    }

    override fun clearColorAndDepthTextures(
        colorAttachment: GpuTexture?,
        color: Int,
        depthAttachment: GpuTexture?,
        depth: Double,
        scissorX: Int,
        scissorY: Int,
        scissorWidth: Int,
        scissorHeight: Int
    ) {
        // No operation
    }

    override fun clearDepthTexture(texture: GpuTexture?, depth: Double) {
        // No operation
    }

    override fun writeToBuffer(slice: GpuBufferSlice?, source: ByteBuffer?) {
        // No operation
    }

    override fun mapBuffer(
        buffer: GpuBuffer?,
        read: Boolean,
        write: Boolean
    ): GpuBuffer.MappedView {
        // Return a singleton stub object instead of null
        return StubMappedView
    }

    override fun mapBuffer(
        slice: GpuBufferSlice?,
        read: Boolean,
        write: Boolean
    ): GpuBuffer.MappedView {
        // Return a singleton stub object instead of null
        return StubMappedView
    }

    override fun copyToBuffer(
        from: GpuBufferSlice?,
        to: GpuBufferSlice?
    ) {
        // No operation
    }

    override fun writeToTexture(
        target: GpuTexture?,
        source: NativeImage?
    ) {
        // No operation
    }

    override fun writeToTexture(
        target: GpuTexture?,
        source: NativeImage?,
        mipLevel: Int,
        depth: Int,
        offsetX: Int,
        offsetY: Int,
        width: Int,
        height: Int,
        skipPixels: Int,
        skipRows: Int
    ) {
        // No operation
    }

    override fun writeToTexture(
        target: GpuTexture?,
        buf: ByteBuffer?,
        format: NativeImage.Format?,
        mipLevel: Int,
        depth: Int,
        offsetX: Int,
        offsetY: Int,
        width: Int,
        height: Int
    ) {
        // No operation
    }

    override fun copyTextureToBuffer(
        source: GpuTexture?,
        target: GpuBuffer?,
        offset: Int,
        dataUploadedCallback: Runnable?,
        mipLevel: Int
    ) {
        // Immediately run the callback as there's no async operation.
        dataUploadedCallback?.run()
    }

    override fun copyTextureToBuffer(
        source: GpuTexture?,
        target: GpuBuffer?,
        offset: Int,
        dataUploadedCallback: Runnable?,
        mipLevel: Int,
        intoX: Int,
        intoY: Int,
        width: Int,
        height: Int
    ) {
        // Immediately run the callback as there's no async operation.
        dataUploadedCallback?.run()
    }

    override fun copyTextureToTexture(
        source: GpuTexture?,
        target: GpuTexture?,
        mipLevel: Int,
        intoX: Int,
        intoY: Int,
        sourceX: Int,
        sourceY: Int,
        width: Int,
        height: Int
    ) {
        // No operation
    }

    override fun presentTexture(texture: GpuTextureView?) {
        // No operation
    }

    override fun createFence(): GpuFence {
        // Return a singleton stub object instead of null
        return StubGpuFence
    }
}