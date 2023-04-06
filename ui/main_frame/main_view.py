import customtkinter
import ui.main_frame.mainview_viewmodel as mvvm

def main_frame():

    projectList = mvvm.getAllProjects()

    def saveTasks():
        mvvm.saveTasks(optionmenu_1.get())

    customtkinter.set_appearance_mode("dark")
    customtkinter.set_default_color_theme("blue")

    app = customtkinter.CTk()
    app.geometry("400x580")
    app.title("Redmine Manager")

    topFrame = customtkinter.CTkFrame(master=app)
    topFrame.pack(pady=20, padx=60, fill="both", expand=True)

    title = customtkinter.CTkLabel(master=topFrame, text="Redmine Manager", font=("Roboto", 24))
    title.pack(pady=12, padx=10)

    label_chose_project = customtkinter.CTkLabel(master=topFrame, text="Escolha a tarefa que deseja trabalhar hoje")
    label_chose_project.pack(pady=12, padx=10)

    optionmenu_1 = customtkinter.CTkOptionMenu(master=topFrame, values=projectList)
    optionmenu_1.pack(pady=12, padx=10)
    optionmenu_1.set("Escolha uma tarefa")

    startButton = customtkinter.CTkButton(master=topFrame, text="Start task", command=saveTasks)
    startButton.pack(pady=12, padx=10)

    app.mainloop()
