# ☕ Java OCP Study Guide 

A consolidated study guide and cheatsheet for the **OCP Java Developer Exam**.  
Each chapter includes key concepts and **📝 Exam Tips**.

---

# 📘 Chapter 1 — Java Building Blocks

## 🔹 Program Structure
- Java starts execution with the **main()** method:  
  `public static void main(String[] args)`
- Arguments are passed after the class name:  
  `java ClassName firstArgument`
- Arguments are indexed starting at **0**.

## 🔹 Packages & Imports
- Code is organized into **packages** (folders).  
- Use **import statements** to reference other packages.  
- Wildcard imports (`import package.*;`) include only **classes**, not subpackages.  
- The `java.lang` package is **imported automatically**.

## 🔹 File Structure
1. `package` statement (if any)  
2. `import` statements (if any)  
3. `class/interface` declaration  
4. Fields and methods can appear in any order.

## 🔹 Variables
- **Primitive types** are basic building blocks.  
- **Reference types** can be `null` and have methods.  
- **Numeric literals** may include underscores (`_`), not at the start/end or next to a decimal point.  
- **Wrapper classes** exist for each primitive type.  
- **Text blocks** allow multiline Strings using triple quotes (""" ... """).  
- **Local variables** must be initialized before use.  
- **var** infers the type at **compile time** and doesn’t change.

## 🔹 Variable Scope
- **Instance variables** → non-static fields  
- **Class variables** → static fields  
- **Local variables** → declared in methods/constructors/blocks

## 🔹 Constructors & Garbage Collection
- Constructors share the class name and have **no return type**.  
- **Initialization order:** fields → blocks → constructor.  
- **Garbage collection** removes unreachable objects (no remaining references).

## 📝 Exam Tips
- Watch for incorrect `main()` signatures.  
- Remember import order rules.  
- Distinguish between primitive and reference variable behavior.  
- Be able to identify when objects become **eligible for GC**.

---

# 📗 Chapter 2 — Operators

## 🔹 Operator Types
- **Unary, binary, and ternary** operators.  
- Know **precedence** and **associativity** rules.  
- Parentheses change evaluation order.

## 🔹 Common Operator Groups
- Arithmetic (`+`, `-`, `*`, `/`, `%`)  
- Comparison (`==`, `!=`, `<`, `>`, `<=`, `>=`)  
- Logical (`&&`, `||`, `!`)  
- Bitwise (`&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`)  
- Assignment (`=`, `+=`, etc.)  
- Ternary (`condition ? a : b`)

## 📝 Exam Tips
- Be cautious of **type promotion** (e.g., `int` + `long` → `long`).  
- Understand **autoboxing/unboxing** in operations.  
- Check **operator misuse** — common hidden errors on the exam.  
- Expect operator questions disguised as other topics (e.g., NIO, exceptions).

---

# 📙 Chapter 3 — Making Decisions

## 🔹 Control Flow
- **if / else** → basic branching  
- **switch / switch expressions** → flexible control, supports pattern matching (Java 21)  
- **Pattern matching** simplifies type checking and casting.

## 🔹 Loops
- **while / do-while** → condition-based repetition  
- **for / for-each** → simplified iteration  
- Always ensure termination conditions are valid.

## 🔹 Flow Control
- `break`, `continue`, and `return` affect execution flow.  
- **Labels** allow control statements in nested loops.

## 📝 Exam Tips
- Review **switch expression syntax** and arrow form.  
- Watch for loops that **never terminate** or skip initialization.  
- Be precise with **label use** in nested loops.  
- Expect many “Does not compile” traps on control structures.

---

# 📒 Chapter 4 — Core APIs

## 🔹 Strings and StringBuilder
- `String` is **immutable**; operations create new objects.  
- `StringBuilder` is **mutable** and efficient for modifications.  
- `==` checks reference equality; `equals()` checks content for `String`.  
- For `StringBuilder`, both `==` and `equals()` check references.

## 🔹 Arrays
- Fixed-size, zero-indexed memory structure.  
- Created with `new Type[size]`.  
- Key methods:
  - `Arrays.sort()` — sorts array
  - `Arrays.binarySearch()` — finds index in sorted array
  - `Arrays.compare()` / `mismatch()` — compare arrays  
- **Varargs (`...`)** act like arrays in parameters.

## 🔹 Date and Time API
- `LocalDate`, `LocalTime`, `LocalDateTime` — immutable time classes.  
- Created via `now()` or `of()`.  
- Manipulated with `plus()`, `minus()`, `with()`, `at()`.  
- `Period` represents date differences.

## 📝 Exam Tips
- Understand **immutability** for Strings and Dates.  
- Practice **array indexing** and `binarySearch()` results.  
- Know **autoboxing** with Arrays and Collections.  
- Expect subtle questions mixing **String** and **StringBuilder**.

---

# 📕 Chapter 5 — Methods and Encapsulation

## 🔹 Method Declaration
- Order: [access modifier] [optional specifier] [return type] [name(parameters)] [throws list] { body }  
- Common access modifiers: `private`, (default), `protected`, `public`.  
- Optional specifier: `static`, `final`.

## 🔹 Access Modifiers
| Modifier | Visibility |
|-----------|-------------|
| `private` | Same class only |
| *default* | Same package |
| `protected` | Same package + subclasses |
| `public` | Everywhere |

## 🔹 Static Members
- Shared across all instances.  
- Called using `ClassName.method()`.  
- `static` members **cannot** access instance members directly.  
- `import static` allows direct access without class prefix.

