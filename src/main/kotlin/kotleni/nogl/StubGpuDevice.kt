package kotleni.nogl

import com.mojang.blaze3d.buffers.GpuBuffer
import com.mojang.blaze3d.pipeline.CompiledRenderPipeline
import com.mojang.blaze3d.pipeline.RenderPipeline
import com.mojang.blaze3d.shaders.ShaderType
import com.mojang.blaze3d.systems.CommandEncoder
import com.mojang.blaze3d.systems.GpuDevice
import com.mojang.blaze3d.textures.GpuTexture
import com.mojang.blaze3d.textures.GpuTextureView
import com.mojang.blaze3d.textures.TextureFormat
import net.minecraft.util.Identifier
import java.nio.ByteBuffer
import java.util.function.BiFunction
import java.util.function.Supplier

class StubGpuDevice : GpuDevice {
    override fun createCommandEncoder(): CommandEncoder? {
        return StubCommandEncoder()
    }

    override fun createTexture(
        labelGetter: Supplier<String?>?,
        usage: Int,
        format: TextureFormat?,
        width: Int,
        height: Int,
        depthOrLayers: Int,
        mipLevels: Int
    ): GpuTexture? {
        if(labelGetter == null) return null
        if(format == null) return null
        return StubGpuTexture(usage, labelGetter.get() ?: "unnamed-gpu-texture", format, width, height, depthOrLayers, mipLevels)
    }

    override fun createTexture(
        label: String?,
        usage: Int,
        format: TextureFormat?,
        width: Int,
        height: Int,
        depthOrLayers: Int,
        mipLevels: Int
    ): GpuTexture? {
        if(label == null) return null
        if(format == null) return null
        return StubGpuTexture(usage, label, format, width, height, depthOrLayers, mipLevels)
    }

    override fun createTextureView(texture: GpuTexture?): GpuTextureView? {
        if(texture == null) return null
        return StubGpuTextureView(texture)
    }

    override fun createTextureView(
        texture: GpuTexture?,
        baseMipLevel: Int,
        mipLevels: Int
    ): GpuTextureView? {
        if(texture == null) return null
        return StubGpuTextureView(
            texture,
        )
    }

    override fun createBuffer(
        labelGetter: Supplier<String?>?,
        usage: Int,
        size: Int
    ): GpuBuffer? {
        return StubGpuBuffer(usage, size)
    }

    override fun createBuffer(
        labelGetter: Supplier<String?>?,
        usage: Int,
        data: ByteBuffer?
    ): GpuBuffer? {
        return StubGpuBuffer(usage, 1024)
    }

    override fun getImplementationInformation(): String? {
        return "Just a stub."
    }

    override fun getLastDebugMessages(): List<String?>? {
        return listOf()
    }

    override fun isDebuggingEnabled(): Boolean {
        return false
    }

    override fun getVendor(): String? {
        return "kotleni"
    }

    override fun getBackendName(): String? {
        return "stub"
    }

    override fun getVersion(): String? {
        return "v1.0"
    }

    override fun getRenderer(): String? {
        return "StubRenderer"
    }

    override fun getMaxTextureSize(): Int {
        return 1024
    }

    override fun getUniformOffsetAlignment(): Int {
        return 32
    }

    override fun precompilePipeline(
        pipeline: RenderPipeline?,
        sourceRetriever: BiFunction<Identifier?, ShaderType?, String?>?
    ): CompiledRenderPipeline? {
        return CompiledRenderPipeline { true }
    }

    override fun clearPipelineCache() {

    }

    override fun getEnabledExtensions(): List<String?>? {
        return listOf()
    }

    override fun close() {

    }
}