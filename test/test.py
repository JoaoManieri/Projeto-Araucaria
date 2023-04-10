from pynput import keyboard, mouse
import time

# inactivity timeout in seconds
timeout = 10

# last registered event
last_event = time.time()

# callback function for keyboard events
def keyboard_callback(event):
    global last_event
    last_event = time.time()

# callback function for mouse events
def mouse_callback(event):
    global last_event
    last_event = time.time()

# capturing keyboard and mouse events
keyboard_listener = keyboard.Listener(on_press=keyboard_callback)
mouse_listener = mouse.Listener(on_move=mouse_callback)

# starting the listeners
keyboard_listener.start()
mouse_listener.start()

# loop to check for inactivity
while True:
    # pause for 1 second
    time.sleep(1)

    # check the time since the last event
    time_since_last_event = time.time() - last_event

    # if the time since the last event is greater than the timeout, the computer is inactive
    if time_since_last_event > timeout:
        print("Computer inactive")
    else:
        print("Computer active")