## 🔹 Final Modifier
- Used on variables, methods, and classes.  
- Local variables are **effectively final** if not reassigned.  

## 🔹 Method Overloading
- Same name, different parameter list.  
- Java picks the **most specific match**: exact → wider → autobox → varargs.

## 📝 Exam Tips
- Know **access modifier rules** cold.  
- Understand **pass-by-value** for primitives and objects.  
- Review **autoboxing** in overloads.  
- Watch for illegal **static vs instance** member access.

---

# 🧠 Chapter 6 — Inheritance and Class Design

## 🔹 Inheritance Basics
- **Single inheritance:** Each class has exactly **one direct superclass**.  
  → All classes ultimately extend `java.lang.Object`.
- **Access levels in inheritance:**
  - Inherited: `public`, `protected`
  - Same package: package-private
  - Not inherited: `private`
- **References:**
  - `this` → current class instance
  - `super` → parent class instance

---

## 🔹 Constructors and Initialization
- Constructors:
  - Same name as class, **no return type**.
  - Used to create new objects.
- **Rules:**
  - If no constructor is declared → compiler adds **default no-arg constructor**.
  - **First line** must be `this(...)` or `super(...)`.
  - If omitted → compiler inserts `super()`.
  - **Error** occurs if parent has no no-arg constructor and none is explicitly called.
- **Initialization Order:**
  1. Superclass static variables + static initializers  
  2. Subclass static variables + static initializers  
  3. Superclass instance variables + instance initializers  
  4. Subclass instance variables + instance initializers  
  5. Constructor (top-down)
- **Final variables:** must be assigned exactly once.

---

## 🔹 Method Behavior
| Type | Same Name? | Same Signature? | Static? | Description |
|------|-------------|-----------------|----------|--------------|
| **Overload** | ✅ | ❌ | Any | Same name, different parameters |
| **Override** | ✅ | ✅ | ❌ | Same signature, replaces parent method |
| **Hide** | ✅ | ✅ | ✅ | Static version of override |
| **Redeclare** | ✅ | ✅/❌ | Any | Same name but not inherited (new scope) |

### Overriding Rules
- Return type: must be **same or covariant**.
- Access: cannot be **more restrictive**.
- Exceptions: can declare **same or narrower** checked exceptions.
- `@Override` annotation helps detect mistakes.

---

## 🔹 Abstract Classes & Methods
- **Abstract class:**
  - Declared with `abstract` keyword.
  - Cannot be instantiated.
  - May contain **abstract or concrete** methods.
- **Abstract method:**
  - Declared without a body.
  - Only inside abstract class or interface.
  - First **concrete subclass** must implement all inherited abstract methods.

---

## 🔹 Immutability
### To make a class immutable:
1. Declare class as `final` (optional, prevents subclassing).
2. All fields are `private final`.
3. No setter methods.
4. Defensive copies for mutable objects.
5. Initialize all fields in constructor.

**Example:**
```java
public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}
```

**Benefits:** Thread-safe, simpler reasoning, safe for caching and sharing.

---

## 📝 Exam Tips
- Watch for **constructor chains** that skip required `super()` calls.
- Identify **illegal overrides** (wrong return type or access level).
- Understand **abstract method inheritance** from multiple sources.
- Know the **initialization order** cold — it’s a favorite exam trick.



# 🧩 Chapter 7 — Advanced Object-Oriented Design Cheatsheet

## 🔹 Interfaces
- Java supports **multiple inheritance through interfaces**.  
- **Implicit modifiers:**
  - For interface: `public abstract`
  - For variables: `public static final`
  - For methods:
    - **Abstract** → `public abstract`
    - **Default** → `public`
    - **Static** → `public`
    - **Private** → (no modifier)
    - **Private static** → `private static`

### ✅ Interface Member Types (6)
1. Abstract methods  
2. Static constants (fields)  
3. Default methods  
4. Static methods  
5. Private methods  
6. Private static methods  

---

## 🔹 Enums
- **Compile-time constants** that may include constructors, methods, and fields.  
- Can be used in `switch` statements and expressions.  
- **Abstract methods in enums** → every constant must implement them.

```java
enum Day {
    MONDAY { void greet() { System.out.println("Start strong!"); } },
    FRIDAY { void greet() { System.out.println("Almost done!"); } };
    abstract void greet();
}
```

---

## 🔹 Sealed Classes and Interfaces
- Restrict which subclasses can extend or implement them.  
- Subclasses must be `final`, `sealed`, or `non-sealed`.  
- If all subclasses are in the **same file**, `permits` clause can be omitted.

```java
public sealed class Animal permits Dog, Cat {}
final class Dog extends Animal {}
non-sealed class Cat extends Animal {}
```

- **Sealed interfaces** limit which types can implement or extend them.

---

## 🔹 Records
- **Immutable, encapsulated POJOs** with compiler-generated boilerplate.
- Auto-generated: constructor, accessors, `equals()`, `hashCode()`, `toString()`.
- Can define static members, methods, nested types.
- Cannot have additional instance variables.
- Support overloaded and compact constructors for validation.

```java
public record Person(String name, int age) {
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age must be positive");
    }
}
```

---

## 🔹 Nested Classes
| Type | Static? | Access Outer? | Common Use |
|------|----------|----------------|-------------|
| **Inner** | ❌ | ✅ | Associated with instance |
| **Static Nested** | ✅ | ❌ | Helper or grouping logic |
| **Local** | ❌ | ✅ (final/effectively final vars) | Inside method/block |
| **Anonymous** | ❌ | ✅ | Inline implementation |

