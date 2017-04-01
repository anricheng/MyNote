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

'''
函数可以赋值给一个变量: a = abs
a(10) 就等于是abs(10)
既然函数可以赋值给一个变量那么 这个变量就可以当做是一个参数 继续传递给函数
'''


'''
python中map()函数
map()是 Python 内置的高阶函数，它接收一个函数 f 和一个 list，并通过把函数 f 依次作用在 list 的每个元素上，得到一个新的 list 并返回。
'''

'''
转换大小写:def format_name(s):
    return s[0].upper() + s[1:].lower()
print map(format_name, ['adam', 'LISA', 'barT'])
'''

'''
python中reduce()函数
reduce()函数也是Python内置的一个高阶函数。reduce()函数接收的参数和 map()类似，一个函数 f，一个list，但行为和 map()不同，reduce()传入的函数 f 必须接收两个参数，reduce()对list的每个元素反复调用函数f，并返回最终结果值。

例如，编写一个f函数，接收x和y，返回x和y的和：

def f(x, y):
    return x + y
调用 reduce(f, [1, 3, 5, 7, 9])时，reduce函数将做如下计算：

先计算头两个元素：f(1, 3)，结果为4；
再把结果和第3个元素计算：f(4, 5)，结果为9；
再把结果和第4个元素计算：f(9, 7)，结果为16；
再把结果和第5个元素计算：f(16, 9)，结果为25；
由于没有更多的元素了，计算结束，返回结果25。
上述计算实际上是对 list 的所有元素求和。虽然Python内置了求和函数sum()，但是，利用reduce()求和也很简单。

reduce()还可以接收第3个可选参数，作为计算的初始值。如果把初始值设为100，计算：

reduce(f, [1, 3, 5, 7, 9], 100)
结果将变为125，因为第一轮计算是：

计算初始值和第一个元素：f(100, 1)，结果为101。
'''


'''
python中filter()函数
filter()函数是 Python 内置的另一个有用的高阶函数，filter()函数接收一个函数 f 和一个list，这个函数 f 的作用是对每个元素进行判断，返回 True或 False，filter()根据判断结果自动过滤掉不符合条件的元素，返回由符合条件元素组成的新list。

例如，要从一个list [1, 4, 6, 7, 9, 12, 17]中删除偶数，保留奇数，首先，要编写一个判断奇数的函数：
'''


'''
Python内置的 sorted()函数可对list进行排序：

>>>sorted([36, 5, 12, 9, 21])

[5, 9, 12, 21, 36]

但 sorted()也是一个高阶函数，它可以接收一个比较函数来实现自定义排序，比较函数的定义是，传入两个待比较的元素 x, y，如果 x 应该排在 y 的前面，返回 -1，如果 x 应该排在 y 的后面，返回 1。如果 x 和 y 相等，返回 0。

因此，如果我们要实现倒序排序，只需要编写一个reversed_cmp函数：

def reversed_cmp(x, y):
    if x > y:
        return -1
    if x < y:
        return 1
    return 0
这样，调用 sorted() 并传入 reversed_cmp 就可以实现倒序排序：

>>> sorted([36, 5, 12, 9, 21], reversed_cmp)
[36, 21, 12, 9, 5]
sorted()也可以对字符串进行排序，字符串默认按照ASCII大小来比较：

>>> sorted(['bob', 'about', 'Zoo', 'Credit'])
['Credit', 'Zoo', 'about', 'bob']
'Zoo'排在'about'之前是因为'Z'的ASCII码比'a'小。
'''


'''
python 返回函数:
python中返回函数
Python的函数不但可以返回int、str、list、dict等数据类型，还可以返回函数！

例如，定义一个函数 f()，我们让它返回一个函数 g，可以这样写：

def f():
    print 'call f()...'
    # 定义函数g:
    def g():
        print 'call g()...'
    # 返回函数g:
    return g
仔细观察上面的函数定义，我们在函数 f 内部又定义了一个函数 g。由于函数 g 也是一个对象，函数名 g 就是指向函数 g 的变量，所以，最外层函数 f 可以返回变量 g，也就是函数 g 本身。

调用函数 f，我们会得到 f 返回的一个函数：

>>> x = f()   # 调用f()
call f()...
>>> x   # 变量x是f()返回的函数：
<function g at 0x1037bf320>
>>> x()   # x指向函数，因此可以调用
call g()...   # 调用x()就是执行g()函数定义的代码
请注意区分返回函数和返回值：

def myabs():
    return abs   # 返回函数
def myabs2(x):
    return abs(x)   # 返回函数调用的结果，返回值是一个数值
返回函数可以把一些计算延迟执行。例如，如果定义一个普通的求和函数：

def calc_sum(lst):
    return sum(lst)
调用calc_sum()函数时，将立刻计算并得到结果：

>>> calc_sum([1, 2, 3, 4])
10
但是，如果返回一个函数，就可以“延迟计算”：

def calc_sum(lst):
    def lazy_sum():
        return sum(lst)
    return lazy_sum
# 调用calc_sum()并没有计算出结果，而是返回函数:

>>> f = calc_sum([1, 2, 3, 4])
>>> f
<function lazy_sum at 0x1037bfaa0>
# 对返回的函数进行调用时，才计算出结果:

>>> f()
10
由于可以返回函数，我们在后续代码里就可以决定到底要不要调用该函数
'''


'''
python 中的闭包:内层函数引用了外层函数的变量（参数也算变量），然后返回内层函数的情况，称为闭包（Closure）。

闭包的特点是返回的函数还引用了外层函数的局部变量，所以，要正确使用闭包，就要确保引用的局部变量在函数返回后不能变
//一个经典的案例:
# 希望一次返回3个函数，分别计算1x1,2x2,3x3:
def count():
    fs = []
    for i in range(1, 4):
        def f():
             return i*i
        fs.append(f)
    return fs

f1, f2, f3 = count()
你可能认为调用f1()，f2()和f3()结果应该是1，4，9，但实际结果全部都是 9（请自己动手验证）。

原因就是当count()函数返回了3个函数时，这3个函数所引用的变量 i 的值已经变成了3。由于f1、f2、f3并没有被调用，所以，此时他们并未计算 i*i，当 f1 被调用时：

>>> f1()
9     # 因为f1现在才计算i*i，但现在i的值已经变为3
'''


'''
匿名函数:
>>> map(lambda x: x * x, [1, 2, 3, 4, 5, 6, 7, 8, 9])
[1, 4, 9, 16, 25, 36, 49, 64, 81]

通过对比可以看出，匿名函数 lambda x: x * x 实际上就是：

def f(x):
    return x * x
关键字lambda 表示匿名函数，冒号前面的 x 表示函数参数。

匿名函数有个限制，就是只能有一个表达式，不写return，返回值就是该表达式的结果。

'''

'''
Python 装饰器:
使用高阶函数的特性:

首先定义一个高阶函数,将需要装饰的函数传入,那么忧郁这个函数没法带入任何的参数,那么最终只能返回一个函数,由返回的这个函数来重新接收参数


1. 需要装饰的函数:
def func(x):
     return X*2;
2.装饰函数:

def decorateFun(f):
   def fn(x):
        print("enhance code")
        :return f(x)
    :return fn


Python 中内置的装饰器函数 用@表明是对装饰器的调用:
@decorateFun
def func(x):
return x*2


'''



