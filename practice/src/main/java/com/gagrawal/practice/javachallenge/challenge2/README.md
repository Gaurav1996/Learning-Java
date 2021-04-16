JVM is intelligently lazy. Here is what JVM would do internally for overloading cases 

1. Widening
2. boxing/unboxing
3. varargs

1 = jvm by default treats it as int
1.0 = jvm by default treats it as double

_References:_   
- https://www.infoworld.com/article/3268983/java-challengers-1-method-overloading-in-the-jvm.html
- https://www.youtube.com/watch?v=t7Mj_v0ouDc&t=650s&ab_channel=JavaChallengers