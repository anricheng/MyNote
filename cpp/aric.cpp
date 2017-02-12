#ifndef ZHOU_HAI_FENG
#define ZHOU_HAI_FENG
#include <iostream>
#include <algorithm>
#include <string>
#include "sortTestHelper.h"
using namespace std;
template<typename T>
//这是一个选择排序
		void selectionSort(T arr[], int n){
			//遍历整个数组
			for (int i = 0; i < n; ++i){
				//找出这个数组中的最小的值
				//首先设定这个最小的值就是i
				int miniIndex = i;
			    //将i之后的所有数据跟i比较，如果它比i小则将这个最小的
				for (int j = i+1; j < n; ++j)
				{
					if(arr[j]<arr[i]){
						miniIndex = j;
						swap(arr[i],arr[miniIndex]);
					}
				}
			}

		}
//这是插入排序: 第一个元素不动，第二个元素跟前面的元素比较并放在一个合适的位置
		template<typename T>
		void insertSort(T arr[], int n){
		//第1个元素开始遍历，第0个不用排序
        for (int i = 1; i < n; ++i)
        {
        	//j是当前的元素，当两两进行比较的时候，它是跟j-1比较，所以最后比较的条件是就j>0;
        	for (int j=i; j>0; j--)
        	{
        		if(arr[j]<arr[j-1])
        			swap(arr[j], arr[j-1]);
        		else
        			break;
        	}
        }
		}
		//改进的思想就是多做比较少做赋值操作，因为赋值操作更加的耗时
		//将i处需要比较的元素单独拿出来跟前面的每一个元素进行比较，只要他比比较的这个元素小，那么
		//它肯定排在前面，它要排在前面那么当前这个元素就需要向后面挪动一个单位，如此一直到最后一个元素；
		template <typename T>
		void advanceInsertSort(T arr[], int n){
			for (int i = 1; i < n; ++i)
			{
				int j;
				T temp = arr[i];
				for (j = i; j>0&&temp<arr[j-1]; --j)
				arr[j]=arr[j-1];//向后面挪动一个位置；
				arr[j]=temp;
			}
		}

//此函数用来排序原数组中已经排好序的两部分数组合并：两个数组分别为[start,middle-1][middle,end-1]
// 首先排除当i > middle-1 跟 j > end的情况，这两种情况表明其中一个分数组中的元素已经完全的copy进入原数组了。
template<typename T>
void sortTwoPartSortedArray(T arr[], int start,int middle,int end){
	//定义一个临时数组用来存储原数组中需要排序的两个相邻的分数组；
	T auxArray[end - start + 1];
	// 将原数组中的元素copy过来；
	for(int i=start;i<=end;i++)
		auxArray[i - start]=arr[i];
	//循环比较两个分数组对应位置数据的大小进行merge操作
	int i=0;
	int k=0;
	int j=middle;
	for(;k<= end - middle + 1;k++){
		if (i > middle-1){
			 arr[k]=auxArray[j];
			j++;
		
		}else if(j > end){
          	arr[k]=auxArray[i];
			i++;
		}else if (auxArray[i]<auxArray[j])
		{
			arr[k]=auxArray[i];
			i++;
		}else{
			arr[k]=auxArray[j];
			j++;
		}
	}

}
//归并排序-从上到下的排序；
template<typename T>
void mergeSort(T arr[], int n){
	//根第一轮循环是找到需要merge的数组的个数：根据每一次循环的时候需要merge的两个分数组的大小进行循环遍历，一直到这两个分数组的大小合并起来已经比整个数组的大小大了
	// 比如说第一次需要merge的两个分数组的大小是1，第二次是需要merge的两个分数组的大小是2，直到需要被merge的这个分数组的大小跟这个数组的大小一样大
	// 所以循环的条件就是：for(int size=1;size<=n;size+=size)
	for (int sz=1;sz<=n;sz+=sz)
		// 找出每次需要merge的两个分数组在数组中的位置，比如说第一次两个分数组在整个数组中的位置是：[0,size-1],[size,2*size-1],每次循环的跨度刚好是2*size个元素；
		for(int st=0;st<n;st+=sz+sz){
			//merge 两个数组的操作，建立一个中间的数组，将原数组中两个分数组所占位置的元素全部copy进来，然后设置两个分数组的起始位置以及原数组中的起始位置
			// 设置分数组中的起始位置为：i ,j 设置原数组中需要排序的位置的起始位置为：k
			//需要传递的参数就是数组的起始位置、中间位置、结束位置
			sortTwoPartSortedArray(arr,st,st+sz-1,st+sz+sz-1);
		}
}


//归并排序
template<typename T>
void mergeSortSecond(T arr[], int n){
	//1.从上到下的归并排序

	//2.从下到上的归并排序
	//首先分，一直分到底,这是一个递归的操作；
	//递归的结束条件就是
}

//这是用来测试的主函数；
int main(int argc, char const *argv[])
{
	int array[]={1,3,5,7,2,4,6,8};
	sortTwoPartSortedArray(array,0,3,7);
	SortTestHelper::printArray(array,8);

	int n=10;
	int *arr=SortTestHelper::generateRandomArray(n,0,n);
	int *arr2=SortTestHelper::copyArray(arr,n);
	int *arr3=SortTestHelper::copyArray(arr,n);
	int *arr4=SortTestHelper::copyArray(arr,n);
	//测试排序和打印的函数是否正确
	// selectionSort(arr,n);
	// SortTestHelper::printArray(arr,n);
	// //测试时间复杂度的函数是否正确
	// SortTestHelper::testSort("selectionSort",selectionSort,arr,n);

	// SortTestHelper::testSort("insertSort",insertSort,arr2,n);

	// SortTestHelper::testSort("advancedInsertSort",advanceInsertSort,arr3,n);
	SortTestHelper::testSort("mergeSort",mergeSort,arr4,n);
	// for (int i = 0; i < 10; ++i)
	// {
	// 	cout<<arr[i]<<" ";
	// }
	// cout<<endl;
	delete[] arr;
	delete[] arr2;
	delete[] arr3;
	delete[] arr4;


	// float b[10]={10.1,9.6,8.5,4.3,6.5,5.6,4.6,3.1,2.0,1.6};
	// selectionSort(b,10);
	// for (int i = 0; i < 10; ++i)
	// {
	// 	cout<<b[i]<<" ";
	// }
	// cout<<endl;

	// string c[5]={"c","aric","ZHOU","zhen","jia"};
	// selectionSort(c,5);
	// for (int i = 0; i < 5; ++i)
	// {
	// 	cout<<c[i]<<" ";
	// }
	// cout<<endl;
	// return 0;
}

#endif
