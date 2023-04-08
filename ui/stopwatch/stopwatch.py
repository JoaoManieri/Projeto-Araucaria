import time
import threading
from PIL import Image
import ui.stopwatch.controllerst as ct

import customtkinter
import win32gui

from savewindows.repostgenerate import createreport
from ui.main_frame import main_view

from observers.myObservador import MyObservador
from observers.observavel import Observavel

def clock():
    # playimage = Image.open('res/play.png')
    # play_img = customtkinter.CTkImage(playimage)
    #
    # pauseimage = Image.open('res/pause.png')
    # pause_img = customtkinter.CTkImage(pauseimage)

    observable = Observavel()
    observer1 = MyObservador()
    observable.adicionar_observador(observer1)

    def on_closing():
        appTime.destroy()
        main_view.main_frame()
        createreport()


    def cronometro():
        # Inicia o tempo
        inicio = time.time()
        while observable.estado:
            # Calcula o tempo decorrido
            tempo_decorrido = time.time() - inicio

            # Converte segundos em horas, minutos e segundos
            horas = int(tempo_decorrido / 3600)
            minutos = int((tempo_decorrido % 3600) / 60)
            segundos = int(tempo_decorrido % 60)

            # Exibe o tempo decorrido
            label_timer.configure(text=f"{horas:02d}:{minutos:02d}:{segundos:02d}")

            # Espera 1 segundo antes de atualizar o tempo
            time.sleep(1)


    class ActiveWindow:

        def __init__(self):
            self.window = None

        def __get_foreground_window(self):
            while observable.estado:
                self.window = win32gui.GetWindowText(win32gui.GetForegroundWindow())
                print(self.window)
                time.sleep(1)

        def inti(self):
            return threading.Thread(target=self.__get_foreground_window)


    def starttime():
        threading.Thread(target=cronometro).start()


    def iniciar_relogio():
        print("foi")
        if ct.status == ct.PLAY:
            ActiveWindow().inti().start()
            starttime()
            butoon.configure(text="Parar tarefa")
            ct.status = ct.PAUSE
        else:
            # butoon.configure(image=play_img)
            butoon.configure(text="Iniciar tarefa")
            ct.status = ct.PLAY
            observable.definir_estado(False)
            on_closing()


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

    label_timer = customtkinter.CTkLabel(master=background, text="00:00:00")
    label_timer.grid(row=0, column=0, pady=8, padx=16)

    # butoon = customtkinter.CTkButton(master=background, image=play_img, text="", width=6, command=iniciar_relogio)
    butoon = customtkinter.CTkButton(master=background,  text="Iniciar tarefa", width=50, command=iniciar_relogio)
    butoon.grid(row=0, column=1, pady=8, padx=100)


    appTime.protocol("WM_DELETE_WINDOW", on_closing)

    appTime.mainloop()
