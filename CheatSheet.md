# Java OCP — Chapter 6 Cheatsheet: Inheritance and Class Design

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