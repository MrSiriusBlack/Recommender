CREATE TABLE IF NOT EXISTS document (
                                        id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                        text TEXT NOT NULL
);