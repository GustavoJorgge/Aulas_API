ALTER TABLE professores ADD telefone varchar(20);
UPDATE professores SET telefone = 'valor_padrao';
ALTER TABLE professores ALTER COLUMN telefone SET NOT NULL;