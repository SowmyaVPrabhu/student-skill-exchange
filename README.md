# PeerLearn 🌐

PeerLearn is a student-to-student skill exchange platform built using Spring Boot. It enables users to share their expertise, learn new skills, and connect with others through a request-based learning system.

---

## 🚀 Features

- User Registration and Login
- Secure Authentication with Spring Security and BCrypt
- User Profile Management
- Add, Edit, and Delete Skills
- Search Skills
- Skill Matching System
- Send Learning Requests
- Incoming Requests
- Sent Requests
- Accept and Reject Requests
- Dashboard Statistics
- Responsive UI with Bootstrap
- Logout Functionality

---

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

### Frontend
- Thymeleaf
- HTML
- CSS
- Bootstrap 5

### Database
- MySQL

### Tools
- IntelliJ IDEA
- Maven
- Git
- GitHub

---

## 📂 Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── config
 └── templates
```

---

## Application Preview

<img width="1900" height="857" alt="image" src="https://github.com/user-attachments/assets/9482562e-83ce-4736-a056-4aaa90f5a4d7" />



---

## ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/SowmyaVPrabhu/student-skill-exchange.git
```

### Navigate to Project

```bash
cd SkillSphere
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/skill_exchange
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

Application will run on:

```
http://localhost:8080
```

---

## 📌 Future Enhancements

- JWT Authentication
- REST APIs
- User Profile Picture Upload
- Notifications
- Dark Mode


---

## 👨‍💻 Author

**Sowmya V Prabhu**

- GitHub: https://github.com/SowmyaVPrabhu
- LinkedIn: https://linkedin.com/in/sowmyavprabhu

---

⭐ If you found this project useful, consider giving it a star!
