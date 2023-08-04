package api.aula.particular.domain.aluno;

public record DadosListagemAluno(Long id, String nome, String email, String cpf) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

}
