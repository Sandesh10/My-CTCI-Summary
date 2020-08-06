/*
Magic Index: A magic index in an array A [1. .. n -1] is defined to be an index such that A[ i]
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.
FOLLOW UP
What if the values are not distinct?
*/

int magicFast(int[] array){
	return magicFast(array, 0, array.length -1);
}

int magicFast(int[] array, int start, int end){
	if (end < start){
		return -1;
	}
	int mid =  (end+start)/2;
	if (array[mid]=mid){
		return mid;
	}else if (array[mid]> mid){
		return magicFast(array, start, mid-1);
	}else {
		return magicFast(array, mid+1,end);
	}
}

FOLLOW UP: IF ELEMENTS ARE NOT distinct
/*
If midIndex and midValue are not equal then, we recursively
search the left and right as follows:

Left side: search indices starting with min(mid-1,midValue);
Right side: search stearting max(midvalue, mid+1);
*/

int magicFast(int[] array){
	return magicFast(array, 0, array.length-1);
}

int magicFast(int[] array, int start, int end){
	if (end < start){
		return -1;
	}
	int mid = (start+end)/2;
	int midVal = array[mid];
	if (mid== midVal){
		return mid;
	}
	int leftIndex = Math.min(mid-1, midVal);
	int left = magicFast(start, leftIndex);
	if (left >=0){
		return left;
	}

	int rightIndex = Math.max(mid+1, midVal);
	int right = magicFast(rightIndex, end);
	if (mid == midVal){
		return right;
	}

}