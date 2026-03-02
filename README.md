# 📘 Lab -- Dependency Injection and Loose Coupling in Java

## 📌 Objective

This lab aims to:

- Understand the concept of **loose coupling**
- Implement the principle of **Inversion of Control (IoC)**
- Implement **Dependency Injection (DI)** in different

ways
- Use the Spring framework to automatically manage

------------------------------------------------------------------------

# 🏗 Project Architecture

The project is structured according to the following model:

src/main/java

└── tech/example

├── dao

│ ├── IDao.java

│ └── DaoImpl.java

├── metier

│ ├── IMetier.java

│ └── MetierImpl.java

└── presentation
└── Presentation.java

------------------------------------------------------------------------

# 📝 Lab Steps

## 1️⃣ Creating the IDao Interface

Define an interface `IDao` containing a method:

``` java
double getData();

```

------------------------------------------------------------------------

## 2️⃣ Implementing the IDao Interface

Create a class `DaoImpl` that implements `IDao` and provides a

concrete implementation of the `getData()` method.

------------------------------------------------------------------------

## 3️⃣ Creating the IMetier Interface

Define an interface `IMetier` containing a method:

``` java
double calcul();

```

------------------------------------------------------------------------

## 4️⃣ Implementation with Loose Coupling

Create `MetierImpl` which:

- Implements `IMetier`
- Depends on `IDao`
- Receives its dependency via injection (and not via direct instantiation)

Example:

``` java
private IDao dao;

public void setDao(IDao dao) {
    this.dao = dao;
}
```

This ensures **loose coupling** between the business and DAO layers.

------------------------------------------------------------------------

# 💉 5️⃣ Dependency Injection

## a) Static Instantiation Injection

In the presentation class:

``` java
IDao dao = new DaoImpl();

IMetier metier = new MetierImpl();

((MetierImpl) metier).setDao(dao);

System.out.println(metier.calcul());

```

------------------------------------------------------------------------

## b) Dynamic Instantiation Injection (Reflection)

- Read class names from a `config.txt` file
- Use Java reflection (`Class.forName`)
- Dynamically instantiate objects
- Automatically inject the dependency

Objective: to completely decouple configuration from code.

----------------------------------------------------------------------------------

## c) Injection via Spring Framework

### 🔹 XML version

Create an `applicationContext.xml` file:

``` xml
<beans> 
    <bean id="dao" class="tech.rayane.dao.DaoImpl"/> 
    <bean id="metier" class="tech.rayane.metier.MetierImpl"> 
        <property name="dao" ref="dao"/> 
    </bean>
</beans>
```

In the main class:

``` java
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

IMetier business = context.getBean(IMetier.class);
System.out.println(metier.calcul());
``

------------------------------------------------------------------------

### 🔹 Version Annotations

Annotate the classes:

``` java
@Component("dao")
public class DaoImpl implements IDao
```

``` java
@Component("metier")
public class MetierImpl implements IMetier {

@Autowired
@Qualifier("dao")
private IDao dao;

}
```

Configure component scanning:

``` java
ApplicationContext springContext = new AnnotationConfigApplicationContext("tech.rayane");
IMetier metier = springContext.getBean(IMetier.class);

System.out.println("Res = " + metier.calcul());
```

Then launch the application using `AnnotationConfigApplicationContext`.

------------------------------------------------------------------------

# 🚀 Execution

Compilation:

mvn clean compile

Execution:

mvn exec:java -Dexec.mainClass="tech.rayane.presentation.<presntation-name>

------------------------------------------------------------------------

# 📚 Conclusion

This lab demonstrates the progressive evolution of:

1. Direct instantiation (tight coupling)
2. Manual injection (loose coupling)
3. Dynamic injection (reflection)
4. Injection via a professional IoC container (Spring)

Using the Spring framework allows for clean, flexible, and scalable dependency management, in accordance with best practices for enterprise application development.

