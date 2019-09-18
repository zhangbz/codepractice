/**
 * 数值的整数次方
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
 *
 * 因为返回值是double所以不需要考虑大数问题
 * 需要考虑正数、负数、0
 *
 */
public class Solution11 {
    public double Power(double base, int exponent) {
        if (exponent >= 0) {
            return powerWithUnsignedExponent(base, exponent);
        } else {
            return 1/ powerWithUnsignedExponent(base,-exponent);
        }

    }

    double powerWithUnsignedExponent(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        if (exponent ==1) return base;

        if (exponent % 2 ==1) {
            return powerWithUnsignedExponent(base, exponent/2) * powerWithUnsignedExponent(base, exponent/2)* base;
        } else {
            return powerWithUnsignedExponent(base, exponent/2) * powerWithUnsignedExponent(base, exponent/2);
        }
    }
}
