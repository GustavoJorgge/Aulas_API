ALTER TABLE professores ADD COLUMN ativo boolean DEFAULT true;
UPDATE professores SET ativo = true;
ALTER TABLE professores ALTER COLUMN ativo SET NOT NULL;
