Prime Numbers

// check for primality
boolean primeNumber(int n){
	if (n<2){
		return false;
	}
	for (int i=2;i<= Math.sqrt(n);i++){
		if (n % i ==0) return false;
	}
	return true;
}

----------------------------------------------
Generating List of Primes

boolean[] generatePrimes(int max){
	boolean[] flags = new boolean[max+1];
	int count =0;

	init(flags) // set all flags to true other than 0 and 1
	int prime = 2;

	while (prime <= Math.sqrt(max)){
		// cross off remaining multiples of prime
		crossOff(flags, prime);

		// Find next value which is true
		prime = getNextPrime(flags, prime);
	}
	return flags;
}

void crossOff(boolean[] flags, int prime){
	/* We start with primee*prime because if we have k*prime, where k < prime, this value would have already been crossed off earlier */
	for(int i = prime*prime; i< flags.length;i+=prime){
		flags[i] = false;
	}
}

int getNextPrime(boolean[] flags, int prime){
	int next = prime+1;
	while (next < flags.length && !flags[next]){
		next++;
	}
	return next;
}

----------------------------------------------
PROBABILITY

P(A or B) = P(A) + P(B) - P(A and B)

Bayes' Therem
P(A|B) = P(B|A) * P(A) / P(B)

If A and B are independent, 
P(A and B) =  P(A) + P(B)

Mutually exclusive: if one happens, the other cannot happen.
P(A or B) = P(A) + P(B)

NOTE:
Two events CANNOT be both INDEPENDENT and MUTUALLY EXCLUSIVE (provided both have
probabilities greater than 0). Why? Because mutual exclusivity means that if one happens then the other cannot. Independence, however, says that one event happening means absolutely nothing about the other event.

