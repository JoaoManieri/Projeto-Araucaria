import time
import threading


def cronometro():

    tempo_inicial = time.time()
    while True:
        tempo_atual = time.time()
        tempo_passado = tempo_atual - tempo_inicial
        minutos = int(tempo_passado // 60)
        segundos = int(tempo_passado % 60)
        print(f"{minutos:02d}:{segundos:02d}")

        time.sleep(1)


def inti():

    threading.Thread(target=cronometro).start()


