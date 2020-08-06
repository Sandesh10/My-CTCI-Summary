Bit Manipulation:

Key Notes:
Integer.toBinaryString(): int -> binary 

------------------------------------------
* 0110 + 0110 = 0110*2 = 0110<<1 (left shift by 1)
* Multiplying by 4 = left shift by 2
0011*4 = 0011<<2 = 1100
* If you XOR a bit with its own negated value, you will always get 1. i.e. a^(~a)= 1
* ~0<<2 = 100

Bit Facts and Tricks
x ^ 0s = x 		x & 0s = 0	   x | 0s = x
x ^ 1s = ~x 	x & 1s = x 	   x | 1s = 1s
x ^ x = 0		x & x = x 	   x | x = x

Note: To understand these expressions, recall that these operations occur bit-by-bit, what happens on one bit never impact the other bits.

TWO'S COMPLEMENT and NEGATIVE NUMBERS

Two's complement =  inverse the bits in positive representation and add 1.
Eg: -3 = sign+inverse bit(011)+1 = 1101

- Negative number is represented as the two's complement of its absolute value (with a 1 in its sign bit to indicate that a negative value.)
- Two's complement of a number N (excluding sign bit) is the complement of the number with respect to 2^N.
Example:
Representation of -3.
	if it's a 4 bit number, we have one bit for sign and 3 bits for value. 
	So, we want complement with repect to 2^3=8 (no of bits for value).
	Complement of 3 w.r.t 8 = 5 = 101
	So, -3 = 1101 in 4 bit representation.

LEFT SHIFT = Multiply by 2.

ARITHMETIC Vs. LOGICAL RIGHT SHIFT

Arithmetic Right Shift = divide by 2.
Eg: 10110101
	|\\\\\\\ 
	110110101
Logical Right Shift = shift the bits right and put 0 in MSB. (indicated as >>>)
Eg: 10110101
	 \\\\\\\
    01011010

What if we keep shifting:
With Logical Shift (x>>>1): we get 0
With arithmetic Shift (x>>1): we get -1

Common Bit Tasks:

Get Bit:
- shift 1 over by i bits. By performing AND with the num, we clear all bits other than the bit at bit i. Finally, we compare that to 0. If that new value is not zero, then bit i must have a 1.

boolean getBit(int num, int i){
	return (num && (1<<i)!=0);
}

Set Bit:
- shift 1 over by i bits. By performing OR with num, only the ith bit will change. All other bits of the mask are zero and will not affect num.

int setBit(int num, int i){
	return num | (1<<i);
}

Clear Bit:
- almost the reverse of setBit

	int ClearBit(int num, int i){
		int mask = ~(1<<i);
		return num & mask;
	}

	int clearMSBthroughI(int num, int i){
		int mask = (1<<i)-1;
		return num & mask;
	}

	int clearBitsIthrough0(int num, int i){
		int mask = (-1<<(i+1));   // -1 is represented as 2's complement 11111111
		return num & mask;
	}

Update Bit:
- clear the ith bit with mask that looks like 11101111.
- shift the value by i bits and or it.

int updateBit(int num, int i, int value){
	int mask = ~(1<<i);
	return (num & mask)| (value<<i);
}

