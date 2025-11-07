package kotleni.nogl

import com.mojang.blaze3d.textures.GpuTexture
import com.mojang.blaze3d.textures.TextureFormat

class StubGpuTexture(usage: Int, label: String, format: TextureFormat = TextureFormat.RED8, width: Int = 420, height: Int = 420, depthOrLayers: Int = 1,
                     mipLevels: Int =  1
) : GpuTexture(usage, label, format,
    width,
    height,
    depthOrLayers, mipLevels
) {
    override fun close() {

    }

    override fun isClosed(): Boolean {
        return false
    }
}