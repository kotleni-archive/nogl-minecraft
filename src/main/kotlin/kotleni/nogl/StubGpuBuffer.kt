package kotleni.nogl

import com.mojang.blaze3d.buffers.GpuBuffer

class StubGpuBuffer(var usage: Int, val size: Int) : GpuBuffer(usage, size) {
    override fun isClosed(): Boolean {
        return false
    }

    override fun close() {

    }
}