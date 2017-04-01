print('我是周海峰')
100<99
print(100<99)
print(0Xff==255)#这是注释部分

print("我是周海峰")

a=12344#pathon 中使用的是动态语言
print(a)

x=10
x=x+10
print(x)
print('python is dynamic programme language')
'''
在python 中转义字符要用\表示:
例如:\' \"
但是如果字符串中有很多的转义字符且不包括单引号和双引号,那么可以用r直接标注这个字符串
但是r不能表示多行字符串,多行请使用六个双引号,如果六个双引号没有被赋值就说明是注释,被赋值了就说明是一个多行的字符串
'''
print(r'\(~_~)/ \(~_~)/')


#在Python中如果出现UnicodeDecodeError 则在首行加入# -*- coding: utf-8 -*-

'''
list=[]
list[0]  list是有序的集合,可以用索引进行查找。同时list可以进行倒序的查找:在索引的前面加入负号 list[-1]代表倒数的第一个
注意不要越界
list 在末尾添加新元素: append(item)
list在任意位置添加新元素:insert(location,item)
list 删除末尾的元素:pop()
list删除任意位置的元素pop(location)
list替换某个位置的元素: list[-1]='海峰'

'''



'''
tuple 元组 不可更改  其中的item可以是一个list
使用()代替【】
当tuple 中只有一个元素的时候必须用逗号去区分单个带有优先级的数据: t=(1,)
'''


'''
if 语句:
缩进请严格按照Python的习惯写法：4个空格，不要使用Tab，更不要混合Tab和空格，否则很容易造成因为缩进引起的语法错误。
'''

age=20
if age>18:
    print('you are old')
else:
    print('you are yong')

'''
for循环:
L=['a','b','c']
for item in L
'''

L=['a','b','c']
for item in L:
    print(item)

'''
花括号 {} 表示这是一个dict，然后按照 key: value, 写出来即可。最后一个 key: value 的逗号可以省略。
可以简单地使用 d[key] 的形式来查找对应的 value


一是先判断一下 key 是否存在，用 in 操作符：

if 'Paul' in d:
    print d['Paul']

    由于dict是按 key 查找，所以，在一个dict中，key不能重复。

dict的第二个特点就是存储的key-value序对是没有顺序的！这和list不一样：


dict的第三个特点是作为 key 的元素必须不可变，Python的基本类型如字符串、整数、浮点数都是不可变的，都可以作为 key。但是list是可变的，就不能作为 key。

Python之 遍历dict:
使用: for key in dict:


'''

d = {
    'Adam': 95,
    'Lisa': 85,
    'Bart': 59
}

if 'Lisa' in d:
    print(d['Lisa'])

'''
set 跟list一样是一系列的元素,但是又具有dict的key 的性质不可以重复
创建一个set:
s=set(['A','S','c','c'])
测试打印set
print(s) 里面只有三个元素,并且顺序是不定的。 len(s)=3
'''
s=set(['A','S','c','c'])

print(s)


'''
set 的遍历: 因为是无序的集合  所以不可以通过索引来进行遍历,而可以用in先判断是否包含一个 itme :itme in set    return boolean
for item in set

更新set:  1.添加使用add,如果已经存在则添加不进去
         2.删除使用remove,如果不存在则会报错
'''


'''
如何定义一个函数:

在Python中，定义一个函数要使用 def 语句，依次写出函数名、括号、括号中的参数和冒号:，然后，在缩进块中编写函数体，函数的返回值用 return 语句返回。return None可以简写为return。

函数返回多个值:在python 的函数中以同时返回多个值 return x,y;  这多个值会放在truple 中也就是类似于是一个返回值


调用一个函数需要知道  函数名  以及  函数的参数  --参数不匹配或者不对则会typeError(参数个数不对  参数类型不对)
python 内置的函数:http://docs.python.org/2/library/functions.html#abs

int 与 str 相互转换:
>>> int('123')
123
>>> int(12.34)

>>> str(123)
'123'
>>> str(1.23)
'1.23'

12

如何定义一个递归的函数:
def fact(n):
    if n==1:
        return 1
    return n * fact(n - 1)


如何定义一个带有默认参数的函数:
 直接在函数参数中加上=default value
 caution:
 由于函数的参数按从左到右的顺序匹配，所以默认参数只能定义在必需参数的后面：


 如何定义可变参数:  ---在python 内部同样将这个可变参数当做是一个truple
 def fn(*args):
    print args
'''




