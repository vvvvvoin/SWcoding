## HashMap
### 특징
- Map의 일종으로 `key', `value`로 쌍을 이룬다
- null key, value를 허용한다
- 데이터의 순서를 보장하지 않는다
- 중복된 key값은 허용안되지만 중복된 value값은 허용

### API
#### put()
- put은key와 value의 값을 받는다
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);

//{null=3, a=1, b=2, c=3}
```
#### putAll()
- 인자로 전달된 Map에 대한 데이터를 모두 저장한다
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);

System.out.println(hashMap);

Map<String, Integer> hashMap2 = new HashMap<>();
hashMap2.put("d", 1);
hashMap2.put("e", 2);
hashMap2.put("f", 3);
hashMap2.put("g", 3);

System.out.println(hashMap2);
hashMap2.putAll(hashMap);
System.out.println(hashMap2);

//{null=3, a=1, b=2, c=3}
//{d=1, e=2, f=3, g=3}
//{null=3, a=1, b=2, c=3, d=1, e=2, f=3, g=3}
```

#### get()
- 인자로 key값을 넣어 해당 value를 가져온다
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);
System.out.println(hashMap);
System.out.println(hashMap.get("a"));

//{null=3, a=1, b=2, c=3}
//1
```

#### remove()
- 인자로 전달된 key에 해당하는 데이터를 제거하고 해당 value가 리턴된다
- null일시 null 리턴
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);
System.out.println(hashMap);
System.out.println(hashMap.remove("a"));
System.out.println(hashMap.remove("b"));
System.out.println(hashMap.remove("z"));
System.out.println(hashMap);

//{null=3, a=1, b=2, c=3}
//1
//2
//null
//{null=3, c=3}
```
#### clear()
- map에 존재하는 모든 데이터를 삭제합니다

#### isEmpty()
- map에 데이터가 비었다면 true, 존재하면 false를 리턴합니다


#### keySet(), valuse()
- hashMap에 ket를 리턴하거나, value값을 Collection객체로 리턴해준다
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);
			
for(String str : hashMap.keySet()) {
	System.out.println(str);
}
//null
//a
//b
//c
```
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);
			
for(Integer value : hashMap.values()) {
	System.out.println(value);
}
//3
//1
//2
//3
```

#### containKey(), containValue()
- 해당 HashMap에 key, value에 해당하는 값이 존재한다면 true 아니면 false를 리턴

```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);
		
System.out.println(hashMap.containsKey("a"));
System.out.println(hashMap.containsValue(4));

//true
//false
```

#### replace()
- 인자로 전달된 key, value를 인자로 전달된 value로 교체해주고 삭제된 value를 리턴시킨다
- 존재하지 않는 key를 replace()할 경우 null리턴	
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);
		
System.out.println(hashMap.replace("a", 100));
System.out.println(hashMap.replace("zz", 500));;
System.out.println(hashMap);

//1
//null
//{null=3, a=100, b=2, c=3}
```
#### getOrDefault()
- 인자로 key, value값이 들어가며 해당하는 key가 존재하면 해당 key의 value를 리턴
- 해당하는 key가 HashMap에 존재하지 않을 경우 default값 리턴, 해당 키와 값은 맵에 저장되지 않음
```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("a", 1);
hashMap.put("b", 2);
hashMap.put("c", 3);
hashMap.put(null, 3);
		
System.out.println(hashMap);
System.out.println(hashMap.getOrDefault("a", 0));
System.out.println(hashMap.getOrDefault("4", 100));
System.out.println(hashMap);

//{null=3, a=1, b=2, c=3}
//1
//100
//{null=3, a=1, b=2, c=3}
```