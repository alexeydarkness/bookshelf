# Bookshelf

REST API сервис для управления личной библиотекой книг. Написан на Java с использованием Spring Boot.

## Стек технологий

- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Docker / Docker Compose

## Функционал

- Добавление, редактирование и удаление книг
- Получение книги по ID
- Поиск по автору и/или названию
- Валидация входящих данных
- Обработка ошибок (GlobalExceptionHandler, кастомные исключения)

## Эндпоинты

| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/api/books` | Получить все книги |
| GET | `/api/books/{id}` | Получить книгу по ID |
| POST | `/api/books` | Добавить книгу |
| PUT | `/api/books/{id}` | Обновить книгу |
| DELETE | `/api/books/{id}` | Удалить книгу |
| GET | `/api/books/search/author?name=` | Поиск по автору |
| GET | `/api/books/search/title?keyword=` | Поиск по названию |
| GET | `/api/books/search/?author=&title=` | Комбинированный поиск |

## Запуск через Docker Compose

```bash
docker-compose up --build
```

Сервис будет доступен на `http://localhost:8080`

## Запуск локально

1. Убедись что запущен PostgreSQL с базой `restapi`
2. Настрой подключение в `application.properties` или через переменные окружения:

```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/restapi
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=123
```

3. Запусти приложение:

```bash
./mvnw spring-boot:run
```

## Пример запроса

```bash
# Добавить книгу
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title": "Мастер и Маргарита", "author": "Булгаков"}'

# Найти по автору
curl http://localhost:8080/api/books/search/author?name=Булгаков
```
