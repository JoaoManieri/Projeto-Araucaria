import os

from login.login_frame import login_frame
from ui.main_frame.main_view import main_frame

path = '../data/info.json'

if os.path.isfile(path):
    arquivo = open(path, 'r')
    conteudo = arquivo.read()
    arquivo.close()

    if 'user_name' in conteudo:
        main_frame()
    else:
        login_frame()

else:
    login_frame()
