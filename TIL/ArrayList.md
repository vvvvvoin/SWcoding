## ArrayList
### 특징
- 어레이 리스트는 배열과 같이 연속되는 데이터를 담는 리스트이다
- 간단한 자료구조이다
- 접근속도가 내부적으로 배열처리로 빠르다
- 배열과는 다루게 중간에 데이터를 추가해도 자동적으로 매핑이 이루어진다

### API
#### add()
- 메소드에 인자로 전달된 값을 리스트에 추가합니다

```java
ArrayList<Integer> arrayList = new ArrayList<>();
arrayList.add(1);
		
System.out.println(arrayList);

// [1]
```
- add(index, value)의 인자로 전달할 수 있다
```java
ArrayList<Integer> arrayList = new ArrayList<>();
arrayList.add(1);
arrayList.add(1, 2);
System.out.println(arrayList);

// [1, 2]
```
- 배열과 마찬가지로 index는 0부터 시작하고 값 중간이 null이면 안된다
```java
arrayList.add(0, 1);
arrayList.add(2, 2);
//컴파일 오류
//IndexOutOfBoundsException
```
#### addAll()
- 메소드에 인자로 전달되는 Collection 객체를 리스트에 추가합니다
```java
ArrayList<Integer> arrayList1 = new ArrayList<>();
ArrayList<Integer> arrayList2 = new ArrayList<>();
arrayList1.add(0, 1);
arrayList1.add(1, 2);
arrayList2.addAll(arrayList1);

System.out.println(arrayList1);
System.out.println(arrayList2);

//[1, 2]
//[1, 2]
```
- addAll(index, Collection)으로 추가하고자 하는 리스트에 특정 인덱스부터 값을 추가할 수 있다
```java
ArrayList<Integer> arrayList1 = new ArrayList<>();
ArrayList<Integer> arrayList2 = new ArrayList<>();
arrayList1.add(0, 1);
arrayList1.add(1, 2);
arrayList2.add(100);
arrayList2.add(200);
arrayList2.add(300);
arrayList2.add(400);
arrayList2.addAll(1, arrayList1);

System.out.println(arrayList1);
System.out.println(arrayList2);
//[1, 2]
//[100, 1, 2, 200, 300, 400]
```
#### remove()
- 메소드에 전달된 index값을 삭제하고 삭제된 값을 리턴됩니다
```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");

System.out.println(arrayList1.remove(1));
System.out.println(arrayList1);
//banana
//[apple, tomato]
```
- remove(Object object)인자로 전달된 값이 리스트에 존재하면 삭제되면 true 값을 리턴합니다.
```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");

System.out.println(arrayList1.remove("apple"));
System.out.println(arrayList1);
//true
//[banana, tomato]
```
#### removeIf()
- 인자로 Predicate를 받고 값을 필터링하여 true가 반환되면 제거합니다
```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");
arrayList1.add("melon");
arrayList1.add("watermelon");

arrayList1.removeIf(e -> {
	if(e.contains("melon")) {
		return true;
	}else return false;
});
		
System.out.println(arrayList1);
//[apple, banana, tomato]
```
#### removeAll()
- 인자로 전달된 Collection과 일치하는 리스트에 값을 삭제합니다

```java
ArrayList<String> arrayList1 = new ArrayList<>();
ArrayList<String> arrayList2 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");
arrayList1.add("melon");
arrayList1.add("watermelon");
		
arrayList2.add("melon");
arrayList2.add("watermelon");
	
System.out.println(arrayList1.removeAll(arrayList2));		
System.out.println(arrayList1);
//true
//[apple, banana, tomato]
```

#### get()
- 인자로 들어가는 indext에 해당하는 값을 리턴합니다
- 인덱스를 넘어가면 IndexOutOfBoundsException이 발생한다
```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");
arrayList1.add("melon");
arrayList1.add("watermelon");

System.out.println(arrayList1.get(1));
System.out.println(arrayList1.get(4));
//banana
//watermelon
```
#### indexOf()
- 인자로 들어간 값의 인덱스를 반환합니다
- 값이 없다면 -1을 반환합니다.
```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");
arrayList1.add("melon");
arrayList1.add("watermelon");

System.out.println(arrayList1.indexOf("tomato"));
System.out.println(arrayList1.indexOf("사과"));
//2
//-1
```

#### lastIndexOf()
- 인자로 들어간 값의 인덱스를 반환하는데 가장 뒤쪽에 존재하는 값을 리턴합니다
- 값이 없다면 -1을 리턴합니다

- ```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("apple2");
arrayList1.add("apple3");
arrayList1.add("apple4");
arrayList1.add("apple");

System.out.println(arrayList1.lastIndexOf("apple"));
System.out.println(arrayList1.lastIndexOf("사과"));
//4
//-1
```

#### contains()
- 인자로 전달된 값이 리스트에 존재하면 true를 리턴합니다
```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");
arrayList1.add("melon");
arrayList1.add("watermelon");
	
System.out.println(arrayList1.contains("tomato"));
System.out.println(arrayList1.contains("토마토"));
//true
//false
```

#### clear()
- 해당 어레이리스트의 배열을 초기화하여 size를 0로 만듭니다

```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");
arrayList1.add("melon");
arrayList1.add("watermelon");
	
System.out.println(arrayList1);
arrayList1.clear();
System.out.println(arrayList1);
//[apple, banana, tomato, melon, watermelon]
//[]
```
#### clone()
- 해당 어레이리스트를 복사하여 리턴합니다.
- clone() 메소드의 리턴 값이 Object이므로 캐스팅 해준다
```java
ArrayList<String> arrayList1 = new ArrayList<>();
arrayList1.add("apple");
arrayList1.add("banana");
arrayList1.add("tomato");
arrayList1.add("melon");
arrayList1.add("watermelon");
			
ArrayList<String> arrayList2 = (ArrayList<String>) arrayList1.clone();
System.out.println(arrayList2);
//[apple, banana, tomato, melon, watermelon]
```