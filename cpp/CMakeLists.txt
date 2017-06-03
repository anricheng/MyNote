cmake_minimum_required(VERSION 3.4)
project(cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES
    aric.cpp
    MergeSortBU.cpp
    sortTestHelper.h SelectSort.h)

add_executable(cpp ${SOURCE_FILES})