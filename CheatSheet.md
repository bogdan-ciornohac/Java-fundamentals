# Java OCP — Chapter 5 Cheatsheet: Inheritance and Class Design

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