**Rules:**
- Inner, Local, and Anonymous classes can access **private members** of the outer class.  
- Anonymous classes must **extend one class or implement one interface**.

---

## 🔹 Polymorphism
- Objects can be accessed via superclass or interface references.  
- **Casting:**
  - Compile-time: checks reference type compatibility.  
  - Runtime: checks actual object type.  

```java
Animal a = new Dog();
Dog d = (Dog) a; // ✅ OK
Cat c = (Cat) a; // ❌ ClassCastException
```

---

## 🧠 Exam Tips
- Memorize the **six interface member types**.  
- Understand **sealed class rules**.  
- Spot illegal **record declarations** or **mutable fields**.  
- Master **nested class access rules**.  
- Know **compile-time vs runtime** casting differences.

---
# 🧮 Chapter 8 — Lambda Expressions and Functional Interfaces

## 🔹 Lambda Basics
- **Lambda expressions** let you pass blocks of code as method arguments.
- Full form syntax:
  ```java
  (String a, String b) -> { return a.equals(b); }
  ```
- Parameter types can be **omitted**, and if there’s **one parameter**, parentheses can be removed:
  ```java
  a -> a.equals(b)
  ```
- Braces, semicolon, and `return` can be omitted for single statements.

## 🔹 Scope and Variable Rules
- Lambdas can access:
  - **Instance and class variables**
  - **Local variables** that are *final* or *effectively final*
- Parameter or variable names **cannot conflict** with existing local variables.

## 🔹 Method References
A shorter form of writing lambdas referring to existing methods.  
There are **four types**:
1. **Static method reference:** `ClassName::staticMethod`
2. **Instance method on a specific object:** `instance::method`
3. **Instance method on a parameter:** `ClassName::instanceMethod`
4. **Constructor reference:** `ClassName::new`

## 🔹 Functional Interfaces
- A **functional interface** has a **single abstract method (SAM)**.
- Any functional interface can be implemented using a lambda.

### ✅ Common Functional Interfaces

| Functional Interface | Return Type | Method Name | Parameters |
|----------------------|-------------|--------------|-------------|
| `Supplier<T>` | `T` | `get()` | 0 |
| `Consumer<T>` | `void` | `accept(T)` | 1 (T) |
| `BiConsumer<T,U>` | `void` | `accept(T,U)` | 2 (T, U) |
| `Predicate<T>` | `boolean` | `test(T)` | 1 (T) |
| `BiPredicate<T,U>` | `boolean` | `test(T,U)` | 2 (T, U) |
| `Function<T,R>` | `R` | `apply(T)` | 1 (T) |
| `BiFunction<T,U,R>` | `R` | `apply(T,U)` | 2 (T, U) |
| `UnaryOperator<T>` | `T` | `apply(T)` | 1 (T) |
| `BinaryOperator<T>` | `T` | `apply(T,T)` | 2 (T, T) |

## 📝 Exam Tips
- Understand **lambda syntax variations** — long vs. short form.  
- Memorize the **eight core functional interfaces**.  
- Know that **lambdas require functional interfaces**.  
- Be able to identify **method reference types** quickly.  
- Remember variable scope: only *final* or *effectively final* locals can be used.  
- Expect lambda questions tied to **Streams and Collections** in later chapters.

---

# 🧱 Chapter 9 — Collections and Generics

## 🔹 Java Collections Framework Overview
The **Java Collections Framework (JCF)** includes four main types of data structures:
- **List**
- **Set**
- **Queue / Deque**
- **Map**

The `Collection` interface is the parent interface for `List`, `Set`, and `Queue`.  
`Deque` extends `Queue`.  
The `Map` interface **does not extend Collection**.

---

## 🔹 List
- **Ordered collection** that allows **duplicates**.
- **Implementations:**
  - `ArrayList` → Standard resizable list.
  - `LinkedList` → Efficiently adds/removes from beginning or end.

---

## 🔹 Set
- **No duplicate elements allowed.**
- **Implementations:**
  - `HashSet` → Unordered, uses `hashCode()` for lookup.
  - `LinkedHashSet` → Maintains insertion (encounter) order.
  - `TreeSet` → Sorted set (no `null` allowed).

---

## 🔹 Queue / Deque
- Orders elements for **processing** (FIFO or LIFO depending on use).
- **Implementations:**
  - `ArrayDeque` → Double-ended queue (no `null` allowed).
  - `LinkedList` → Can act as both queue and list.

---

## 🔹 Map
- Maps **unique keys** to **values**.
- **Implementations:**
  - `HashMap` → Unordered, uses `hashCode()` for key lookup.
  - `LinkedHashMap` → Maintains insertion (encounter) order.
  - `TreeMap` → Sorted by key (no `null` keys allowed).

---

## 🔹 Sequenced Collections (Java 21+)
Java 21 introduces **Sequenced Collections** — types with a defined **encounter order**.

| Interface | Implementations |
|------------|------------------|
| `SequencedCollection` | `ArrayDeque`, `ArrayList`, `LinkedList`, `LinkedHashSet`, `TreeSet` |
| `SequencedSet` | `LinkedHashSet`, `TreeSet` |
| `SequencedMap` | `LinkedHashMap`, `TreeMap` |

---

## 🔹 Comparable vs Comparator

