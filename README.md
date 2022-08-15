# Spring JPA Many-to-Many Example

JPA Entity setup and use of @JsonBackReference and @JsonManagedReference to prevent stackoverflow

Add Student request endpoint: 
> POST: http://localhost:8080/api/student

Request:

```json
{
  "name": "John",
  "age": 37,
  "dept": "IT",
  "courses": [
    {
      "title": "Angular",
      "abbreviation": "NG",
      "modules": 12,
      "fee": 75
    },
    {
      "title": "React",
      "abbreviation": "RJS",
      "modules": 11,
      "fee": 60
    }
  ]
}
```

Response:

```json
{
    "id": 1,
    "name": "John",
    "age": 37,
    "dept": "IT",
    "courses": [
        {
            "id": 1,
            "title": "Angular",
            "abbreviation": "NG",
            "modules": 12,
            "fee": 75.0,
            "students": null
        },
        {
            "id": 2,
            "title": "React",
            "abbreviation": "RJS",
            "modules": 11,
            "fee": 60.0,
            "students": null
        }
    ]
}
```