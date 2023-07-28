package api.aula.particular.aluno;

public record DadosListagemAluno(Long id, String nome, String email, String cpf) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

}
