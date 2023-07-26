package api.aula.particular.professor;

public record DadosListagemProfessor(String nome, String email, String cpf, Disciplina disciplina) {

    //Criando contrutor que recebe por parametro o Objeto Professor
    public DadosListagemProfessor(Professor professor){
        this(professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getDisciplina());
    }
}
