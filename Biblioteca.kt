
class Livro(var titulo: String, var autor: String, var disponivel: Boolean = true) {
    fun exibirDetalhes() {
        println("Título: $titulo, Autor: $autor, Disponível: ${if (disponivel) "Sim" else "Não"}")
    }
}


class Usuario(var nome: String) {
    var livrosEmprestados = mutableListOf<Livro>()

    fun emprestarLivro(livro: Livro, biblioteca: Biblioteca) {
        if (livro.disponivel) {
            livrosEmprestados.add(livro)
            livro.disponivel = false
            println("$nome emprestou o livro '${livro.titulo}'.")
        } else {
            println("O livro '${livro.titulo}' não está disponível.")
        }
    }

    fun devolverLivro(livro: Livro, biblioteca: Biblioteca) {
        if (livrosEmprestados.contains(livro)) {
            livrosEmprestados.remove(livro)
            livro.disponivel = true
            println("$nome devolveu o livro '${livro.titulo}'.")
        } else {
            println("$nome não pode devolver o livro '${livro.titulo}' porque não o emprestou.")
        }
    }
}


class Biblioteca {
    var livros = mutableListOf<Livro>()

    fun adicionarLivro(livro: Livro) {
        livros.add(livro)
    }

    fun exibirLivrosDisponiveis() {
        println("Livros disponíveis para empréstimo:")
        for (livro in livros) {
            if (livro.disponivel) {
                println("- ${livro.titulo} por ${livro.autor}")
            }
        }
    }
}


fun main() {
    // Criando alguns livros
    var livro1 = Livro("1984", "George Orwell")
    var livro2 = Livro("A Revolução dos Bichos", "George Orwell")
    var livro3 = Livro("Dom Casmurro", "Machado de Assis")

    // Criando uma biblioteca
    var biblioteca = Biblioteca()

    // Adicionando livros à biblioteca
    biblioteca.adicionarLivro(livro1)
    biblioteca.adicionarLivro(livro2)
    biblioteca.adicionarLivro(livro3)

    // Exibindo os livros disponíveis
    println("Antes dos empréstimos:")
    biblioteca.exibirLivrosDisponiveis()

    // Criando um usuário
    var usuario1 = Usuario("Carlos")

    // Usuário empresta um livro
    usuario1.emprestarLivro(livro1, biblioteca)

    // Exibindo os livros disponíveis após o empréstimo
    println("Depois de Carlos pegar um livro:")
    biblioteca.exibirLivrosDisponiveis()

    // Usuário devolve o livro
    usuario1.devolverLivro(livro1, biblioteca)

    // Exibindo os livros disponíveis após a devolução
    println("Depois de Carlos devolver o livro:")
    biblioteca.exibirLivrosDisponiveis()
}
