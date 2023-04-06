import time
import threading

import customtkinter


def cronometro():

    tempo_inicial = time.time()
    while True:
        tempo_atual = time.time()
        tempo_passado = tempo_atual - tempo_inicial
        horas = int(tempo_passado // 3600)
        minutos = int(tempo_passado % 3600)
        print(f"{horas:02d}:{minutos:02d}")

        time.sleep(1)


def starttime():

    threading.Thread(target=cronometro).start()


starttime()

customtkinter.set_appearance_mode("dark")
customtkinter.set_default_color_theme("blue")

appTime = customtkinter.CTk()
appTime.geometry("400x580")
appTime.title("Time-Task")

background = customtkinter.CTkFrame(master=appTime)
background.pack(pady=20, padx=60, fill="both", expand=True)

title = customtkinter.CTkLabel(master=background, text="Redmine Manager", font=("Roboto", 24))
title.pack(pady=12, padx=10)

label_chose_project = customtkinter.CTkLabel(master=background, text="Escolha a tarefa que deseja trabalhar hoje")
label_chose_project.pack(pady=12, padx=10)

optionmenu_1 = customtkinter.CTkOptionMenu(master=background, values=projectList)
optionmenu_1.pack(pady=12, padx=10)
optionmenu_1.set("Escolha uma tarefa")

startButton = customtkinter.CTkButton(master=background, text="Start task", command=saveTasks)
startButton.pack(pady=12, padx=10)

appTime.mainloop()