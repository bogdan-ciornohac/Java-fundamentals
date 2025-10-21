# Gotchas Found in Week 1

## Chapter 1
1. `undefined` does not exist in **Java**.  
2. `var` variables **must** be assigned before use.  
3. Classes in **Java** provide **default values** to their instance variables.

## Chapter 2
1. Compound operators **automatically perform type casting** when needed.

## Chapter 3
*(No gotchas recorded yet)*  

## Chapter 4
1. `String.strip()` supports **Unicode whitespace**, while `String.trim()` does **not**.
2. The **String pool** is a special memory region in the **JVM** used to **store and reuse identical string literals**, reducing memory overhead. You can use **intern()** to do it manually.

## Chapter 5 
1. **Static** variables can be called even the object has a null references.