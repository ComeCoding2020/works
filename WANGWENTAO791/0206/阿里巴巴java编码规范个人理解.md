自己对阿里巴巴java编码规范中一些重要的点的理解和整理

--编程规约
10.避免在子父类使用相同的成员变量命名，不同代码块的局部变量相同命名，造成可读性降低

13.标识类型的名词放在词尾，以提升辨识度。
例：
startTime workQueue nameList THREAD_COUNT

--常量定义
3.不要一个常量类维护所有的常量，按功能归类，分开维护

4.常量的复用层次有五层：跨应用共享常量、应用内共享常量、子工程内共享常量、包内共享常量、类内共享常量
1) 跨应用共享：放置于二方库jar包中的constant目录下
2) 应用内共享常量：放置于一方库的constant目录下
3) 子工程内共享常量：当前子工程的constant目录下
4) 包内共享常量：即在当前包下单独的constant目录下
5) 类内共享常量：直接在类内部常量定义 private static final

5.如果变量仅在一个固定范围内变化，使用enum类型来定义。
个人深入：
如果此字符串经常被使用，在给类的成员变量赋值时，使用String.intern()来降低内存使用。

--代码格式
4. 任何二目、三目应算符的左右两边都需要一个空格。运算符包括=、逻辑运算符 || && 运算符 + - * 、

7.类型强制转换时，右括号与强制转换值直接不需要任何空格隔开。
例：
long first = 10000000000L;
int second = (int)first +2;

8.换行规则
1) 第二行相比第1行缩进4个空格，从第三行起不再缩进
2) 运算符与下文一起换行。
3) 方法的点符号与下文一起换行。
4) 多参数换行时,逗号不换行
5) 前括号不换行

11. 单个方法的总行数尽量不超过80行，每行不超过120字符

13.不同逻辑、语义、业务间最多插入一个空行分隔提升可读性。

--OOP规则
2.所有复写方法，必须加@orerride注解 （IDEA会检测）

4.过时方法，及时清理或加上@Deprecated注解

5.新增代码不能使用依赖包中的过时方法

6.使用equals方法时，需常量在前，如果都为变量，可使用google的空指针包装类进行判断

7. 所有整形包装类对账之间的值比较，全部使用equals方法进行比较

8. 浮点数之间的等值判断 ，不能使用==来比较，包装数据类型不能使用equals（原文是否有错，应该是包装数据类型不能使用==吧，要使用equals）
反例：
float a = 1.0f -0.9f
float b = 0.9f -0.8f
if (a == b) {
	预期进入此代码块，实际上为false
}
正例1：
如果在一个误差范围内，则认为相等
float a = 1.0f -0.9f
float b = 0.9f -0.8f
float diff = 1e-6f

if (Math(a-b) < diff) {
	成功 -> 进入代码块
}
正例2：
BigDecimal a = new BigDecimal("1.0")；
BigDecimal b = new BigDecimal("1.9")；
BigDecimal a = new BigDecimal("0.8")；

BigDecimal diffA = a.subtract(b);
BigDecimal diffB = b.subtract(c);

if (x.equals(y) {
	成功 -> 进入代码块
}

9. DO 属性类型要与数据库字段类型相匹配
-> 原来使用过Mybatis的类型映射String -> int , int -> String 目前看起来不太符合规范

10. 为了防止精度损失，精致使用构造方法BigDecimal(double)，最多到BigDecimal(float)
示例：
BigDecilaml g = new BigDecimal(0.1f); 实际值为：0.10000000149
正例：
使用String的方式，Double的toString方法会按照double的实际表达精度对尾数进行了截断。
BigDecimal recommend1 = new BigDecimal("0.1");
BigDecimal recommend2 = new BigDecimal.valueOf(0.1);

11. RPC及数据POJO类，所有属性使用包装数据类型，局部变量使用基础类型。

12. 所有DO / DTO /VO 等数据类初始化时，不要设定任何存在可能被赋值的属性有默认值。

14.构造方法不能有任何业务逻辑，业务逻辑可以使用init方法或者spring的@poststruts进行初始化。

20.setter /getter方法中，不要增加业务逻辑，增加排查问题的难度

22.final可以什么类、成员变量、方法、以及本地变量，下列情况使用final关键字
1) 不允许被继承的类
2) 不允许修改引用的域对象
3) 不允许被覆写的方法
4) 不允许允许过程中重新赋值的局部变量
5) 避免上下文使用同一个变量，使用final可以强制重新定义一个变量，方便更好地进行重构

23 慎用Object 的clone方法进行拷贝对象，如需深拷贝需要重写clone方法

--集合处理
1.关于hashCode和equals的处理
1) 覆写了equals，就必须覆写hashCode
2) 因为Set存在的是不重复对象，根据hashCode和equals进行判断，所以Set存储的对象必须覆这两个方法
3) 如果自定义对象作为MAP的key，那么必须覆写hashCode和quals

2. ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException异常
说明：subList返回的是ArrayList的内部类SubList，并不是ArrayList，而是ArrayList的一个视图，对于SubList子列表的所有操作会最终反映到原列表。（在使用SubList，父List 的增加及删除操作 需要极度谨慎，容易出现ConcurrentModiffcationException ）

3. Collections 类返回的对象，如：emptyList()/singletonList()等都是Immutablelist ，不可对其进行田间及删除元素操作。
说明：这一块可以看list的初始化赋值，对于当一个元素都没有的时，被赋值的对象。和添加第1个元素时，生成的对象不是同一个。

5.在subList场景中，**高度注意对原集合元素的增加或删除**，俊辉导致子列表遍历、增加、删除产生concurrentModificationException异常。

6.集合转数组的方法们，必须使用集合的toArray(T[]) array)，传入的是类型完全一致、长度为0的空数组。
反例：
直接使用toArray无参方法存在问题，此方法返回值只能是Objectp[]类，若强转其他类型数组会出现ClassCastException错误。
正例：
list<String> list = new ArrayListM<>(2);
list.add("test");
list.add("??");
String[] array = list.toArray(new String[0]);
说明：使用toArray带参方法，数组空间大小的length选择：
1) 等于0 ，动态创建于size相同的数组，性能最好。
2) 小于0 但小于size，重建创建大小等于size的数组，增加GC负担。
3) 等于size，在搞并发情况下，数组创建完成之后，size正在变大的情况下，负面影响与上相同。
4) 大于size，空间浪费，且在sie处插入null值，存在NPE隐患。

7.在使用Collection接口的任何实现类的addAll()方法时，都要对输入的集合参数进行NPE判断。

8.使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合的相关方法，它的add/remove/clear方法会抛出UnsupportedOperatiponException异常。
说明：asList的返回对象时一个Arrays内部类，并没有实现集合的修改方法。Arrays.asList体现的是适配器模式，只能转换接口，后台的数据任是数组。
	String[] str = new String[]{"test","???"};
	List list  = Arrays.asList(str);
情况1：list.add("test");运行时异常。
情况2：str[0] = "xxx" ，会修改list中的值，反之修改list也会修改str[]

4. 泛型通配符<? extends T>用于接收返回的数据，此写法的泛型集合不能使用add方法，<? super T>不能使用get方法，作为借口调用时易出错。
说明：
PECS(Producer Extends Consumer Super)原则：第一、频繁往外读取内容的，适合用<? extends T>。第二、经常往里插入的，适合用<? super T>
个人总结：
    <? extends T> 只能用于方法返回，告诉编译器此返参的类型的最小继承边界为T，T和T的父类都能接收，但是入参类型无法确定，只能接受null的传入。
    <? super T>只能用于限定方法入参，告诉编译器入参只能是T或其子类型，而返参只能用Object类接收。
    ? 既不能用于入参也不能用于返参

5. 在无泛型限制定义的集合赋值给泛型限制的集合时，在使用集合元素时，需要进行instantof判断，避免抛出ClassCastException异常。

6. 不要在foreach循环里进行元素的remove/add操作。remove元素需要使用Iterator，如果并发，需要加锁。
正例：
Iterator<String> iterator = list.iterator();
 while(iterator.hasNest()) {
 	String item = iterator.next();
 	if (删除条件) {
 		iterator.remove();
 	}
 }

7. 使用entry遍历Map集合的K、V，而不是keySet方式进行遍历。
注：keySet其实是遍历了两次，一次是转为Iterator对象，另一次从hashMap中取出key所对应的value。而entrySet只是遍历了一次就把key和value放到了entry中，效率更高。JDK 8 中可以使用Map.forEach方法。

8. hashMap值空问题
hashTable（ConcurrentHashMap） key value 都不能为空
hashMap key value 都能为null
TreeMap value 可以为null 

8. 对常用数据结构的有序性及稳定性整理。
个人：
ArrayList 无序，稳定
HashMap 无序，不稳定
TreeSet 有序，稳定
有序：按照比较规则依次排列。
稳定，每次遍历的元素次序是一定的。 

10. 利用Set元素唯一的特征，可以对一个集合快速去重，避免使用list的contains方法进行遍历、对比、去重。

--并发处理
1. 创建线程池时，请指定有意义的线程名称，方便出错时，回溯。
正例：
public class UserThreadFactory implements ThreadFactory {
	
	private final String namePrefix;
	private final AtomicInteger nextId = new AtomicInteger(1);
	