'''
1.使用range bif  --针对list

n = ['1','2','3']

for i in range(n):

2.针对list 的slice:
n[0:3] 从0开始截取三个元素  并且这个0是可以省略的  只单独使用: 表示从头到尾
同时这两个参数也可以为复数 表示倒序
'''


'''
针对字符串的切片:
>>> 'ABCDEFG'[:3]
'ABC'
>>> 'ABCDEFG'[-3:]
'EFG'
>>> 'ABCDEFG'[::2]
'ACEG'

'''


'''
1. 有序集合：list，tuple，str和unicode；
2. 无序集合：set
3. 无序集合并且具有 key-value 对：dict

针对集合的迭代:在Python中，迭代是通过 for ... in 来完成的

Python中，迭代永远是取出元素本身，而非元素的索引。但如果需要拿出索引就得使用 enumerate()函数:

>>> L = ['Adam', 'Lisa', 'Bart', 'Paul']
>>> for index, name in enumerate(L):
...     print index, '-', name



使用 enumerate() 函数，我们可以在for循环中同时绑定索引index和元素name。但是，这不是 enumerate() 的特殊语法。实际上，enumerate() 函数把：

['Adam', 'Lisa', 'Bart', 'Paul']
变成了类似：

[(0, 'Adam'), (1, 'Lisa'), (2, 'Bart'), (3, 'Paul')]
因此，迭代的每一个元素实际上是一个tuple：

for t in enumerate(L):
    index = t[0]
    name = t[1]
    print index, '-', name
如果我们知道每个tuple元素都包含两个元素，for循环又可以进一步简写为：

for index, name in enumerate(L):
    print index, '-', name


'''

L = ['Adam', 'Lisa', 'Bart', 'Paul']
for index, name in enumerate(L):
    print (index, '-', name)


'''
dict 的迭代;


1. values() 方法实际上把一个 dict 转换成了包含 value 的list。
d = { 'Adam': 95, 'Lisa': 85, 'Bart': 59 }
print d.values()
2. 但是 itervalues() 方法不会转换，它会在迭代过程中依次从 dict 中取出 value，所以 itervalues() 方法比 values() 方法节省了生成 list 所需的内存。
d = { 'Adam': 95, 'Lisa': 85, 'Bart': 59 }
print d.itervalues()
3.迭代key 和 value:
使用items()函数:
>>> for key, value in d.items():
...     print key, ':', value
'''


'''
生成list:
1.生成['1','2','3','4','5','6']

list 生成式:[x * x for x in range(1, 11)] --这里将x从range(1,11) 取值,之后生成XX 的值赋值给list 中的每一个item

range(1,6)


针对dict:
tds = ['<tr><td>%s</td><td>%s</td></tr>' % (name, score) for name, score in d.iteritems()]
print '<table>'
print '<tr><th>Name</th><th>Score</th><tr>'
print '\n'.join(tds)
print '</table>'

加上if
>>> [x * x for x in range(1, 11) if x % 2 == 0]
[4, 16, 36, 64, 100]

1. isinstance(x, str) 可以判断变量 x 是否是字符串；

2. 字符串的 upper() 方法可以返回大写的字母。

3.多层表达式:
>>> [m + n for m in 'ABC' for n in '123']
['A1', 'A2', 'A3', 'B1', 'B2', 'B3', 'C1', 'C2', 'C3']

'''



