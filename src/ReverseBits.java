public class ReverseBits {
    // you need treat n as an unsigned value

    /**
     * Voy partiendo el numero en mitades y swapeando esas mitades.
     * 12|34 -> 3|4|1|2 -> 4321
     * Con bits, el AND me va a mantener el la seccion del bit que quiero
     * y despues lo shifteo. El OR me va a juntar ambas mitades swapeadas.
     */
    public int reverseBits(int num) {

        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);

        return num;

    }
}
