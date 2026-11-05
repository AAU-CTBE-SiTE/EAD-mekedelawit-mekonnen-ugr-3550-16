A refactored Java and Spring Framework project demonstrating Inversion of Control (IoC) and Dependency Injection using modern Java-based configuration and annotations.

## Features Covered
* **Java-Based Configuration:** Uses `@Configuration` and `AnnotationConfigApplicationContext` instead of XML.
* **Component Scanning:** Automatic bean detection using `@Component`.
* **Dependency Injection:**
  * **Constructor Injection** with `@Autowired` for injecting complex objects (`Address`) and collection types (`List<Subject>`).
  * Explicit bean declarations using `@Bean` for managing multiple `Subject` instances.