	UserThreadFactory(String whatFeaturOfGroup) {
		namePrefix = "From UserThreadFactory's" + whatFeaturOfGroup + "~Worker~";
	}
	@Override
	public Thread newThread(Runnable task) {
		String name = namePrefix + nexId.getAndIncrement();
		Thread thread = new Thread(null, task, name, 0, false);
		return thread;
	}
}
个人：方便日志排查

2. 线程资源必须通过线程池提供，不允许在应用自行显示创建线程。

4. 线程池创建使用Executors去创建会存在问题，应用通过ThreadPoolExecutor的方式去创建。
个人：
对于ThreadPoolExecutor的构造方法里，阻塞队列的初始化（长度设定）、运行模型、核心线程数、最大线程数等参数的设置应该有明确的了解

5. SimpleDateFormat 是线程不安全，如定义为静态共享，则需要加锁，或使用类似threadLocal方式去保证线程安全。
说明：
JDK8的应用，可以使用Instant代替Date，LocalDateTime代替Calendar，DateTimeFormatter代替SimpleDateFormat。
个人：
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
LocalDate date = LocalDate.parse("2017 06 17", formatter);
System.out.println(formatter.format(date));

6. 必须回收自定义的ThreadLocal变量，尽量在代理中使用try-finally块进行回收。

7. 高并发时，同步调用应该去考量锁的性能损耗。能用无锁数据结构，就不要用锁。能锁区块，就不要锁整个方法体。能用对象锁，就不要用类锁。
个人：锁粒度 尽量小 尽量使用并发包下的数据结构。

8. 对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造成死锁（循环等待 + 请求和保持条件）。
例如：A线程获取锁顺序为 A C B  ，那么B线程要获取 B C 资源时，也应该先B后C。
个人:
死锁的原因：
互斥条件：进程要求对所分配的资源（如打印机）进行排他性控制，即在一段时间内某 资源仅为一个进程所占有。此时若有其他进程请求该资源，则请求进程只能等待。
不剥夺条件：进程所获得的资源在未使用完毕之前，不能被其他进程强行夺走，即只能 由获得该资源的进程自己来释放（只能是主动释放)。
请求和保持条件：进程已经保持了至少一个资源，但又提出了新的资源请求，而该资源 已被其他进程占有，此时请求进程被阻塞，但对自己已获得的资源保持不放。
循环等待条件：存在一种进程资源的循环等待链，链中每一个进程已获得的资源同时被 链中下一个进程所请求。即存在一个处于等待状态的进程集合{Pl, P2, ..., pn}，其中Pi等 待的资源被P(i+1)占有（i=0, 1, ..., n-1)，Pn等待的资源被P0占有，如图2-15所示。

9. 在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方式与try代码块之间没有可能抛出异常的方法调用，避免加锁成功后，在finally中无法解锁，或尚未获取锁调用解锁会产生的IllegalMonitorStateException异常。
正例：
Lock lock  = new XxxLock();
// ..
try {
lock.lock();
} catch (Exception e) {
	// 结束
	return;
} 
try {
	doSomething();
} finally {
	lock.unlock();
}

10. 使用非阻塞尝试机制来获取锁的方式中，进入业务块之前，必须先判断是否持有锁，防止因释放锁时，造成的未申请到锁而抛出的IllegalMinitorStateException 异常。
11. 为防止同一记录并发修改，需要加锁，要么应用层加锁，要么缓存加锁，要么数据库使用乐观锁（通过Compare And Update）以Version作为更新依据。

12. Timer多个TimeTask一个子任务抛出异常，其他任务会停止。
个人：不使用TImer类进行定时任务调度了，推荐使用基于spring的quartz框架 或JDK 7？8自带的ScheduledExecutorService来进行定时任务的调度。

13. 资金相关金融敏感信息，使用悲观锁。
账户锁 （基于缓存/数据库）

14. CountDownLatch使用时，子线程需要保证countDown方法被执行到。
个人：
try {
} catch(Exception e) {

} finally {
   countDownLatch.countDown()；

15. 随机数的Random实例在多线程下存在性能问题。Math.random() 和 Random类
正：使用JDK7 ThreadLocalRandom
另外：部分需要安全要求的随机数，使用java.security.SecureRandom替换java.util.Random

16. 单例类的双重检查锁，变量名需要申明为volatile

17. volatile解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，但是是多写，统一无法解决线程安全。

18. HashMap在容量不够进行resize时，由于高并发可能出现死链，导致CPU飙升，在开发过程中使用其他数据结构或加锁来避免此风险。
个人：在能够确保HashMap 的size情况下，初始化后不发生resize就不会出现该问题。

19. ThreadLocal对象使用static修饰时，只在类初始化时有一份副本，所有类的对象都只能操作只一份副本。
个人：这样使用不就偏离了ThreadLocal 的应用场景，应该不会有这样用的场景吧。
