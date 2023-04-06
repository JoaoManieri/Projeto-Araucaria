import time
import threading

import customtkinter
import win32gui


def cronometro():
    # Inicia o tempo
    inicio = time.time()
    while True:

        # Calcula o tempo decorrido
        tempo_decorrido = time.time() - inicio

        # Converte segundos em horas, minutos e segundos
        horas = int(tempo_decorrido / 3600)
        minutos = int((tempo_decorrido % 3600) / 60)
        segundos = int(tempo_decorrido % 60)

        # Exibe o tempo decorrido
        label_chose_project.configure(text=f"{horas:02d}:{minutos:02d}:{segundos:02d}")

        # Espera 1 segundo antes de atualizar o tempo
        time.sleep(1)

class ActiveWindow:

    def __init__(self):
        self.window = None

    def __get_foreground_window(self):
        while True:
            self.window = win32gui.GetWindowText(win32gui.GetForegroundWindow())
            print(self.window)
            time.sleep(1)

    def inti(self):
        return threading.Thread(target=self.__get_foreground_window)

def starttime():

    threading.Thread(target=cronometro).start()


customtkinter.set_appearance_mode("dark")
customtkinter.set_default_color_theme("blue")

appTime = customtkinter.CTk()
appTime.geometry("300x100")
appTime.wm_attributes("-topmost", 1)
appTime.title("Time-Task")

title = customtkinter.CTkLabel(master=appTime, text="Redmine Manager", font=("Roboto", 12))
title.pack(pady=3, padx=2)

background = customtkinter.CTkFrame(master=appTime)
background.pack(pady=3, padx=2, fill="both", expand=True)


label_chose_project = customtkinter.CTkLabel(master=background, text="Escolha a tarefa que deseja trabalhar hoje")
label_chose_project.pack(pady=12, padx=10)

starttime()
ActiveWindow().inti().start()

appTime.mainloop()



