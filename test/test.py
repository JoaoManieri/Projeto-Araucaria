import tkinter as tk


class PausePlayToggleButton(tk.Checkbutton):
    def __init__(self, master=None, cnf={}, **kw):
        super().__init__(master, cnf, **kw)
        self.paused = True
        self.play_img = tk.PhotoImage(file='res/play.png')
        self.pause_img = tk.PhotoImage(file='res/pause.png')
        self.config(image=self.pause_img, selectimage=self.play_img, indicatoron=False, command=self.toggle)

    def toggle(self):
        self.paused = not self.paused
        if self.paused:
            self.config(image=self.pause_img, selectimage=self.play_img)
        else:
            self.config(image=self.play_img, selectimage=self.pause_img)


class CounterApp:
    def __init__(self):
        self.count = 0

        self.root = tk.Tk()
        self.root.title('Contador')
        self.root.geometry('300x200')

        self.label = tk.Label(self.root, text='0')
        self.label.pack(pady=20)

        self.button = PausePlayToggleButton(self.root)
        self.button.pack()

        self.root.after(1000, self.update_counter)

        self.root.mainloop()

    def update_counter(self):
        if not self.button.paused:
            self.count += 1
            self.label.config(text=str(self.count))
        self.root.after(1000, self.update_counter)


if __name__ == '__main__':
    app = CounterApp()
