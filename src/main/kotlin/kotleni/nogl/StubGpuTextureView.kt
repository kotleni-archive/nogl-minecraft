package kotleni.nogl

import com.mojang.blaze3d.textures.GpuTexture
import com.mojang.blaze3d.textures.GpuTextureView

class StubGpuTextureView(texture: GpuTexture, baseMipLevel: Int = 1,
                         mipLevels: Int = 1
) : GpuTextureView(texture, baseMipLevel, mipLevels) {
    override fun close() {

    }

    override fun isClosed(): Boolean {
        return true
    }
}