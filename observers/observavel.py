class Observavel:
    def __init__(self):
        self.observadores = []
        self.estado = True

    def adicionar_observador(self, observador):
        self.observadores.append(observador)

    def remover_observador(self, observador):
        self.observadores.remove(observador)

    def notificar_observadores(self):
        for observador in self.observadores:
            observador.atualizar(self)

    def definir_estado(self, estado):
        print(f'mudança de estado para -> {estado}')
        self.estado = estado
        self.notificar_observadores()