### Comparable
- Declared via the `Comparable` interface.
- Method: `compareTo(T o)`
- Used for **natural ordering** of elements.
- Returns:
  - Negative → smaller  
  - Zero → equal  
  - Positive → greater
- Example:
  ```java
  class Product implements Comparable<Product> {
      public int compareTo(Product p) {
          return this.id - p.id;
      }
  }
  ```

### Comparator

* Declared via the `Comparator` interface.
* Method: `compare(T o1, T o2)`
* Used for **custom ordering**.
* Can be implemented using a **lambda expression**:

  ```java
  Comparator<Product> byName = (a, b) -> a.getName().compareTo(b.getName());
  ```

---

## 🔹 Generics

Generics allow **type-safe** and **reusable** code using **type parameters**.

### Declaring Generics

```java
class Box<T> {
    private T content;
    public void set(T content) { this.content = content; }
    public T get() { return content; }
}
```

* `<T>` → Type parameter (common convention: `T`, `E`, `K`, `V`)
* Enforces **compile-time type safety**

---

## 🔹 Wildcards in Generics

| Type            | Description                    | Example                  |
| --------------- | ------------------------------ | ------------------------ |
| `<?>`           | Unbounded wildcard (any type)  | `List<?>`                |
| `<? extends T>` | Upper bound: `T` or subclass   | `List<? extends Number>` |
| `<? super T>`   | Lower bound: `T` or superclass | `List<? super Integer>`  |

### Rules

* **Unbounded** or **upper-bounded** wildcards → cannot add new elements.
* **Lower-bounded** wildcards → can safely add elements of type `T` or its subclasses.

---

## 📝 Exam Tips

* Know the difference between **Collection**, **List**, **Set**, **Queue**, and **Map**.
* Memorize which implementations maintain **order**, **sorting**, and **allow nulls**.
* Understand **Sequenced Collections (Java 21)**.
* Remember that **TreeSet** and **TreeMap** do not allow `null` values/keys.
* Be able to write and interpret **Comparable** and **Comparator** logic.
* Review **Generics** syntax and **wildcard rules**.
* Expect tricky questions on what can or cannot be **added** to a collection when using wildcards.

---


# 🔢 Chapter 10 — Optional, Streams, and Collectors

## 🔹 Optional Basics
`Optional<T>` is a container that may or may not hold a value.

| Method | Purpose |
|:--|:--|
| `isPresent()` | Returns true if a value exists |
| `get()` | Retrieves the value (if present) |
| `orElse(T t)` | Returns value or a default |
| `orElseThrow()` | Throws `NoSuchElementException` if empty |
| `ifPresent(Consumer c)` | Runs `c` when a value exists |
| `orElseGet(Supplier s)` | Lazily creates a fallback value |
| `orElseThrow(Supplier s)` | Lazily throws a custom exception |

**Primitive Optionals**
- `OptionalInt`, `OptionalLong`, `OptionalDouble`
- Accessors: `getAsInt()`, `getAsLong()`, `getAsDouble()`

**Tips**
- Prefer `orElseGet()` over `orElse()` when the default is expensive.
- Avoid chaining `get()` without `isPresent()` → use `map()` or `flatMap()` instead.

---

## 🔹 Stream Pipeline Structure
Every stream pipeline has three parts:

1. **Source** — collection, array, generator, I/O, etc.  
2. **Intermediate operations** (0 or more) — return a new Stream, lazy.  
3. **Terminal operation** (1 only) — triggers execution and consumes the stream.

### Common Intermediate Ops
| Operation | Description |
|:--|:--|
| `filter(Predicate)` | Keeps elements matching the predicate |
| `map(Function)` | Transforms elements |
| `flatMap(Function)` | Flattens nested streams |
| `sorted()` | Natural ordering / custom `Comparator` |

### Common Terminal Ops
| Operation | Purpose |
|:--|:--|
| `forEach()` | Performs action on each element |
| `count()` | Counts elements |
| `collect()` | Gathers results into a collection / map |
| `allMatch()`, `anyMatch()`, `noneMatch()` | Predicate tests on the whole stream |

**Key Point:** Streams are **lazy** — nothing runs until a terminal operation is invoked.

---

## 🔹 Primitive Streams
Primitive specializations avoid boxing overhead:  
`IntStream`, `LongStream`, `DoubleStream`.

| Feature | Description |
|:--|:--|
| `range(start, end)` | half-open → from start to end (exclusive) |
| `rangeClosed(start, end)` | inclusive → from start to end (inclusive) |
| `sum()`, `average()`, `max()`, `min()` | Built-in aggregate ops |
| `summaryStatistics()` | Returns count, sum, min, avg, max at once |

**Example**
```java
IntStream.rangeClosed(1, 5).sum(); // returns 15
```

---

## 🔹 Collectors and Reduction

`Collectors` convert streams back to collections or aggregated forms.

| Collector                                         | Result                                |
| :------------------------------------------------ | :------------------------------------ |
| `toList()`, `toSet()`, `toMap()`                  | Basic collections                     |
| `joining(", ")`                                   | Concatenate Strings                   |
| `counting()`, `summingInt()`, `averagingDouble()` | Numeric reductions                    |
| `groupingBy(Function)`                            | Group by key → `Map<K, List<V>>`      |
| `partitioningBy(Predicate)`                       | Boolean map → `Map<Boolean, List<V>>` |
| `teeing(c1, c2, merger)`                          | Combine two collector results         |

**Partitioning vs Grouping**

* Grouping: any key type possible.
* Partitioning: always `true` and `false` keys (both exist even if empty).

