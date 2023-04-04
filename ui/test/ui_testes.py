# import tkinter as tk
#
# class JanelaPrincipal:
#     def __init__(self, master):
#         self.master = master
#         self.master.title("Janela Principal")
#
#         self.botao_nova_janela = tk.Button(self.master, text="Abrir nova janela", command=self.abrir_nova_janela)
#         self.botao_nova_janela.pack()
#
#     def abrir_nova_janela(self):
#         nova_janela = tk.Toplevel(self.master)
#         self.master.withdraw()
#         JanelaSecundaria(nova_janela)
#
# class JanelaSecundaria:
#     def __init__(self, master):
#         self.master = master
#         self.master.title("Janela Secundária")
#
#         self.botao_fechar = tk.Button(self.master, text="Fechar janela", command=self.fechar_janela)
#         self.botao_fechar.pack()
#
#     def fechar_janela(self):
#         self.master.destroy()
#         JanelaPrincipal(self.master.master)
#
# root = tk.Tk()
# JanelaPrincipal(root)
# root.mainloop()

###############################################################################################################################

# import customtkinter as CTK
#
#
# class App(CTK.CTk):
#     def __init__(self):
#         super().__init__()
#
#         self.bar = CTK.CTkProgressBar(master=self.checkbox,
#                                   orientation='horizontal',
#                                   mode='determinate')
#
#         self.bar.grid(row=10, column=0, pady=10, padx=20, sticky="n")
#
#         # Set default starting point to 0
#         self.bar.set(0)
#
#     def test(self):
#         n = 500
#         iter_step = 1 / n
#         progress_step = iter_step
#         self.bar.start()
#
#         for x in range(500):
#             self.bar.set(progress_step)
#             progress_step += iter_step
#             self.update_idletasks()
#         self.bar.stop()
#
#
#
# App().mainloop()