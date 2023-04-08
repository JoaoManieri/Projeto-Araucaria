import customtkinter

from ui.login.login_viewmodel import createuser
from ui.login.login_viewmodel import confirm_login
from ui.main_frame import main_view


def login_frame():
    customtkinter.set_appearance_mode("dark")
    customtkinter.set_default_color_theme("dark-blue")

    root = customtkinter.CTk()
    root.geometry("500x400")

    def certificate():
        if confirm_login(username.get(), password.get(), userLink.get()):
            destroi_login()
        else:
            label_error_login.pack(pady=12, padx=10)

    def destroi_login():
        if (checkbox.get() == 1): createuser(username.get(), password.get(), userLink.get())
        root.destroy()
        main_view.main_frame()

    frame = customtkinter.CTkFrame(master=root)
    frame.pack(pady=20, padx=60, fill="both", expand=True)

    label = customtkinter.CTkLabel(master=frame, text="Tecnomotor", font=("Roboto", 24))
    label.pack(pady=12, padx=10)

    label = customtkinter.CTkLabel(master=frame, text="Easy RedMine Manager", font=("Consola", 16))
    label.pack(pady=12, padx=10)

    username = customtkinter.CTkEntry(master=frame, placeholder_text="Username")
    username.configure(width=250)
    username.pack(pady=12, padx=10)

    password = customtkinter.CTkEntry(master=frame, placeholder_text="Password", show="💛")
    password.configure(width=250)
    password.pack(pady=12, padx=10)

    userLink = customtkinter.CTkEntry(master=frame, placeholder_text="Link da instituição")
    userLink.configure(width=250)
    userLink.pack(pady=12, padx=10)

    checkbox = customtkinter.CTkCheckBox(master=frame, text="Remember Me")
    checkbox.pack(pady=12, padx=30)

    button = customtkinter.CTkButton(master=frame, text="Login", command=certificate)
    button.pack(pady=12, padx=10)

    label_error_login = customtkinter.CTkLabel(master=frame, text_color="red",
                                               text="Algo deu errado,tente novamente...")

    root.mainloop()


