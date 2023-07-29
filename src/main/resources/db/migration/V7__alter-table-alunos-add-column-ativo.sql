ALTER TABLE alunos ADD COLUMN ativo boolean DEFAULT true;
UPDATE alunos SET ativo = true;
ALTER TABLE alunos ALTER COLUMN ativo SET NOT NULL;