---

## 🔹 Functional Interfaces Recap in Streams

Streams work heavily with:

* `Predicate<T>` → `filter`, `allMatch`
* `Function<T,R>` → `map`
* `Consumer<T>` → `forEach`
* `Supplier<T>` → `generate`
* `Comparator<T>` → `sorted`

---

## 📝 Exam Tips

* Remember **Optionals** are wrappers — they are *not* Serializable or Collections.
* Know difference between `orElse()` (eager) and `orElseGet()` (lazy).
* Streams cannot be reused after a terminal op.
* `flatMap()` flattens stream-of-streams — a common trick question.
* Primitive streams are exclusive for `range()` and inclusive for `rangeClosed()`.
* `Collectors.groupingBy()` vs `partitioningBy()` → memorize their signatures.
* Understand how **lazy evaluation** defers execution until the terminal stage.

---


# 🌍 Chapter 11 — Exceptions, Localization, and Resource Bundles

## 🔹 Exception Handling Overview
Java’s exception system helps applications respond gracefully to runtime issues.

### Exception Types
| Type | Inherits From | Must Be Handled/Declared? | Example |
|------|----------------|----------------------------|----------|
| **Checked** | `Exception` (but *not* `RuntimeException`) | ✅ Yes | `IOException`, `SQLException` |
| **Unchecked** | `RuntimeException` or `Error` | ❌ No | `NullPointerException`, `ArrayIndexOutOfBoundsException` |

**Key rule:**  
- **Checked exceptions** must be *handled or declared* using `throws`.  
- **Unchecked exceptions** do not need to be handled or declared.  
- **Do not catch `Error`** — these represent serious system issues.

---

## 🔹 Custom Exceptions
You can define your own exceptions by extending:
- `Exception` → for **checked** exceptions  
- `RuntimeException` → for **unchecked** exceptions  

**Example:**
```java
class InvalidOrderException extends Exception {
    public InvalidOrderException(String msg) { super(msg); }
}
```

✅ Always include meaningful messages — they appear in stack traces.

---

## 🔹 Try-with-Resources

The **try-with-resources** statement automatically closes resources (like streams or files).
Resources must implement `AutoCloseable` or `Closeable`.

**Syntax:**

```java
try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
    return br.readLine();
}
```

* Resources close **in reverse order** of declaration.
* If multiple exceptions occur, the one thrown during close() becomes **suppressed**.

**Access suppressed exceptions:**

```java
for (Throwable t : e.getSuppressed()) System.out.println(t);
```

---

## 🔹 Number & Date Formatting

Java provides flexible **formatting classes** for locale-sensitive output.

### Common Formatters

| Class                           | Purpose                                                    |
| ------------------------------- | ---------------------------------------------------------- |
| `NumberFormat`                  | Formats numeric, currency, and percentage values           |
| `DateTimeFormatter`             | Formats and parses date/time values                        |
| `CompactNumberFormat` (Java 21) | Displays numbers in short/long form (e.g., 1K, 1 thousand) |

**Example:**

```java
NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
System.out.println(nf.format(1200)); // 1.2K
```

---

## 🔹 Localization & Locale

Localization means adapting an application for different **languages and regions**.

* A `Locale` is created using language and optional country code:

  ```java
  new Locale("en");       // English
  new Locale("en", "US"); // U.S. English
  ```
* Codes:

  * **Language:** lowercase (`en`, `fr`)
  * **Country:** uppercase (`US`, `FR`)

**Formatting example:**

```java
Locale fr = new Locale("fr", "FR");
NumberFormat currency = NumberFormat.getCurrencyInstance(fr);
System.out.println(currency.format(1234.56)); // 1 234,56 €
```

---

## 🔹 Resource Bundles

A `ResourceBundle` stores locale-specific key/value pairs in `.properties` files.

**Lookup order:**

1. Most specific locale →
2. Parent locale →
3. Default locale →
4. Default resource bundle

Once Java finds a match, it **stays within that hierarchy** for all lookups.

**Example:**

```
Messages_en.properties
Messages_en_US.properties
Messages_fr.properties
```

```java
ResourceBundle rb = ResourceBundle.getBundle("Messages", Locale.US);
System.out.println(rb.getString("welcome"));
```

---

## 🧠 Design Principle

By externalizing exceptions, formats, and messages:

* You make applications **resilient to change**.
* You support **internationalization (i18n)** and **localization (l10n)**.
* You improve **maintainability** for global deployment.

---

## 📝 Exam Tips

* Understand the **difference between checked and unchecked** exceptions.
* Know how **try-with-resources** automatically closes and suppresses exceptions.
* Remember **Locale** syntax: language (lowercase) + country (uppercase).
* Practice reading **custom number/date formats** and **CompactNumberFormat** output.
* Learn **ResourceBundle fallback rules** — from most specific to default.
* Don’t catch `Error` — ever.

---

# 🧩 Chapter 12 — The Java Platform Module System (JPMS)

## 🔹 Introduction
The **Java Platform Module System (JPMS)** organizes code at a higher level than packages.  
A module encapsulates related packages and explicitly declares its dependencies and exports.  
The core module `java.base` is automatically required by all other modules.

Each module includes:
- One or more packages
- A `module-info.java` descriptor

---

## 🔹 Compiling & Running Modules
### Compilation
```bash
javac -d mods/com.example.app \
  src/com.example.app/module-info.java src/com.example.app/com/example/app/Main.java
```

### Running

