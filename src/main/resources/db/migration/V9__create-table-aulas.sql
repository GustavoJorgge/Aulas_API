CREATE TABLE aulas (
    id SERIAL PRIMARY KEY,
    professor_id bigint NOT NULL,
    aluno_id bigint NOT NULL,
    data timestamp NOT NULL,

    CONSTRAINT fk_aulas_professor_id FOREIGN KEY (professor_id) REFERENCES professores (id),
    CONSTRAINT fk_aulas_aluno_id FOREIGN KEY (aluno_id) REFERENCES alunos (id)
);
