package api.aula.particular.aluno;

public record DadosListagemAluno(String nome, String email, String cpf) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }

}