```bash
java --module-path mods -m com.example.app/com.example.app.Main
```

* `--module-path` (`-p`) → path where modules are located
* `--module` (`-m`) → specifies the module and main class in the format `moduleName/className`

---

## 🔹 Module Declarations

A `module-info.java` file defines the module’s metadata and relationships.

### Common Directives

| Directive                                             | Purpose                                                         |
| ----------------------------------------------------- | --------------------------------------------------------------- |
| `exports package.name;`                               | Makes a package accessible outside the module                   |
| `exports package.name to other.module;`               | Exports only to a specific module                               |
| `requires module.name;`                               | Declares dependency on another module                           |
| `requires transitive module.name;`                    | Makes the dependency transitively required                      |
| `opens package.name;`                                 | Allows reflection access (for frameworks like JSON/XML mappers) |
| `uses service.Interface;`                             | Declares that this module consumes a service                    |
| `provides service.Interface with service.impl.Class;` | Declares that this module provides an implementation            |

**Example:**

```java
module com.bookbazaar.app {
    requires com.bookbazaar.model;
    requires transitive com.bookbazaar.utils;
    exports com.bookbazaar.app.api;
    uses com.bookbazaar.payment.PaymentGateway;
    provides com.bookbazaar.payment.PaymentGateway
        with com.bookbazaar.payment.impl.CreditCardPayment;
}
```

---

## 🔹 Inspecting and Managing Modules

Java offers multiple tools to work with modules:

| Tool                                 | Purpose                                                           |
| ------------------------------------ | ----------------------------------------------------------------- |
| `java --list-modules`                | Lists available modules in the runtime                            |
| `java --describe-module module.name` | Describes module contents                                         |
| `jar --describe-module`              | Displays information about a module JAR                           |
| `jdeps`                              | Prints package and module dependencies                            |
| `jmod`                               | Used for `.jmod` archives (for platform modules)                  |
| `jlink`                              | Creates a **custom runtime image** containing only needed modules |
| `jpackage`                           | Builds an **application image** for OS distribution               |

---

## 🔹 Types of Modules

| Type                 | Description                                                                         | Location        |
| -------------------- | ----------------------------------------------------------------------------------- | --------------- |
| **Named module**     | Has a `module-info.java`; lives on the **module path**; can read only other modules | `--module-path` |
| **Automatic module** | JAR on module path without `module-info.java`; automatically gets a name            | `--module-path` |
| **Unnamed module**   | Legacy JAR or class on the classpath; can read everything but not read by others    | `--class-path`  |

**Example of automatic module naming:**

* If a JAR has `Automatic-Module-Name: com.utils` in its manifest → that becomes its module name.

---

## 🔹 Migration Strategies

### 1. Top-Down Migration

* Start with **high-level modules** (those with many dependencies).
* Move them to the module path first.
* Place dependent legacy code temporarily on the classpath.

### 2. Bottom-Up Migration

* Start with **leaf modules** (few or no dependencies).
* Gradually move one module at a time to the module path.
* Ensures stability and avoids dependency breakage.

### ⚠️ Rule: No Cyclic Dependencies

JPMS **does not allow cyclic dependencies** between modules.
Refactor packages to remove cycles before modularizing.

---

## 🔹 Key Commands Recap

| Command                                                                                      | Description                 |
| -------------------------------------------------------------------------------------------- | --------------------------- |
| `javac -p mods -d out src/module-info.java src/...`                                          | Compiles a module           |
| `java -p out -m module/class`                                                                | Runs a module               |
| `jar --create --file=app.jar -C out/module .`                                                | Packages module as JAR      |
| `jdeps --module-path mods -s out/app.jar`                                                    | Summarizes dependencies     |
| `jlink --module-path $JAVA_HOME/jmods:mods --add-modules module.name --output customruntime` | Creates a minimal runtime   |
| `jpackage --input out --name AppName --main-jar app.jar`                                     | Creates a native app bundle |

---

## 🧠 Design Benefits

* **Strong encapsulation:** Only exported packages are visible externally.
* **Reliable configuration:** Fails fast on missing dependencies.
* **Custom runtime images:** Smaller footprint with only needed modules.
* **Better maintainability:** Clear boundaries between components.

---

## 📝 Exam Tips

* Remember `java.base` is **implicitly required** by all modules.
* Know the difference between `exports` and `opens`.
* `requires transitive` allows dependency propagation.
* Recognize the three module types: **named**, **automatic**, **unnamed**.
* Learn the purposes of **jdeps**, **jmod**, **jlink**, and **jpackage**.
* Know migration strategies and **why cyclic dependencies break builds**.
* On the exam, **expect code snippets** of `module-info.java` files with tricky directive combinations.

---

# ⚙️ Chapter 13 — Concurrency and Parallel Streams

## 🔹 Threads Overview
Java provides two main types of threads:
- **Platform threads** — traditional OS-managed threads.
- **Virtual threads** (Java 21) — lightweight, managed by the JVM, allowing massive concurrency with minimal overhead.

Threads represent units of execution.  
You define their work using a `Runnable` or `Callable`.

### Creating Threads
```java
Runnable task = () -> System.out.println("Running in " + Thread.currentThread().getName());
Thread t = new Thread(task);
t.start();
```

**Using Callable**

```java
Callable<String> task = () -> "Result";
Future<String> result = Executors.newSingleThreadExecutor().submit(task);
System.out.println(result.get());
```

* `Runnable` → no return value.
* `Callable` → returns a result or throws an exception.

---

