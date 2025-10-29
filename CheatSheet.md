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