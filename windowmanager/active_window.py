import threading
from time import sleep

import win32gui

from savewindows.repostgenerate import add_element

"""
This class is responsible for checking the title of the windows that have focus.
"""
class ActiveWindow:

    def __init__(self):
        self.window = None

    def __get_foreground_window(self):
        while True:
            self.window = win32gui.GetWindowText(win32gui.GetForegroundWindow())
            print('pre add elemnt')
            add_element(self.window)
            print(self.window)
            sleep(1)

    def inti(self):
        return threading.Thread(target=self.__get_foreground_window)

ActiveWindow().inti().start()