import customtkinter
from ui.options import option_frame
from .login_viewmodel import createuser

def login_frame():
    customtkinter.set_appearance_mode("dark")
    customtkinter.set_default_color_theme("dark-blue")

    root = customtkinter.CTk()
    root.geometry("500x400")

    def destroi_login():
        createuser(username.get(), password.get())
        root.destroy()
        option_frame.options()

    frame = customtkinter.CTkFrame(master=root)
    frame.pack(pady=20, padx=60, fill="both", expand=True)

    label = customtkinter.CTkLabel(master=frame, text="Tecnomotor", font=("Roboto", 24))
    label.pack(pady=12, padx=10)

    label = customtkinter.CTkLabel(master=frame, text="Easy RedMine Manager", font=("Consola", 16))
    label.pack(pady=12, padx=10)

    username = customtkinter.CTkEntry(master=frame, placeholder_text="Username")
    username.pack(pady=12, padx=10)

    password = customtkinter.CTkEntry(master=frame, placeholder_text="Password", show="💛")
    password.pack(pady=12, padx=10)

    button = customtkinter.CTkButton(master=frame, text="Login", command=destroi_login)

    button.pack(pady=12, padx=10)

    checkbox = customtkinter.CTkCheckBox(master=frame, text="Remember Me")
    checkbox.pack(pady=12, padx=10)

    root.mainloop()
