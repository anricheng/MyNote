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

//这是用来测试的主函数；
int main(int argc, char const *argv[])
{
	int n=1000;
	int *arr=SortTestHelper::generateRandomArray(n,0,n);
	int *arr2=SortTestHelper::copyArray(arr,n);
	int *arr3=SortTestHelper::copyArray(arr,n);
	//测试排序和打印的函数是否正确
	selectionSort(arr,n);
	SortTestHelper::printArray(arr,n);
	//测试时间复杂度的函数是否正确
	SortTestHelper::testSort("selectionSort",selectionSort,arr,n);

	SortTestHelper::testSort("insertSort",insertSort,arr2,n);

	SortTestHelper::testSort("advancedInsertSort",advanceInsertSort,arr3,n);
	// for (int i = 0; i < 10; ++i)
	// {
	// 	cout<<arr[i]<<" ";
	// }
	// cout<<endl;
	delete[] arr;
	delete[] arr2;
	delete[] arr3;

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
