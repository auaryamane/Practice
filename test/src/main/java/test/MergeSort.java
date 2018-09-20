package test;

public class MergeSort {
	public void mergeSort(int[] array, int left, int right){
		if(array.length > 0){
			mergeSort(array,left,(right-left)/2);
			merge(array,left,(right-left)/2,1);
		}
	}
	public void merge(int[] array, int left,int mid, int right){
		int temp[] = new int[array.length];
		int i = 0;
		for(int num : array){
			temp[i] = num;
			i++;
		}
		int l = left;
		int r = right;
		int m = mid+1;
		while(l<=mid && m <r){
			if(temp[l]<temp[m]){
				array[l] = temp[m];
				array[m] = temp[l];
				
			}
		}
	}
	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,7};
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(array, 0, 6);
	}
}