## 🔹 ExecutorService

The **Concurrency API** simplifies thread management via executors.

### Creating Executors

| Executor Type                   | Description                         |
| ------------------------------- | ----------------------------------- |
| `newSingleThreadExecutor()`     | One worker thread                   |
| `newFixedThreadPool(int n)`     | Reuses a fixed number of threads    |
| `newCachedThreadPool()`         | Dynamically grows/shrinks threads   |
| `newScheduledThreadPool(int n)` | Supports delayed and periodic tasks |

**Example:**

```java
ExecutorService service = Executors.newFixedThreadPool(4);
service.submit(() -> processOrder());
service.shutdown();
```

### Scheduled Executor

```java
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
scheduler.scheduleAtFixedRate(() -> System.out.println("Tick"), 1, 2, TimeUnit.SECONDS);
```

---

## 🔹 Thread Safety

**Thread safety** means multiple threads can access shared data **without corruption**.

### Common Tools

| Mechanism         | Description                                            |
| ----------------- | ------------------------------------------------------ |
| `synchronized`    | Locks methods or blocks to prevent simultaneous access |
| `Lock` interface  | Explicit control over locking/unlocking                |
| `Atomic*` classes | Perform atomic (indivisible) operations                |
| `CyclicBarrier`   | Waits until all threads reach a common point           |
| `volatile`        | Guarantees visibility of changes across threads        |

**Example:**

```java
synchronized void increment() { count++; }
```

---

## 🔹 Concurrent Collections

Collections in `java.util.concurrent` are designed for multi-threaded environments.

| Class                   | Description                                     |
| ----------------------- | ----------------------------------------------- |
| `ConcurrentHashMap`     | Thread-safe hash map with segment-level locking |
| `CopyOnWriteArrayList`  | Recreates list on modification (read-heavy)     |
| `ConcurrentLinkedQueue` | Non-blocking queue                              |
| `BlockingQueue`         | Supports producer/consumer patterns             |
| `ConcurrentSkipListMap` | Thread-safe sorted map                          |

**Tip:**
Use concurrent collections instead of manual synchronization when possible.

---

## 🔹 Common Concurrency Issues

| Issue              | Description                                      | Example Problem                                                    |
| ------------------ | ------------------------------------------------ | ------------------------------------------------------------------ |
| **Deadlock**       | Threads wait on each other indefinitely          | Thread A locks 1 and waits for 2, Thread B locks 2 and waits for 1 |
| **Starvation**     | Threads never get CPU time                       | High-priority threads monopolize resources                         |
| **Livelock**       | Threads keep changing state but make no progress | Two threads repeatedly yielding to each other                      |
| **Race condition** | Threads read/write shared data unsafely          | Multiple increments on shared counter                              |

🧠 **For the exam:** Know the definitions and simple scenarios, not full debugging solutions.

---

## 🔹 Parallel Streams

Parallel streams automatically distribute stream operations across multiple threads.

**Example:**

```java
List<String> list = List.of("a", "b", "c", "d");
list.parallelStream()
    .map(String::toUpperCase)
    .forEach(System.out::println);
```

### Benefits

* Improves performance on large datasets.
* Handles splitting and joining automatically.

### Risks

* Order of processing is **not guaranteed**.
* Avoid **stateful lambdas** (modifying shared variables).
* Only use when the workload is **CPU-bound** and data is large enough to justify threading overhead.

**Example of unsafe operation:**

```java
List<Integer> data = new ArrayList<>();
IntStream.range(0, 1000).parallel().forEach(data::add); // ❌ race condition
```

---

## 🔹 Virtual Threads (Java 21+)

Virtual threads are lightweight, allowing millions of concurrent tasks.

**Example:**

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
    IntStream.range(0, 10).forEach(i ->
        executor.submit(() -> System.out.println("Task " + i))
    );
}
```

✅ Automatically managed by JVM; no manual pooling required.

---

## 🧠 Best Practices

* Use `ExecutorService` instead of raw `Thread`.
* Use `try-with-resources` with executors (Java 21+) to auto-shutdown.
* Keep shared state immutable or synchronized.
* Prefer **atomic** or **concurrent** classes for shared data.
* Avoid blocking operations in **parallel streams**.
* Choose virtual threads for I/O-bound workloads.

---

## 📝 Exam Tips

* Know differences between **Runnable** and **Callable**.
* Understand **ExecutorService** creation, shutdown, and scheduling.
* Identify **thread-safe classes** vs unsafe ones.
* Be able to spot **deadlock**, **starvation**, and **race conditions**.
* Recognize **parallel stream pitfalls** — stateful lambdas, unordered output.
* Understand when and why to use **virtual threads**.
* Remember: **Atomic classes** and **Concurrent Collections** are your safest tools.

---


# 📂 Chapter 14 — I/O and NIO.2: Reading and Writing Data

## 🔹 Overview
This chapter focuses on **reading and writing data** in Java — both the traditional I/O API (`java.io`) and the modern **NIO.2 API** (`java.nio.file`).  
You’ll learn how to:
- Create, read, and manipulate files and directories.
- Work with streams for input/output.
- Use NIO.2’s `Path`, `Files`, and `FileSystem` utilities.
- Handle metadata and serialization.

---

## 🔹 I/O vs NIO.2
| Feature | `java.io` | `java.nio.file` (NIO.2) |
|----------|------------|--------------------------|
| Core Type | `File` | `Path` |
| Introduced In | Java 1.0 | Java 7 |
| Style | Stream-based, blocking | Channel/Path-based, flexible |
| Supports Metadata | Limited | Extensive |
| Stream API Support | No | Yes (e.g. `Files.lines()`) |

---

## 🔹 Working with Files and Paths

### Creating Paths
```java
Path p1 = Path.of("data", "input.txt");
Path p2 = Paths.get("/home/user/docs/file.txt");
```

### Combining & Resolving Paths

```java
Path base = Path.of("/data");
Path full = base.resolve("file.txt"); // /data/file.txt
Path parent = full.getParent();       // /data
```

### Normalizing Paths

Removes redundant elements like `.` and `..`:

```java
Path p = Path.of("/data/../temp/file.txt").normalize(); // /temp/file.txt
```

---

## 🔹 NIO.2 Stream API

The `Files` class provides convenient stream-based methods.

| Method                                 | Description                                |
| :------------------------------------- | :----------------------------------------- |
| `Files.list(Path)`                     | Stream of direct children (not recursive)  |
| `Files.walk(Path)`                     | Stream of all descendants (recursive)      |
| `Files.find(Path, depth, BiPredicate)` | Search by condition                        |
| `Files.lines(Path)`                    | Stream of file lines (lazy, UTF-8 default) |

**Example:**

```java
Files.walk(Path.of("src"))
     .filter(Files::isRegularFile)
     .forEach(System.out::println);
