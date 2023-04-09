# My module
import json

windows = []

def add_element(process):
    windows.append(process)

def createreport():
    arquivo = open('data/tasks.json', 'r')
    conteudo = json.loads(arquivo.read())
    arquivo.close()
    print("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ---ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ")
    print(windows)
    arquivo = open('out/logs.txt', 'a')
    arquivo.write(f'{conteudo["tasks"]} \n ')
    for window in windows:
        arquivo.write(f'{window} \n ')
        print(window)

    arquivo.close()
