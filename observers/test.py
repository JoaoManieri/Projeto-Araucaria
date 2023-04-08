from observers.myObservador import MyObservador
from observers.observavel import Observavel

observable = Observavel()

observer1 = MyObservador()


observable.adicionar_observador(observer1)

observable.definir_estado(False)