```

---

## 🔹 Files Helper Methods

`Files` contains dozens of static helper methods — the **method names describe their purpose** clearly.

| Method                                       | Purpose                              |
| -------------------------------------------- | ------------------------------------ |
| `exists(path)`                               | Check file/directory presence        |
| `isDirectory(path)`                          | Verify if path is directory          |
| `createFile(path)` / `createDirectory(path)` | Create new file/directory            |
| `copy(source, target, REPLACE_EXISTING)`     | Copy files                           |
| `move(source, target)`                       | Move or rename                       |
| `delete(path)`                               | Delete file/directory                |
| `readAllLines(path)`                         | Read all lines into a `List<String>` |
| `write(path, bytes)`                         | Write binary data to file            |

⚠️ Most of these methods can throw an **IOException**, and many accept **varargs enums** like `StandardOpenOption.APPEND`.

---

## 🔹 I/O Streams

Streams handle **byte** or **character** data flow.

### Stream Types

| Category              | Example Classes                           | Description              |
| --------------------- | ----------------------------------------- | ------------------------ |
| **Byte Streams**      | `FileInputStream`, `FileOutputStream`     | Raw binary data          |
| **Character Streams** | `FileReader`, `FileWriter`                | Text data                |
| **Buffered Streams**  | `BufferedReader`, `BufferedWriter`        | Improves performance     |
| **Print Streams**     | `PrintStream`, `PrintWriter`              | Formatted output         |
| **Object Streams**    | `ObjectInputStream`, `ObjectOutputStream` | Serialization of objects |

### Wrapping Streams

Common pattern:

```java
try (var in = new BufferedReader(new FileReader("input.txt"))) {
    in.lines().forEach(System.out::println);
}
```

---

## 🔹 Serialization

To persist objects, a class must implement `Serializable`.

**Example:**

```java
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
}
```

```java
try (var out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
    out.writeObject(new User("Alice"));
}
```

* Transient fields (`transient`) are **not serialized**.
* Deserialization restores objects using the binary representation.

---

## 🔹 Console and System Streams

**System Streams:**

* `System.in` → Input stream
* `System.out` → Standard output
* `System.err` → Error output

**Console API:**

```java
Console console = System.console();
String name = console.readLine("Enter name: ");
char[] password = console.readPassword("Password: ");
```

✅ Console provides **secure input** for passwords and formatted printing.

---

## 🔹 File Metadata with NIO.2

You can retrieve and modify file attributes efficiently using `Files`.

**Examples:**

```java
BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
System.out.println(attrs.creationTime());

FileTime newTime = FileTime.fromMillis(System.currentTimeMillis());
Files.setLastModifiedTime(path, newTime);
```

| Method                             | Purpose                      |
| ---------------------------------- | ---------------------------- |
| `readAttributes(path, type)`       | Read file attributes         |
| `setAttribute(path, name, value)`  | Modify single attribute      |
| `getFileAttributeView(path, type)` | Get updatable attribute view |

**Two attribute approaches:**

* **Read-only:** via `readAttributes()`
* **Updatable:** via `getFileAttributeView()`

Also supports **OS-specific attributes** (e.g., POSIX, DOS).

---

## 🔹 Best Practices

* Always use **try-with-resources** to close streams safely.
* Use **Buffered** or **NIO.2 Streams** for performance.
* Avoid manual path concatenation — use `resolve()` instead.
* Use **Object streams** for serialization when needed.
* Leverage **Streams API** with `Files.walk()` for powerful directory processing.

---

## 📝 Exam Tips

* Know the difference between **File (I/O)** and **Path (NIO.2)**.
* Remember that **most `Files` methods throw `IOException`**.
* Understand **stream hierarchy**: byte vs character, input vs output, low vs high-level.
* Recognize common **stream wrapper chains** (e.g., `BufferedReader → FileReader`).
* Be able to identify **serialization requirements** (`Serializable`, `transient`).
* Understand **`Files.walk()` vs `Files.list()`** vs `Files.find()`.
* Know how to access **metadata** and **file attributes** via NIO.2.
* Expect exam questions about **try-with-resources** and **suppressed exceptions**.

---


