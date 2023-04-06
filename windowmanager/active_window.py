import threading
from time import sleep

import win32gui

"""
This class is responsible for checking the title of the windows that have focus.
"""
class ActiveWindow:

    def __init__(self):
        self.window = None

    def __get_foreground_window(self):
        while True:
            self.window = win32gui.GetWindowText(win32gui.GetForegroundWindow())
            print(self.window)
            sleep(1)

    def inti(self):
        return threading.Thread(target=self.__get_foreground_window)

ActiveWindow().inti().start()