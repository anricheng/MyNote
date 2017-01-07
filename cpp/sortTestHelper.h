#ifndef ZHOU_H
#define ZHOU_H
#include <iostream>
#include <ctime>
#include <cassert>
using namespace std;
namespace SortTestHelper{
	//生成一个拥有n个元素的随机数组，每个元素的随机范围为：[rangeL,rangeR]
	int * generateRandomArray(int n, int rangeL,int rangeR){
		assert(rangeL<rangeR);
		int *arr = new int[n];
		srand(time(NULL));
		for (int i = 0; i < n; ++i)
		{
			arr[i]=rand()%(rangeR - rangeL + 1) + rangeL;
		}
		return arr;
	}
	template<typename T>
	void printArray(T arr[],int n){
		for (int i = 0; i < n; ++i)
		{
			cout<<arr[i]<<" ";
		}
		cout<<endl;
		return;
	}

	//定义一个函数去判断一个数组是不是已经被排列了，如果已经被排列了则返回true,没有则返回false;
	template<typename T>
	bool isSorted(T arr[], int n){
		//要判断一个数组是不是从小到大排列，我只需要从小到大每两只数据直接进行比较，只要每次的比较都是后一个数据比前一个数据大，那么它就是已经从小到大排列好的
		for (int i = 0; i < n-1; ++i)
			//因为是i跟i+1进行比较，所以i只能到i<n-1;
			if(arr[i]>arr[i+1])
				return false;
			return true;
	}
//传递函数指针：void(*sort)(T[],int),将这个函数指针传递过来，然后去测试这个函数的性能
	template<typename T>
	void testSort(string sortName,void(*sort)(T arr[],int),T arr[],int n){
		clock_t startTime = clock();
		sort(arr,n);
		clock_t endTime = clock();

		assert(isSorted(arr,n));
		cout <<sortName<<":"<<double(endTime - startTime) / CLOCKS_PER_SEC<<"s"<<endl;
       return;
	}
//建立一个copy 数组的方法:它的返回值是一个int型的数组也就是int *;
	template<typename T>
	T* copyArray(T arr[], int n){
		T* copyArr = new T[n];
		copy(arr,arr+n,copyArr);
		return copyArr;
	}

}
#endif