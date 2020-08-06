COMMON SORTING ALGORITHMS

Bubble Sort
Runtime: O(n^2) avg and worst case
Memory: O(1)
- start at the beginning of the array and swap first two elements if the first is greater than the second. Then we go to the next pair and so on, continuously making sweeps of the array until it is sorted. In doing so, the smaller items slowly "bubble" up to the beginning of the list.

Selection Sort
Runtime: O(n^2) avg and worst case
Memory: O(1)
- simple but inefficient
- Find the smallest element using a linear scan and move it to the front (swapping it with the front element.) Then find second smallest and move it again doing a linear scan. Continue doing this until all the elements are in place.

Merge Sort
Runtime: O(n log(n)) average and worst case
Memory: Depends 
[Here: O(n) due to auxiliary space] 
Merge sort divides the array into half, sorts each of those halves, and then merges them back together. Each of those halves has the same sorting algorithm applied to it.

void mergeSort(int[] array){
	int[] helper = new int[array.length];
	mergeSort(array, helper, 0, array.length-1);
}

void mergeSort(int[] array, int[] helper, int low, int high){
	if (low < high){
		int middle = (low+high)/2;
		// sort left half
		mergesort(array, helper, low, middle);  
		// sort right half
		mergesort(array, helper, middle+1, high);
		// merge them
		merge(array, helper, low, middle, high);
	}
}

void merge(int[] array, int[] helper, int low, int middle, int high) {
	// copy both halves into a helper array
	for (int i=low, i<=high; i++){
		helper[i] = array[i];
	}

	int helperLeft = low;
	int helperRight = middle+1;
	int current = low;

	/*
	Iterate through helper array. Compare the left and right half, copying back the smaller element from the
	two halves into the original array */

	while (helperLeft <=middle && helperRight<=high){
		if (helper[helperLeft]<= helper[helperRight]) {
			array[current]= helper[helperLeft];
			helperLeft++;
		}else {
			array[current]=helper[helperRight];
			helperRight++;
		}
		current++;
	}

	/* copy rest of the left side of the array into the target array*/
	int remaining = middle - helperLeft;
	for(int i=0;i<= remaining;i++){
		array[current + i] = helper[helperLeft+1];
	}
}


Quick Sort
Runtime: average O(n log(n)), worst: O(n^2)
Memory: O(log(n))
- we pick a random element and partition the array, such that all numbers that are less than the partitioning element comes before all elements that are greater than it. The partitioning can be performed efficiently throguh a series of swaps.
- If we repeatedly partition the array around an element, the array will eventually become sorted. However, as the partitioned elements is not guaranteed to be a median, our sorting could be very slow. This is the reason for the O(n^2) worst case runtime.

void quickSort(int[] arr, int left, int right){
	int index = partition(arr, left, right);
	if (left < index-1){
		quickSort(arr, left, index-1);
	}
	if (index < right) {
		quicksort(arr, index+1, right);
	}
}

int partition(int[] arr, int left, int right){
	// pick the pivot
	int pivot = arr[(left+right)/2];
	while (left <= right){
		// find element on left that should be on right
		while (arr[left] < pivot) left++;

		// find elements on right that should be on left
		while (arr[right]> pivot) right--;

		if (left <= right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}
	return left;
} 

Radix Sort 
Runtime: O(kn)
- sorting algorithm for integers that takes advantage of the fact that integers have a finite number of bits. In radix sort, we iterate through each digit of the number, group numbers by each digit.
For eg: if we have an array of integers, we might first sort by the first digit, so that the 0s are grouped together. Then, we sort each of these groupings by the next digit. We repeat this process sorting by each subsequent digitm until finally the whole array is sorted.
- Radix sort has a runtime of O(kn) where
  n = number of elements
  k = number of passes of the sorting algorithm.   


Searching Algorithm: Binary Search:

int binarySearch(int[] a, int x){
	int low =0;
	int high = a.length -1;
	int mid;

	while (low <= high) {
		mid = (low + high)/2;
		if (a[mid] < x){
			low = mid +1;
		} else if (a[mid] >x){
			high = mid -1;
		}else{
			return mid;
		}
	}
	return -1;
}