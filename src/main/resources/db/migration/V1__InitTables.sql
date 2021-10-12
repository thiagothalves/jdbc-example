CREATE TABLE employee (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    birth_date DATE NOT NULL,
    unique (name)
);
