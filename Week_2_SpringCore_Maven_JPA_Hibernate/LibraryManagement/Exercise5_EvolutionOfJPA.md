# Exercise 5: Evolution and Benefits of Spring Data JPA

## 1. Evolution of ORM
* **JDBC:** Manual SQL, heavy boilerplate, difficult to maintain.
* **Hibernate (XML):** Mapped objects to relational databases, but XML configuration was bulky.
* **Hibernate (Annotations):** Replaced XML with cleaner annotations like @Entity.
* **Spring Data JPA:** Removed even the Hibernate boilerplate. Just define interfaces, and Spring writes the implementation!

## 2. Benefits
* **Database Independent:** Switch from H2 to MySQL with just a property change.
* **Lightweight:** Highly optimized and open source.
* **No Boilerplate:** Zero need to write basic CRUD operations manually.
