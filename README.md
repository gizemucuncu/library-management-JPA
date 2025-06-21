# 📚 Library Management System – JPA with PostgreSQL

Bu proje, bir kütüphane yönetim sisteminin Java (Spring’siz) + JPA + PostgreSQL teknolojileri ile geliştirilmiş bir temel halidir. Amaç, **Entity** sınıflarının doğru şekilde modellenmesi ve ilişkilerin veritabanında yansıtılmasıdır.

## 🎯 Hedeflenen Entity Yapıları

- **Book**: Kitap bilgilerini içerir.
- **Author**: Yazar bilgileri
- **Publisher**: Yayın evi detayları
- **Category**: Kategoriler
- **BookBorrowing**: Ödünç alınan kitap işlemleri
- **Book_Category (join table)**: Many-to-Many ilişkisi için ara tablo

---

## 🧱 Tablolar ve Yapıları

### 🧑 Author Tablosu

| Kolon Adı      | Tipi              | Açıklama                  |
|----------------|-------------------|---------------------------|
| `author_id`    | PK, integer        | Yazar ID (Primary Key)    |
| `birth_date`   | date              | Doğum tarihi              |
| `author_name`  | varchar(100)      | Adı                       |
| `author_country` | varchar(255)    | Ülkesi                    |

[Author Table]<img width="939" alt="Ekran Resmi 2025-06-21 17 06 11" src="https://github.com/user-attachments/assets/1101e32d-777f-44ff-b0f9-895ecfaba692" />

---

### 📘 BookBorrowings Tablosu

| Kolon Adı         | Tipi            | Açıklama                        |
|------------------|-----------------|----------------------------------|
| `borrowed_book_id` | integer        | Kitap ID                        |
| `borrower_id`     | PK, integer     | İşlem ID (Primary Key)          |
| `borrowing_date`  | date            | Alınma tarihi                   |
| `return_date`     | date            | Teslim tarihi                   |
| `borrower_name`   | varchar(100)    | Kitabı alan kişi                |

[BookBorrowings Table]<img width="939" alt="Ekran Resmi 2025-06-21 17 06 30" src="https://github.com/user-attachments/assets/da372c79-7934-44da-a8d8-1cbb15c0c358" />

---

### 🔁 Book_Category (Join Table)

| Kolon Adı    | Tipi     | Açıklama                     |
|-------------|----------|------------------------------|
| `book_id`   | integer  | Kitap ID (FK)                |
| `category_id` | integer| Kategori ID (FK)             |

[BookCategory Join Table]<img width="939" alt="Ekran Resmi 2025-06-21 17 06 41" src="https://github.com/user-attachments/assets/e200a919-c73e-48f8-8680-f25371966bc2" />

---

### 📚 Books Tablosu

| Kolon Adı           | Tipi           | Açıklama                    |
|---------------------|----------------|-----------------------------|
| `book_id`           | PK, integer    | Kitap ID                    |
| `book_name`         | varchar(100)   | Kitap adı                   |
| `publication_year`  | date           | Yayın yılı                  |
| `book_stock`        | integer        | Stok miktarı                |
| `book_author_id`    | integer (FK)   | Yazar ID                    |
| `book_publisher_id` | integer (FK)   | Yayınevi ID                 |
| `customer_mail`     | varchar(255)   | Kitabı alan kişinin e-posta|

[Books Table]<img width="939" alt="Ekran Resmi 2025-06-21 17 06 53" src="https://github.com/user-attachments/assets/3b6ac0bc-aafe-4bc6-aae3-04db659f6f60" />

---

### 🏷️ Categories Tablosu

| Kolon Adı              | Tipi           | Açıklama                    |
|------------------------|----------------|-----------------------------|
| `category_id`          | PK, integer    | Kategori ID                 |
| `category_name`        | varchar(100)   | Kategori Adı                |
| `category_description` | varchar(255)   | Açıklama                    |

[Categories Table]<img width="939" alt="Ekran Resmi 2025-06-21 17 07 04" src="https://github.com/user-attachments/assets/630caf57-2b90-4cee-a2ab-fe2bc1130508" />

---

### 🏢 Publishers Tablosu

| Kolon Adı           | Tipi            | Açıklama                     |
|---------------------|-----------------|------------------------------|
| `publisher_id`      | PK, integer     | Yayın evi ID                 |
| `publisher_name`    | varchar(100)    | Yayın evi adı                |
| `establishment_year`| date            | Kuruluş yılı                 |
| `publisher_address` | integer         | Adres bilgisi                |

[Publishers Table]<img width="939" alt="Ekran Resmi 2025-06-21 17 07 17" src="https://github.com/user-attachments/assets/843d2a45-fb36-4fe5-92b1-abc1380b12e1" />

---

## 💾 Teknolojiler

- Java 21
- JPA (Hibernate)
- PostgreSQL
- IntelliJ IDEA CE
- JDBC driver (org.postgresql.Driver)

## ⚙️ Persistence Ayarları (JPA)

```xml
<persistence-unit name="library-jpa" transaction-type="RESOURCE_LOCAL">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <properties>
        <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
        <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/library-jpa"/>
        <property name="jakarta.persistence.jdbc.user" value="postgres"/>
        <property name="jakarta.persistence.jdbc.password" value="postgres"/>
        <property name="hibernate.hbm2ddl.auto" value="create-drop"/>
        <property name="hibernate.show_sql" value="true"/>
    </properties>
</persistence-unit>
