from pynput import keyboard, mouse
import time

timeout = 60*1
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

while True:

    time.sleep(1)
    time_since_last_event = time.time() - last_event
    if time_since_last_event > timeout:
        print("Computer inactive")
    else:
        print("Computer active")