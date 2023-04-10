import time
import threading
from PIL import Image

from pynput import keyboard, mouse

import savewindows.repostgenerate
import ui.stopwatch.controllerst as ct

import customtkinter
import win32gui

from savewindows.repostgenerate import createreport, add_element
from ui.main_frame import main_view

from observers.myObservador import MyObservador
from observers.observavel import Observavel

def clock():

    # playimage = Image.open('res/play.png')
    # play_img = customtkinter.CTkImage(playimage)
    #
    # pauseimage = Image.open('res/pause.png')
    # pause_img = customtkinter.CTkImage(pauseimage)

    #timeout para tempo inativo
    timeout = 60 * 1
    last_event = time.time()

    def keyboard_callback(event=None):
        global last_event
        last_event = time.time()

    def mouse_callback(event=None):
        global last_event
        last_event = time.time()

    keyboard_listener = keyboard.Listener(on_press=keyboard_callback)
    mouse_listener = mouse.Listener(on_move=mouse_callback)

    keyboard_listener.start()
    mouse_listener.start()


    observable = Observavel()
    observer1 = MyObservador()
    observable.adicionar_observador(observer1)

    def on_closing():
        appTime.destroy()
        createreport()
        main_view.main_frame()


    def cronometro():
        # Inicia o tempo
        inicio = time.time()
        savewindows.repostgenerate.initTime = inicio
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
                time.sleep(1)

                time_since_last_event = time.time() - last_event
                if time_since_last_event > timeout:
                    add_element("inativo")
                else:
                    print(self.window)
                    add_element(self.window)

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
