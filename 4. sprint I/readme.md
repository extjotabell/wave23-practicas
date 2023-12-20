# Sprint 1 - Parte B Requerimientos individuales

US 0010: Llevar a cabo la publicación de un nuevo producto en promoción.

US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor.

US 0012: Obtener la cantidad de seguidos de un usuario.(Bonus)

## Bonus: API Reference

#### US 0012 URL

```http
  GET /users/{user_id}/followed/count
```

| Method | Sign     |
| :-------- | :------- |
| `GET` | `/users/{user_id}/followed/count` |
| `RESPONSE` | `{ "user_id": 4, "user_name": "Sofia Gomez", "followed_count": 2}` |

Filtros/Parámetros
| Parámetro | Tipo     | Descripcion |
| :-------- | :------- | :----------------- |
| `user_id` | `int` | `Número que identifica a cada usuario` |
