from observers.myObservador import MyObservador
from observers.observavel import Observavel

class Controller:

    def __init__(self, init_state):
        self.state = init_state

        # Criar uma instância da classe Observável
        self.observavel = Observavel()

        # Criar uma instância da classe Observador
        self.observador = MyObservador()

        # Registrar o Observador para ser observado pela Observável
        self.observavel.adicionar_observador(self.observador)

    def setstate(self, state):
        # Alterar o estado da Observável para acionar a notificação para todos os observadores
        self.observavel.definir_estado(state)