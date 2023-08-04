package api.aula.particular.domain.professor;

public record DadosListagemProfessor(Long id, String nome, String email, String cpf, Disciplina disciplina) {

    //Criando contrutor que recebe por parametro o Objeto Professor
    public DadosListagemProfessor(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getDisciplina());
    }
}
