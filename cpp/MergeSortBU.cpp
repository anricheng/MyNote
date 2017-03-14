#include <iostream>
#include <algorithm>
#include <string>
#include "sortTestHelper.h"
using namespace std;
template<typename T>
void mergeSortBu(T arr[], int n){
 // 第一次就两个进行排序，排完顺序之后每个小的分组里面的元素是有序的，针对每个有序的小组的元素进行第二轮的排序，之后依次增加

 // 每一轮需要进行排序的数组的个数是:第一轮是元素的总数/2,如果数组的个数是奇数个的话那么最后一个元素一直留到最后一轮才加入前面的排序中
 // 循环的开始和结束：开始的时候循环的size是2,每次都double一下，最后一次循环要保证它的整个大小要小于整个数组的大小
 // 在每一轮的循环中需要排序的数组的跨度都是本次排序时候两个数组的总和
//思路整理：
// 将数组拆分为单个元素一组，然后每次相邻的一组进行比较并合并，依次向上累加；
// 最外层循环：要merge的次数；第一次是两个元素进行merge,第二次是四个，依次往上累加，直至最后依次整个数组的两部分进行累加
// 内层循坏：这是个merge的循环，每次要merge的分组，在每一轮的循环当中，需要merge的数组的个数有，
	//循环遍历整个
	for (int size =1;size<=n;size+=size)
		//每次跨过两个size大小的区域，每次这两个大小的区域进行merge的操作
		for (int i=0;i<n;i+=size+size)
			//针对arr[i...i+size-1]和arr[i+size...i+2*size-1]进行归并
			__merge(arr,i,i+size-1,i+size+size-1);
}

int main(){

	return 0;
}