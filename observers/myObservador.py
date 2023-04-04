from observers.observador import Observador


class MyObservador(Observador):
    def atualizar(self, observavel):
        print("estou sendo observado -> Estado mudou para:", observavel.estado)