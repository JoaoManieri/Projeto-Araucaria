import tkinter
import customtkinter

def options():

    def button_callback():
        print("Button click", combobox_1.get())

    def slider_callback(value):
        print(value)
        progressbar_1.set(value)

    customtkinter.set_appearance_mode("dark")
    customtkinter.set_default_color_theme("blue")

    app = customtkinter.CTk()
    app.geometry("400x580")
    app.title("Options")

    frame_1 = customtkinter.CTkFrame(master=app)
    frame_1.pack(pady=20, padx=60, fill="both", expand=True)
    # frame_1.grid(pady=20, padx=10,row=0, column=0)

    frame_2 = customtkinter.CTkFrame(master=app)
    frame_2.pack(pady=20, padx=60, fill="both", expand=True)
    # frame_2.grid(pady=20, padx=10,row=0, column=1)

    label_1 = customtkinter.CTkLabel(master=frame_1, justify=tkinter.LEFT)
    label_1.pack(pady=12, padx=10)

    progressbar_1 = customtkinter.CTkProgressBar(master=frame_1)
    label_1.pack(pady=12, padx=10)

    button_1 = customtkinter.CTkButton(master=frame_1, command=button_callback)
    button_1.pack(pady=12, padx=10)

    slider_1 = customtkinter.CTkSlider(master=frame_1, command=slider_callback, from_=0, to=1)
    slider_1.pack(pady=12, padx=10)
    slider_1.set(0.5)

    entry_1 = customtkinter.CTkEntry(master=frame_1, placeholder_text="CTKEntry")
    entry_1.pack(pady=12, padx=10)

    optionmenu_1 = customtkinter.CTkOptionMenu(master=frame_1, values=["option 1", "option 2", "any"])
    optionmenu_1.pack(pady=12, padx=10)
    optionmenu_1.set("CTkOptionMenu")

    combobox_1 = customtkinter.CTkComboBox(master=frame_1, values=["combo 1", "combo 2", "any"])
    combobox_1.pack(pady=12, padx=10)
    combobox_1.set("CTkComboBox")  #### Be atention this

    checkbox_1 = customtkinter.CTkCheckBox(master=frame_1)
    checkbox_1.pack(pady=12, padx=10)

    radio_button_var = tkinter.IntVar(value=2)

    radio_button_1 = customtkinter.CTkRadioButton(master=frame_2, variable=radio_button_var, value=1)
    radio_button_1.pack(pady=12, padx=10)

    radio_button_2 = customtkinter.CTkRadioButton(master=frame_2, variable=radio_button_var, value=2)
    radio_button_2.pack(pady=12, padx=10)

    switch_1 = customtkinter.CTkSwitch(master=frame_2, text="This")
    switch_1.pack(pady=12, padx=10)

    app.mainloop()




