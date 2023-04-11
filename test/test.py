import time

from pynput import mouse, keyboard
import datetime

# Definindo o tempo máximo de inatividade (em segundos)
tempo_max_inatividade = 5

# Definindo a última atividade como o momento atual
ultima_atividade = datetime.datetime.now()

def on_move(x, y):
    global ultima_atividade
    ultima_atividade = datetime.datetime.now()

def on_click(x, y, button, pressed):
    global ultima_atividade
    ultima_atividade = datetime.datetime.now()

def on_scroll(x, y, dx, dy):
    global ultima_atividade
    ultima_atividade = datetime.datetime.now()

def on_press(key):
    global ultima_atividade
    ultima_atividade = datetime.datetime.now()

def on_release(key):
    global ultima_atividade
    ultima_atividade = datetime.datetime.now()

# Monitorando eventos do teclado e mouse
with mouse.Listener(on_move=on_move, on_click=on_click, on_scroll=on_scroll) as listener_mouse:
    with keyboard.Listener(on_press=on_press, on_release=on_release) as listener_keyboard:
        while True:
            # Verificando se o tempo de inatividade é maior que o tempo máximo
            if (datetime.datetime.now() - ultima_atividade).total_seconds() > tempo_max_inatividade:
                print('Inatividade detectada!')
            else:
                print("Em trabalho")
                # Fazer algo aqui, como enviar uma mensagem ou executar alguma ação
            # Esperando um segundo antes de verificar novamente
            time.sleep(1)
